import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  constructor(private service: TransactionService) { }

  ngOnInit(): void {
  }

  transactions:any=[]

  getAllTransactions(){
    this.service.getAllTransactions(sessionStorage.getItem("customerId")).subscribe((response=>{
      this.transactions=response;
    }))
  }


}
