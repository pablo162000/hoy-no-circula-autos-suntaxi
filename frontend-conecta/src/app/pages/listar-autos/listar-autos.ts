import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';

import { MatTableDataSource } from '@angular/material/table';
import { Auto } from '../../services/auto';

@Component({
  selector: 'app-listar-autos',
  
  imports: [
   CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatCardModule
  ]
  ,
  templateUrl: './listar-autos.html',
  styleUrl: './listar-autos.scss',
})
export class ListarAutos implements OnInit {
  displayedColumns: string[] = ['id', 'placa', 'chasis', 'color', 'modelo'];
  dataSource = new MatTableDataSource<any>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private autoService: Auto) {}

  ngOnInit(): void {
    this.cargarAutos();
  }

  cargarAutos() {
    this.autoService.listarAutos().subscribe({
      next: (autos) => {
        this.dataSource.data = autos;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    });
  }

  aplicarFiltro(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    this.dataSource.filter = value.trim().toLowerCase();
  }
}
