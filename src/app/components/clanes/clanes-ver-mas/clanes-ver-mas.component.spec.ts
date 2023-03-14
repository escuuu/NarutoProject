import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanesVerMasComponent } from './clanes-ver-mas.component';

describe('ClanesVerMasComponent', () => {
  let component: ClanesVerMasComponent;
  let fixture: ComponentFixture<ClanesVerMasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClanesVerMasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClanesVerMasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
