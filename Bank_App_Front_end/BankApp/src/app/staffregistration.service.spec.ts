import { TestBed } from '@angular/core/testing';

import { StaffregistrationService } from './staffregistration.service';

describe('StaffregistrationService', () => {
  let service: StaffregistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StaffregistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
