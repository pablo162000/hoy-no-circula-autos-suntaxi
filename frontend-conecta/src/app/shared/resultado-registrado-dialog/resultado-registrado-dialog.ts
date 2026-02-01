import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MATERIAL_IMPORTS } from '../../shared/material';

@Component({
  selector: 'app-resultado-registrado-dialog',
  imports: [CommonModule, ...MATERIAL_IMPORTS],
  templateUrl: './resultado-registrado-dialog.html',
  styleUrl: './resultado-registrado-dialog.scss',
})
export class ResultadoRegistradoDialog {
    constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}

}
