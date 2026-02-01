import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MATERIAL_IMPORTS } from '../../shared/material';


@Component({
  selector: 'app-resultado-confirmacion-dialog',
  imports: [CommonModule, ...MATERIAL_IMPORTS],
  templateUrl: './resultado-confirmacion-dialog.html',
  styleUrl: './resultado-confirmacion-dialog.scss',
})
export class ResultadoConfirmacionDialog {
    constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}


}
