import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterAuto } from './register-auto';

describe('RegisterAuto', () => {
  let component: RegisterAuto;
  let fixture: ComponentFixture<RegisterAuto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterAuto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterAuto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
