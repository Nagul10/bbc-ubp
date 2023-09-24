import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http:HttpClient) { }

  addTransaction(jsonobj:any){
    return this.http.post("http://localhost:8080/transaction/new-transaction",jsonobj)
  }

  getAllTransactions(customerId:any){
    return this.http.get(`http://localhost:8080/transaction/get-all-transaction/${customerId}`)
  }
}
