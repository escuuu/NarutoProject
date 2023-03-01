import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WikiVerMasComponent } from './wiki-ver-mas.component';

describe('WikiVerMasComponent', () => {
  let component: WikiVerMasComponent;
  let fixture: ComponentFixture<WikiVerMasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WikiVerMasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WikiVerMasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
