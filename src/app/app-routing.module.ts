import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClanesVerMasComponent } from './components/clanes/clanes-ver-mas/clanes-ver-mas.component';
import { ClanesComponent } from './components/clanes/clanes.component';
import { PortadaComponent } from './components/portada/portada.component';
import { VillasVerMasComponent } from './components/villas/villas-ver-mas/villas-ver-mas.component';
import { VillasComponent } from './components/villas/villas.component';
import { WikiVerMasComponent } from './components/wiki/wiki-ver-mas/wiki-ver-mas.component';
import { WikiComponent } from './components/wiki/wiki.component';

const routes: Routes = [
  { path: 'inicio', component: PortadaComponent },
  { path: 'wiki', component: WikiComponent },
  { path: 'wiki/:nombre', component: WikiVerMasComponent },
  { path: 'villas', component: VillasComponent },
  { path: 'villas/:nombre', component: VillasVerMasComponent },
  { path: 'clanes', component: ClanesComponent },
  { path: 'clanes/:nombre', component: ClanesVerMasComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
