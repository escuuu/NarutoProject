import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VillasVerMasComponent } from './villas-ver-mas.component';

describe('VillasVerMasComponent', () => {
  let component: VillasVerMasComponent;
  let fixture: ComponentFixture<VillasVerMasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VillasVerMasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VillasVerMasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
