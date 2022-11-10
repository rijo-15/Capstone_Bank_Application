import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveaccountComponent } from './approveaccount.component';

describe('ApproveaccountComponent', () => {
  let component: ApproveaccountComponent;
  let fixture: ComponentFixture<ApproveaccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveaccountComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApproveaccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
