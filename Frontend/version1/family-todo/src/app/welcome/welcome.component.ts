import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  
  private user: User;
  private greeting: string;

  constructor(private autServ: AuthService) { 
    this.user = this.autServ.user;
    if(this.user)
      this.greeting = this.user.name;
    else
      this.greeting = "stranger";
  }

  ngOnInit() {

  }

}
