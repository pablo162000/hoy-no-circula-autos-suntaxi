import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoConfirmacionDialog } from './resultado-confirmacion-dialog';

describe('ResultadoConfirmacionDialog', () => {
  let component: ResultadoConfirmacionDialog;
  let fixture: ComponentFixture<ResultadoConfirmacionDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultadoConfirmacionDialog]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadoConfirmacionDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
