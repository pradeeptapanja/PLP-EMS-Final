import { TestBed } from '@angular/core/testing';

import { FinanceuserService } from './financeuser.service';

describe('FinanceuserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FinanceuserService = TestBed.get(FinanceuserService);
    expect(service).toBeTruthy();
  });
});
