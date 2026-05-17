import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { UploadEntryPage } from './upload-entry.page';

describe('UploadEntryPage', () => {
  let component: UploadEntryPage;
  let fixture: ComponentFixture<UploadEntryPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadEntryPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(UploadEntryPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
