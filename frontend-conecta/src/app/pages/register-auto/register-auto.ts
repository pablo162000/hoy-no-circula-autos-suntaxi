import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MATERIAL_IMPORTS } from '../../shared/material';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Auto } from '../../services/auto';
import { ConfirmDialog } from '../../shared/confirm-dialog/confirm-dialog';
@Component({
  selector: 'app-register-auto',
  imports: [CommonModule,
    ...MATERIAL_IMPORTS,
    ReactiveFormsModule],
  templateUrl: './register-auto.html',
  styleUrl: './register-auto.scss',
})
export class RegisterAuto {

  form = new FormGroup({
    placa: new FormControl('', [
      Validators.required,
      Validators.pattern(/^[A-Z]{3}\d{4}$/)
    ]),
    color: new FormControl('', Validators.required),
    modelo: new FormControl('', Validators.required),
    chasis: new FormControl('', Validators.required)
  });

  constructor(
    private dialog: MatDialog,
    private autoService: Auto
  ) { }


  guardar() {
    const dialogRef = this.dialog.open(ConfirmDialog, {
      width: '350px',
      data: {
        message: '¿Estás seguro de guardar el vehículo?'
      },
      panelClass: 'square-dialog'
    });

    dialogRef.afterClosed().subscribe(confirmado => {
      if (confirmado) {
        this.autoService.guardarAuto(this.form.value)
          .subscribe({
            next: () => {
              alert('Vehículo guardado correctamente');
              this.form.reset();
            },
            error: () => {
              alert('Error al guardar el vehículo');
            }
          });
      }
    });
  }
}
