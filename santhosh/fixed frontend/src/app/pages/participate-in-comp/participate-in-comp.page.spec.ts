import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ParticipateInCompPage } from './participate-in-comp.page';

describe('ParticipateInCompPage', () => {
  let component: ParticipateInCompPage;
  let fixture: ComponentFixture<ParticipateInCompPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParticipateInCompPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ParticipateInCompPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
