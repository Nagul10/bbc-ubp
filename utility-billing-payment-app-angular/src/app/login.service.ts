import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private login: HttpClient) { }

  generateOtpUrl: string = "*********";
  baseUrl: string = "http://localhost:8080/login/";

  genrateOtp(customerId: number) {
    const params = { customerId: customerId.toString() };
    return this.login.post(`http://localhost:8080/login/generate-otp/${customerId}`, null);
  }

  loginCustomer(obj: any) {
    return this.login.post(`${this.baseUrl}login-otp`, obj);
  }
}
