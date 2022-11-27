import { TestBed } from '@angular/core/testing';

import { KomentarServiceService } from './komentar-service.service';

describe('KomentarServiceService', () => {
  let service: KomentarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KomentarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
