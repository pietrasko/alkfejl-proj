import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-reg',
  templateUrl: './reg.component.html',
  styleUrls: ['./reg.component.css']
})
export class RegComponent implements OnInit {

  user: User = new User();
  message: string = '';
  isInvalid: boolean;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  async register(form: NgForm){
    if (form.invalid) {
      return;
    }
    try {
      this.message = "Try to login!";
      await this.authService.register(this.user);
      this.isInvalid = false;
      this.router.navigate( ['/login']);
    }
    catch (err) {
      this.message = "Registration failed!";
      this.isInvalid = true;
      console.log(err);
    }
  }

}
