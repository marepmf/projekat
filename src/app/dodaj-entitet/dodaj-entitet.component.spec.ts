import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajEntitetComponent } from './dodaj-entitet.component';

describe('DodajEntitetComponent', () => {
  let component: DodajEntitetComponent;
  let fixture: ComponentFixture<DodajEntitetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajEntitetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DodajEntitetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
