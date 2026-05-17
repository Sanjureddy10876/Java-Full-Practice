import { Component, OnInit } from '@angular/core';
import { UtilService } from 'src/app/services/util/util.service';
import { CompetitionService } from 'src/app/services/competition/competition.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ContestModel } from 'src/app/models/ContestModel';
import { ActivatedRoute } from '@angular/router';
import { IonVirtualScroll } from '@ionic/angular';

@Component({
  selector: 'app-manage-competition-entries',
  templateUrl: './manage-competition-entries.page.html',
  styleUrls: ['./manage-competition-entries.page.scss'],
})
export class ManageCompetitionEntriesPage implements OnInit {
  public compId;
  public compForm : FormGroup;
  constructor(private util: UtilService, private compSrvc : CompetitionService, public fb : FormBuilder, private ar: ActivatedRoute) { }

  ngOnInit() {
    this.initializeCompForm();
    
    this.ar.params.subscribe(params => {
      console.log('params -->',params);
      this.compId = params['compId'];
      if(this.compId && !isNaN(this.compId)){
        this.compSrvc
            .getCompetitionDetails(this.compId)
            .subscribe(
              res => this.compForm.patchValue(res)
            )
      }
    });
  }

  initializeCompForm(){
    this.compForm = this.fb.group({
      'competitionId' : [''],
      'competitionCategory' : ['', Validators.required],
      'title' : ['', Validators.required],
      'description' : ['', Validators.required],
      'startTime' : ['', Validators.required],
      'endTime' : ['', Validators.required],
      'minAge' : ['', Validators.required],
      'maxAge' : ['', Validators.required],
      'isActive' : ['', Validators.required],
      'isSubscriptionRequired' : ['', Validators.required],
      'subscriptionPrice' : [''],
      'isWinnerAnnounced' : ['', Validators.required],
      'compPhoto' : ['' , Validators.required]
    });

    
    this.isSubscriptionRequired
        .valueChanges
        .subscribe(value => {
          if(value == '1'){
            this.subscriptionPrice.setValidators(Validators.required);
          }else{
            this.subscriptionPrice.clearValidators();
          }
          this.subscriptionPrice.updateValueAndValidity();
        });
  }

  get compPhoto(){
    return this.compForm.get('compPhoto');
  }

  get competitionId(){
    return this.compForm.get('competitionId');
  }

  get competitionCategory(){
    return this.compForm.get('competitionCategory');
  }

  get title(){
    return this.compForm.get('title');
  }

  get description(){
    return this.compForm.get('description');
  }

  get startTime(){
    return this.compForm.get('startTime');
  }

  get endTime(){
    return this.compForm.get('endTime');
  }

  get minAge(){
    return this.compForm.get('minAge');
  }

  get maxAge(){
    return this.compForm.get('maxAge');
  }

  get isSubscriptionRequired(){
    return this.compForm.get('isSubscriptionRequired');
  }

  get subscriptionPrice(){
    return this.compForm.get('subscriptionPrice');
  }

  get isActive(){
    return this.compForm.get('isActive');
  }

  get isWinnerAnnounced(){
    return this.compForm.get('isWinnerAnnounced');
  }

  saveComp(){
    console.log('form', this.compForm);
    if(this.compForm.valid){
      let comp = new ContestModel();
      comp.competitionId = this.competitionId.value;
      comp.competitionCategory = this.competitionCategory.value;
      comp.title = this.title.value;
      comp.description = this.description.value;
      comp.startTime = this.startTime.value;
      comp.endTime = this.endTime.value;
      comp.minAge = this.minAge.value;
      comp.maxAge = this.maxAge.value;
      comp.isActive = this.isActive.value;
      comp.isSubscriptionRequired = this.isSubscriptionRequired.value;
      comp.compPhoto = this.compPhoto.value;
      comp.isWinnerAnnounced = this.isWinnerAnnounced.value;
      
      if(this.isSubscriptionRequired.value == '1'){
        comp.subscriptionPrice = this.subscriptionPrice.value;
      }

      this.compSrvc
          .saveOrUpdateComp(comp)
          .subscribe(
            res => this.util.success('Competition details have been saved successfully.'),
            err => this.util.errorHandler(err) 
          );
    }
  }
}
