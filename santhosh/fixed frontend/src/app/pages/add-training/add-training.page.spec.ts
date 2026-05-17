import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { AddTrainingPage } from './add-training.page';

describe('AddTrainingPage', () => {
  let component: AddTrainingPage;
  let fixture: ComponentFixture<AddTrainingPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTrainingPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(AddTrainingPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
