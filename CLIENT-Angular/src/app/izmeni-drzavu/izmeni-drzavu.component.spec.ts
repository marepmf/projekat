import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmeniDrzavuComponent } from './izmeni-drzavu.component';

describe('IzmeniDrzavuComponent', () => {
  let component: IzmeniDrzavuComponent;
  let fixture: ComponentFixture<IzmeniDrzavuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmeniDrzavuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IzmeniDrzavuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
