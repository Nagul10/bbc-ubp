import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  EMAIL_PATTERN = "";

  constructor(private service: LoginService, private route: Router) { }

  ngOnInit(): void {
  }
  isHidden = true;
  loginButton = true;
  otpButton = false;
  customerId: string = '';
  otp: string = '';
  otpBox = true;
  showOtpInput: boolean = false;

  isAuthenticated = true;

  isShow = true;
  incorrect = ""


  title = "BBC LOGIN"
  generateOtp(id: any): void {
    this.otpButton = true;
    this.loginButton = false;
    this.otpBox = false;
    sessionStorage.setItem("customerId", id)
    this.service.genrateOtp(id as number).subscribe((response) => {
      console.log(response);
    })

  }

  onLogin(id: any, otp: any) {
    this.service.loginCustomer({ "customerId": id, "otp": otp }).subscribe((response) => {
      if (response === true) {
        console.log(response);
        this.route.navigate(['/home'])
      }

    },
      (error) => {
        console.error('Error:', error);
      })
  }

  onSubmit(f: any) {

  }
  onShow() {

  }
  logout() {

  }

}
