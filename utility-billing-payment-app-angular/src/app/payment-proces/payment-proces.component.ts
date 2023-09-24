import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BillServiceService } from '../bill-service.service';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-payment-proces',
  templateUrl: './payment-proces.component.html',
  styleUrls: ['./payment-proces.component.css']
})
export class PaymentProcesComponent implements OnInit {
  billId!: number;
  billData: any;
  constructor(private route: ActivatedRoute,
    private billService: BillServiceService,
    private transactionService: TransactionService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.billId = +params['billId']; 
      console.log(this.billId);
      // Fetch bill data based on this.billId
      this.billData = this.billService.getBillById(this.billId).subscribe((response) => {
        console.log(response)

      },(error)=>{
        console.log(error)
      })
    })
    this.getAllTransactions()
  }
  selectedTab = 'nav-tab-card'

  selectedOption: string = 'debit-card';

  // Add your payment processing logic here if needed.

  // Function to set the selected payment option.
  selectPaymentOption(option: string) {
    this.selectedOption = option;
  }
  amount = 300;
  isCard = false;
  isPayment = true;
  isBank = true;

  toogleCard() {
    this.isCard = false;
    this.isPayment = true;
    this.isBank = true;
    this.selectedTab = 'nav-tab-card'
  }

  tooglePayment() {
    this.isCard = true;
    this.isPayment = false;
    this.isBank = true;
    this.selectedTab = 'nav-tab-paypal'
  }

  toogleBank() {
    this.isCard = true;
    this.isPayment = true;
    this.isBank = false;
    this.selectedTab = 'nav-tab-bank'
  }
  transactions: any = [];
  onPayment(method: any) {
    const jsonobj = {
      "billId": this.billId,
      "paymentMethod": method,
      "customerId": sessionStorage.getItem("customerId")
    }
    console.log(jsonobj);

    this.transactionService.addTransaction(jsonobj).subscribe((response) => {
      console.log(response)
      this.transactions = response;
    })
  }

  getAllTransactions() {
    this.transactionService.getAllTransactions(sessionStorage.getItem("customerId"))
      .subscribe((response) => {
        console.log(response)
        this.transactions = response;
      })
  }


}
