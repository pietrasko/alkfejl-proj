import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatToolbarModule, MatButtonModule, MatMenuModule, MatIconModule,
  MatFormFieldModule, MatInputModule,
  MatButtonToggleModule, MatListModule
} from "@angular/material";
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";

import { RoutingModule } from "./routing/routing.module";
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TasksComponent } from './tasks/tasks.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { AuthService } from './auth.service';
import { fakeBackendProvider } from './fakebackend';
import { MockBackend } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';
import { RegComponent } from './reg/reg.component';
import { TaskService } from './task.service';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskManComponent } from './task-man/task-man.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    WelcomeComponent,
    NavbarComponent,
    TasksComponent,
    AdminComponent,
    UserComponent,
    RegComponent,
    TaskListComponent,
    TaskManComponent
  ],
  imports: [
    RoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    FlexLayoutModule,
    MatButtonToggleModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    TaskService,
    fakeBackendProvider,
    MockBackend,
    BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
