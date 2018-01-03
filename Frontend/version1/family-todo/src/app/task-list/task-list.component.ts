import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { User } from '../user';
import { Task } from '../task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  private user: User;
  tasks:    Task[] = [];

  constructor(    
    private taskServ: TaskService,
    
  ) { this.tasks = []; }


  async ngOnInit() {
    this.user = this.taskServ.getUser();
    this.tasks = await this.taskServ.getTasks();
    console.log(JSON.stringify(this.tasks))
  }

}
