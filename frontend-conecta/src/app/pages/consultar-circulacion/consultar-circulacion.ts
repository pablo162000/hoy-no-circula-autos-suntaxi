import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MATERIAL_IMPORTS } from '../../shared/material';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ResultadoConfirmacionDialog } from '../../shared/resultado-confirmacion-dialog/resultado-confirmacion-dialog';
import { Auto } from '../../services/auto';
@Component({
  selector: 'app-consultar-circulacion',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ...MATERIAL_IMPORTS
  ],
  templateUrl: './consultar-circulacion.html',
  styleUrl: './consultar-circulacion.scss',
})
export class ConsultarCirculacion {

  form = new FormGroup({
    placa: new FormControl('', [
      Validators.required,
      Validators.pattern(/^[A-Z]{3}\d{4}$/)
    ]),
    fechaHora: new FormControl('', Validators.required)
  });

  constructor(
    private dialog: MatDialog,
    private autoService: Auto
  ) { }

  consultar() {
    if (this.form.invalid) return;


    const placa = this.form.value.placa!;
    const fechaHora = this.formatearFecha(this.form.value.fechaHora!);

    this.autoService.consultarCirculacion(placa, fechaHora).subscribe({
      next: (response) => {
        this.dialog.open(ResultadoConfirmacionDialog, {
          width: '420px',
          data: response,
          panelClass: 'square-dialog'
        });
      },
      error: (error) => {
        const mensaje = error?.error?.message || 'Ocurrió un error inesperado';

        this.dialog.open(ResultadoConfirmacionDialog, {
          width: '420px',
          data: {
            error: true,
            message: mensaje
          },
          panelClass: 'square-dialog'
        });
      }
    });
  }

  private formatearFecha(fecha: string): string {
    return fecha.length === 16 ? `${fecha}:00` : fecha;
  }

}
