import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ViewVideoPage } from './view-video.page';

describe('ViewVideoPage', () => {
  let component: ViewVideoPage;
  let fixture: ComponentFixture<ViewVideoPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewVideoPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ViewVideoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
