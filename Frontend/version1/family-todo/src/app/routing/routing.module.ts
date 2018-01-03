import { NgModule } from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';
import { CommonModule } from '@angular/common';

import { AppComponent } from '../app.component';
import { LoginComponent } from '../login/login.component';
import { Component } from '@angular/core/src/metadata/directives';
import { WelcomeComponent } from '../welcome/welcome.component';
import { RegComponent } from '../reg/reg.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: WelcomeComponent
  },
  {
    path: 'register',
    component: RegComponent
  },
  {
    path: 'logout',
    component: WelcomeComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
