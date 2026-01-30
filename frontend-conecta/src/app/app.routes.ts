import { Routes } from '@angular/router';
export const routes: Routes = [{
    path: '',
    redirectTo: 'registro',
    pathMatch: 'full'
},
{
    path: 'registro',
    loadComponent: () =>
        import('./pages/register-auto/register-auto')
            .then(m => m.RegisterAuto)
},
{
    path: 'consulta',
    loadComponent: () =>
        import('./pages/consultar-circulacion/consultar-circulacion')
            .then(m => m.ConsultarCirculacion)
}];
