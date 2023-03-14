import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanesIntroComponent } from './clanes-intro.component';

describe('ClanesIntroComponent', () => {
  let component: ClanesIntroComponent;
  let fixture: ComponentFixture<ClanesIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClanesIntroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClanesIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
