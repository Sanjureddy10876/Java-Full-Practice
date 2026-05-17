import { Component, OnInit } from '@angular/core';
import { UtilService } from 'src/app/services/util/util.service';
import { CompetitionService } from 'src/app/services/competition/competition.service';
import { ContestModel } from 'src/app/models/ContestModel';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SearchModel } from 'src/app/models/SearchModel';
import { MasterDataService } from 'src/app/services/master/master-data.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-manage-competitions',
  templateUrl: './manage-competitions.page.html',
  styleUrls: ['./manage-competitions.page.scss'],
})
export class ManageCompetitionsPage implements OnInit {

  showError = false;
  competitions : ContestModel[] = [];
  showProgressBar = false;
  public searchForm : FormGroup;

  constructor(public util: UtilService, private compSrvc : CompetitionService, public fb : FormBuilder, private mst: MasterDataService, public ls: LoginService) { 
    this.initializeSearchForm();
  }

  initializeSearchForm(){
    this.searchForm = this.fb.group({
      'compId' : [''],
      'startDate' : [''],
      'endDate' : [''],
      'isActive' : [''],
      'isWinnerAnnounced' : ['']
    });
  }

  get compId(){
    return this.searchForm.get('compId');
  }

  get startDate(){
    return this.searchForm.get('startDate');
  }

  get endDate(){
    return this.searchForm.get('endDate');
  }

  get isActive(){
    return this.searchForm.get('isActive');
  }

  get isWinnerAnnounced(){
    return this.searchForm.get('isWinnerAnnounced');
  }

  ngOnInit() {
  }

  search(){
    this.showProgressBar = true;
    this.showError = false;
    let searchCriteria = new SearchModel();
    searchCriteria.compId = this.compId.value;
    searchCriteria.startDate = this.startDate.value;
    searchCriteria.endDate = this.endDate.value;
    searchCriteria.isActive = this.isActive.value;
    searchCriteria.isWinnerAnnounced = this.isWinnerAnnounced.value;

    this.compSrvc
        .search(searchCriteria)
        .subscribe(
          res => {
            this.competitions = res;
            this.showProgressBar = false;
            this.showError = true;
          },
          err => {
            this.competitions = [];
            this.showProgressBar = false;
            this.showError = true;
          }
        );
  }

}
