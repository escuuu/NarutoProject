import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VillasListadoComponent } from './villas-listado.component';

describe('VillasListadoComponent', () => {
  let component: VillasListadoComponent;
  let fixture: ComponentFixture<VillasListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VillasListadoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VillasListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
