import { Injectable } from '@angular/core';
import { User } from './user';
import { AuthService } from './auth.service';
import { Task } from './task';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/add/operator/map';
import { MatDatepickerContent } from '@angular/material';

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

  private serverUser = 'https://localhost:8080/api/user/';
  private serverTask = 'https://localhost:8080/api/task/';
  tasks: Task[] = [
    {id: 1, user: "Karcsi" , deadline: new Date(Date.now()), task_description: 'Do this Do that', completed: true, completion_confirmed: false},
    {id: 2, user: "Karcsi", deadline: new Date(Date.now()), task_description: 'Do this Do that', completed: true, completion_confirmed: false},
    {id: 3, user: "Julcsi", deadline: new Date(Date.now()), task_description: 'Do this Do that', completed: true, completion_confirmed: false},
    {id: 4, user: "Bela", deadline: new Date(Date.now()), task_description: 'Do this Do that', completed: true, completion_confirmed: false},
  ];
  

  constructor(
    private http:     HttpClient
  ) {  }


  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.serverUser + 'tasks');
  }
 

}

