import { Component, OnInit } from '@angular/core';
import { TrainingModel } from 'src/app/models/TrainingModel';
import { TrainingContentModel } from 'src/app/models/TrainingContentModel';
import { NavController } from '@ionic/angular';
import { TrainingService } from 'src/app/services/training/training.service';
import { ActivatedRoute } from '@angular/router';
import { UtilService } from 'src/app/services/util/util.service';

@Component({
  selector: 'app-view-playlist',
  templateUrl: './view-playlist.page.html',
  styleUrls: ['./view-playlist.page.scss'],
})
export class ViewPlaylistPage implements OnInit {

  constructor(private nav : NavController, public ts : TrainingService, private ar: ActivatedRoute, public util: UtilService) { }

  public model : TrainingModel;

  public currentlyPlaying : TrainingContentModel;

  ngOnInit() {
    this.ar.params.subscribe(params => {
      this.model = this.ts.trainings.getValue().filter(t => t.trainingId == params['trainingId'])[0];
      console.log(this.model);
    });
  }

  playme(tc : TrainingContentModel){
    this.currentlyPlaying = tc;
  }
}