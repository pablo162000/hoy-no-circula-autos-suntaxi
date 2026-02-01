import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MATERIAL_IMPORTS } from './shared/material';

@Component({
  selector: 'app-root',
  imports: [RouterLink,
    RouterOutlet,
    ...MATERIAL_IMPORTS],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend-conecta');
}
