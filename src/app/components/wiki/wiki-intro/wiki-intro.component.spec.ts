import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WikiIntroComponent } from './wiki-intro.component';

describe('WikiIntroComponent', () => {
  let component: WikiIntroComponent;
  let fixture: ComponentFixture<WikiIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WikiIntroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WikiIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
