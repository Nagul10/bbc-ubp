import { Component, OnInit } from '@angular/core';
import { BillServiceService } from '../bill-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-bill',
  templateUrl: './list-bill.component.html',
  styleUrls: ['./list-bill.component.css']
})
export class ListBillComponent implements OnInit {

  constructor(private billService: BillServiceService, private router: Router) { }

  bills: any[] = [];

  ngOnInit(): void {
    this.getAllBills();
  }
  getAllBills() {
    console.log(sessionStorage.getItem("customerId"))
    this.billService.getBillById(sessionStorage.getItem("customerId")).subscribe(
      (response: any) => {
        console.log(response)
        this.bills = response;
      },
      (error) => {
        console.error("Error Fetching Bills : ", error);
      }
    )
  }

  redirectToPayment(billId: number) {
    sessionStorage.setItem("billId",billId.toString());
    this.router.navigate(['/payment', billId]);
  }

  getBillsById() {
    this.billService.getAllBills().subscribe(
      (response: any) => {
        console.log(response)
        this.bills = response;
      },
      (error) => {
        console.error("Error Fetching Bills : ", error);
      }
    )
  }



}
