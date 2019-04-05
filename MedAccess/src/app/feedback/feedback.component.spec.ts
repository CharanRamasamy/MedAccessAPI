import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FeedbackComponent } from './feedback.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatButtonModule } from '@angular/material';
import { BarRatingModule } from "ngx-bar-rating";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('FeedbackComponent', () => {
  let component: FeedbackComponent;
  let fixture: ComponentFixture<FeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ MatFormFieldModule, MatInputModule, MatButtonModule, BrowserAnimationsModule ],
      declarations: [ FeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
