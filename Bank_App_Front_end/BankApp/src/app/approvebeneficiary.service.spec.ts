import { TestBed } from '@angular/core/testing';

import { ApprovebeneficiaryService } from './approvebeneficiary.service';

describe('ApprovebeneficiaryService', () => {
  let service: ApprovebeneficiaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApprovebeneficiaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
