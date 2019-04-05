import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbarcomponentComponent } from './searchbarcomponent.component';

describe('SearchbarcomponentComponent', () => {
  let component: SearchbarcomponentComponent;
  let fixture: ComponentFixture<SearchbarcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchbarcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchbarcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
