import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanesComponent } from './clanes.component';

describe('ClanesComponent', () => {
  let component: ClanesComponent;
  let fixture: ComponentFixture<ClanesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClanesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClanesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
