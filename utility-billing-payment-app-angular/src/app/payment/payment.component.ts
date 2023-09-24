import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  selectedTab = 'nav-tab-card'
  constructor() { }

  ngOnInit(): void {
  }

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


}
