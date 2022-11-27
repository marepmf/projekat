import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjekatComponent } from './objekat.component';

describe('ObjekatComponent', () => {
  let component: ObjekatComponent;
  let fixture: ComponentFixture<ObjekatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjekatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ObjekatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
