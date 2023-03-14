import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanesListadoComponent } from './clanes-listado.component';

describe('ClanesListadoComponent', () => {
  let component: ClanesListadoComponent;
  let fixture: ComponentFixture<ClanesListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClanesListadoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClanesListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
