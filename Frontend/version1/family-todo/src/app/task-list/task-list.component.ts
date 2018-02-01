import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { User } from '../user';
import { Task } from '../task';
import { AuthService } from '../auth.service';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';


@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  private user: User;
  private displayedColumns = ['completed','user', 'confirm', 'description', 'deadline'];
  private tasks: MatTableDataSource<Task>;
  selection = new SelectionModel<Task>(true, []);

  constructor(    
    private taskServ: TaskService,
    private authService: AuthService,
  ) {  }


  ngOnInit() {
    /*this.taskServ.getTasks()
      .subscribe(tasks => {
        ;      
      });
   // console.log(JSON.stringify(this.tasks));*/
   this.tasks = new MatTableDataSource<Task>(this.taskServ.tasks);
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.tasks.data.length;
    return numSelected == numRows;
  }
  
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.tasks.data.forEach(row => this.selection.select(row));
  }

}
