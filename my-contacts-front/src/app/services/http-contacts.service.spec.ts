import { TestBed } from '@angular/core/testing';

import { HttpContactsService } from './http-contacts.service';

describe('HttpContactsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpContactsService = TestBed.get(HttpContactsService);
    expect(service).toBeTruthy();
  });
});
