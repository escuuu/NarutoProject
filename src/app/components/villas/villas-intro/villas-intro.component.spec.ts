import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VillasIntroComponent } from './villas-intro.component';

describe('VillasIntroComponent', () => {
  let component: VillasIntroComponent;
  let fixture: ComponentFixture<VillasIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VillasIntroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VillasIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
