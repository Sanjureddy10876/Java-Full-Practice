import { Component, OnInit } from '@angular/core';
import { CompetitionService } from '../../services/competition/competition.service';
import { WinnerModel } from '../../models/WinnerModel';
import { UtilService } from '../../services/util/util.service';
import { MasterDataService } from '../../services/master/master-data.service';
import { SubmittedEntriesModel } from '../../models/SubmittedEntriesModel';
import { ViewVideoPage } from '../popovers/view-video/view-video.page';
import { PopoverController } from '@ionic/angular';

@Component({
  selector: 'app-winners',
  templateUrl: './winners.page.html',
  styleUrls: ['./winners.page.scss'],
})
export class WinnersPage implements OnInit {

  winners : WinnerModel[] = [];
  showProgress = false;
  showError = false;
  display = false;
  videoToPlay = null;
  constructor(public cs : CompetitionService, public util: UtilService, public mst: MasterDataService, public popup: PopoverController) { 

  }

  ngOnInit() {
    this.showProgress = true;
    this.cs.getAllCompetitionWinners()
        .subscribe(
          res => {
            this.showError = true;
            this.winners = res;
            this.showProgress = false;
          },
          err => {
            this.showError = true;
            this.showProgress = false;
          }
        );
  }

  getPositionDescription(entry : SubmittedEntriesModel){
    if(entry.winnerDesc == '1'){
      return 'First Position';
    }else if(entry.winnerDesc == '2'){
      return 'Second Position';
    }else if(entry.winnerDesc == '3'){
      return 'Third Position';
    }else{
      return entry.winnerDesc;
    }
  }

  viewVideo(event, id) {
    this.videoToPlay = id;
    this.display = true;
  }

}
