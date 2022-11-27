import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajDrzavuComponent } from './dodaj-drzavu.component';

describe('DodajDrzavuComponent', () => {
  let component: DodajDrzavuComponent;
  let fixture: ComponentFixture<DodajDrzavuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajDrzavuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DodajDrzavuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
