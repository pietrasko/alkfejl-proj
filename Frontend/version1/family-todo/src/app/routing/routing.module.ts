import { NgModule } from '@angular/core';
import { RouterModule, Routes }   from '@angular/router';
import { CommonModule } from '@angular/common';

import { AppComponent } from '../app.component';
import { LoginComponent } from '../login/login.component';
import { Component } from '@angular/core/src/metadata/directives';
import { WelcomeComponent } from '../welcome/welcome.component';
import { RegComponent } from '../reg/reg.component';
import { TaskListComponent } from '../task-list/task-list.component';
import { TaskManComponent } from '../task-man/task-man.component';

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
  },
  {
    path: 'task',
    component: TaskListComponent
  },
  {
    path: 'task/man',
    component: TaskManComponent
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
