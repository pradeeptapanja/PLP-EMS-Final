import { TestBed } from '@angular/core/testing';

import { EmsService } from './ems.service';

describe('EmsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmsService = TestBed.get(EmsService);
    expect(service).toBeTruthy();
  });
});
