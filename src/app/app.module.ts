import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PortadaComponent } from './components/portada/portada.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { WikiComponent } from './components/wiki/wiki.component';
import { VillasComponent } from './components/villas/villas.component';
import { ClanesComponent } from './components/clanes/clanes.component';
import { WikiIntroComponent } from './components/wiki/wiki-intro/wiki-intro.component';
import { WikiListadoComponent } from './components/wiki/wiki-listado/wiki-listado.component';
import { WikiVerMasComponent } from './components/wiki/wiki-ver-mas/wiki-ver-mas.component';

@NgModule({
  declarations: [
    AppComponent,
    PortadaComponent,
    NavbarComponent,
    WikiComponent,
    VillasComponent,
    ClanesComponent,
    WikiIntroComponent,
    WikiListadoComponent,
    WikiVerMasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
