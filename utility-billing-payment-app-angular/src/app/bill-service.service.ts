import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BillServiceService {

  constructor(private bill: HttpClient) { }

  getBillUrl: string = "http://localhost:8080/bill/get-all-bills";
  getBillByIdUrl: string = "http://localhost:8080/bill/get-bills-by-id/";

  getAllBills() {
    return this.bill.get(this.getBillUrl)
  }

  getBillById(id: any) {
    return this.bill.get(`http://localhost:8080/bill/get-bill/${id}`)
  }


}
