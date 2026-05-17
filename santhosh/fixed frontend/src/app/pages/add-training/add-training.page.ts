import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TrainingContentModel } from 'src/app/models/TrainingContentModel';
import { FileService } from 'src/app/services/file/file.service';
import { TrainingModel } from 'src/app/models/TrainingModel';
import { TrainingService } from 'src/app/services/training/training.service';
import { UtilService } from 'src/app/services/util/util.service';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-add-training',
  templateUrl: './add-training.page.html',
  styleUrls: ['./add-training.page.scss'],
})
export class AddTrainingPage implements OnInit {
  public courseForm: FormGroup;
  public courseContentForm: FormGroup;
  public showContentNotAddedError = false;
  public videos : TrainingContentModel[] = [];

  constructor(private fb: FormBuilder, private fileSrvc : FileService, private ts : TrainingService, 
              private util: UtilService, private nav : NavController) {

  }

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm() {
    this.courseForm = this.fb.group({
      'trainingId': ['', []],
      'category': ['', [Validators.required]], 
      'trainingName': ['', [Validators.required]],
      'trainingDesc': ['', [Validators.required]],
      'isSubscriptionRequired': ['', []],
      'subscriptionAmount': ['', [Validators.required]],
      'trainingPhoto': ['', [Validators.required]],
    });

    this.courseContentForm = this.fb.group({
      'trainingContentId': ['', []],
      'trainingContentName': ['', [Validators.required]],
      'trainingContentDesc': ['', [Validators.required]],
      'contentId': ['', [Validators.required]],
      'sortOrder': ['', [Validators.required]],
    });
  }

  addContent(){
    let content : TrainingContentModel = this.courseContentForm.value;
    this.videos.push(content);
    this.courseContentForm.reset();
    this.showContentNotAddedError = false;
  }

  delete(index : number){
    let content : TrainingContentModel = this.videos.splice(index, 1)[0];
    if(content.contentId && content.contentId != ''){
      this.fileSrvc
          .deleteFile(content.contentId)
          .subscribe(res => console.log('file deleted successfully', res));
    }
  }

  saveCourse(){
    let course : TrainingModel = this.courseForm.value;
    course.trainingContents = this.videos;
    this.util
        .showLoader()
        .then(() => {
          this.ts
              .saveTraining(course)
              .subscribe(
                res => {
                  this.util.hideLoader();
                  this.util.success('Course saved successfully.');
                  this.nav.navigateBack('/learn-music').then(() => this.ts.getAllTrainings().subscribe(res => {
                    this.ts.trainings.next(res);
                  }));
                },
                err => {
                  this.util.hideLoader();
                  this.util.errorHandler(err);
                })
        });
  }

  get trainingContentId() {
    return this.courseContentForm.get('trainingContentId')
  }

  get trainingContentName() {
    return this.courseContentForm.get('trainingContentName')
  }

  get trainingContentDesc() {
    return this.courseContentForm.get('trainingContentDesc')
  }

  get contentId() {
    return this.courseContentForm.get('contentId')
  }

  get sortOrder() {
    return this.courseContentForm.get('sortOrder')
  }

  get trainingId() {
    return this.courseForm.get('trainingId')
  }

  get category() {
    return this.courseForm.get('category')
  }

  get trainingName() {
    return this.courseForm.get('trainingName')
  }

  get trainingDesc() {
    return this.courseForm.get('trainingDesc')
  }

  get isSubscriptionRequired() {
    return this.courseForm.get('isSubscriptionRequired')
  }

  get subscriptionAmount() {
    return this.courseForm.get('subscriptionAmount')
  }

  get trainingPhoto() {
    return this.courseForm.get('trainingPhoto')
  }

}
