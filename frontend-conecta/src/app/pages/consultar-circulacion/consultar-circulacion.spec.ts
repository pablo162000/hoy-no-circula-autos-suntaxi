import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarCirculacion } from './consultar-circulacion';

describe('ConsultarCirculacion', () => {
  let component: ConsultarCirculacion;
  let fixture: ComponentFixture<ConsultarCirculacion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarCirculacion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarCirculacion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
