import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { LearnMusicPage } from './learn-music.page';

describe('LearnMusicPage', () => {
  let component: LearnMusicPage;
  let fixture: ComponentFixture<LearnMusicPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LearnMusicPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(LearnMusicPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
