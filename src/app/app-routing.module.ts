import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PortadaComponent } from './components/portada/portada.component';
import { VillasComponent } from './components/villas/villas.component';
import { WikiComponent } from './components/wiki/wiki.component';

const routes: Routes = [
  { path: 'inicio', component: PortadaComponent },
  { path: 'wiki', component: WikiComponent },
  { path: 'villas', component: VillasComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
