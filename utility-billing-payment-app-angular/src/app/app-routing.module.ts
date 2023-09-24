import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoginComponent } from './login/login.component';
import { ListBillComponent } from './list-bill/list-bill.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentProcesComponent } from './payment-proces/payment-proces.component';
import { TransactionComponent } from './transaction/transaction.component';
import { PaymentSuccessComponent } from './payment-success/payment-success.component';


const routes: Routes = [
  {
    path: "", component: LoginComponent
  },
  {
    path: "home",
    component: HomeComponent
  },
  {
    path: "listbills",
    component: ListBillComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "invoice",
    component: InvoiceComponent
  },
  {
    path: "payment",
    component: PaymentProcesComponent
  },
  {
    path: "transactions",
    component: TransactionComponent
  },
  {
    path: "success",
    component: PaymentSuccessComponent
  },
  {
    path: "**",
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
