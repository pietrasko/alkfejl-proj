import { Injectable } from '@angular/core';
import { User } from './user';
import { AuthService } from './auth.service';
import { Task } from './task';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'})
};

interface FR<T> {
  total: number,
  limit: number,
  skip: number,
  data: T[]
};

@Injectable()
export class TaskService {

  private serverUser = "https://localhost:8080/api/user";
  private serverTask = "https://localhost:8080/api/task";
  tasks:    Task[] = [];

  constructor(
    private authServ: AuthService,
    private http:     HttpClient
  ) { this.tasks = []; }

  getUser(): User {
    return this.authServ.getUser;
  }


  getTasks(): Promise<Task[]> {
    console.log(this.getUser().role);
    if(this.getUser().role === "ADMIN")
      return this.http.get<Task[]>(this.serverTask + "/tasks").toPromise();
    else
      return this.http.get<Task[]>(this.serverUser + "/tasks").toPromise();
    
  }
 

}
