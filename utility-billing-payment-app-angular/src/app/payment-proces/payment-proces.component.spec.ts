import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentProcesComponent } from './payment-proces.component';

describe('PaymentProcesComponent', () => {
  let component: PaymentProcesComponent;
  let fixture: ComponentFixture<PaymentProcesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentProcesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentProcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
