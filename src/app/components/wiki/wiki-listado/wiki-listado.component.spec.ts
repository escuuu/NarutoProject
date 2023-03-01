import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WikiListadoComponent } from './wiki-listado.component';

describe('WikiListadoComponent', () => {
  let component: WikiListadoComponent;
  let fixture: ComponentFixture<WikiListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WikiListadoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WikiListadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
