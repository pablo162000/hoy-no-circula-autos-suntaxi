import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoRegistradoDialog } from './resultado-registrado-dialog';

describe('ResultadoRegistradoDialog', () => {
  let component: ResultadoRegistradoDialog;
  let fixture: ComponentFixture<ResultadoRegistradoDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultadoRegistradoDialog]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadoRegistradoDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
