import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser/src/browser/title';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  
  tasks = ["task1","task2","task3"];
  title = "list of tasks";
  constructor() { 
    
  }

  ngOnInit() {
  }

}
