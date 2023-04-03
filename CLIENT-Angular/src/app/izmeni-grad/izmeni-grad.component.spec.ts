import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmeniGradComponent } from './izmeni-grad.component';

describe('IzmeniGradComponent', () => {
  let component: IzmeniGradComponent;
  let fixture: ComponentFixture<IzmeniGradComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmeniGradComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IzmeniGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
