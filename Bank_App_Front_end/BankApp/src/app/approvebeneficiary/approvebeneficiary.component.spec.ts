import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovebeneficiaryComponent } from './approvebeneficiary.component';

describe('ApprovebeneficiaryComponent', () => {
  let component: ApprovebeneficiaryComponent;
  let fixture: ComponentFixture<ApprovebeneficiaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprovebeneficiaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApprovebeneficiaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
