import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from "./app.component";
import { MainPageComponent } from './main-page/main-page.component';
import { Routes, RouterModule } from "@angular/router";

//Material
import {MatTableModule, MatTabsModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { CreateUpdateComponent } from './create-update/create-update.component';

const routes: Routes = [
  {
    path: '',
    component: MainPageComponent
  }
];

@NgModule({
  declarations: [
    MainPageComponent,
    AppComponent,
    CreateUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    //Material
    BrowserAnimationsModule,
    MatTabsModule,
    MatTableModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
