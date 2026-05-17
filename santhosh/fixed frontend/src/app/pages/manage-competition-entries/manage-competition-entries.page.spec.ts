import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ManageCompetitionEntriesPage } from './manage-competition-entries.page';

describe('ManageCompetitionEntriesPage', () => {
  let component: ManageCompetitionEntriesPage;
  let fixture: ComponentFixture<ManageCompetitionEntriesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageCompetitionEntriesPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ManageCompetitionEntriesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
