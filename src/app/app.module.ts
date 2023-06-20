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
import { VillasIntroComponent } from './components/villas/villas-intro/villas-intro.component';
import { VillasListadoComponent } from './components/villas/villas-listado/villas-listado.component';
import { VillasVerMasComponent } from './components/villas/villas-ver-mas/villas-ver-mas.component';
import { ClanesIntroComponent } from './components/clanes/clanes-intro/clanes-intro.component';
import { ClanesListadoComponent } from './components/clanes/clanes-listado/clanes-listado.component';
import { ClanesVerMasComponent } from './components/clanes/clanes-ver-mas/clanes-ver-mas.component';

import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    WikiVerMasComponent,
    VillasIntroComponent,
    VillasListadoComponent,
    VillasVerMasComponent,
    ClanesIntroComponent,
    ClanesListadoComponent,
    ClanesVerMasComponent,
    LoginComponent,
    RegistroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
