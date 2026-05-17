import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ManageCompetitionsPage } from './manage-competitions.page';

describe('ManageCompetitionsPage', () => {
  let component: ManageCompetitionsPage;
  let fixture: ComponentFixture<ManageCompetitionsPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageCompetitionsPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ManageCompetitionsPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
