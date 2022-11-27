import { TestBed } from '@angular/core/testing';

import { TipObjektaService } from './tip-objekta.service';

describe('TipObjektaService', () => {
  let service: TipObjektaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipObjektaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
