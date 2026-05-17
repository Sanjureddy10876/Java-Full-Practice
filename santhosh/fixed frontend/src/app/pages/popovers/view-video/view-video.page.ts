import { Component, OnInit } from '@angular/core';
import { PopoverController, NavParams } from '@ionic/angular';
import { UtilService } from 'src/app/services/util/util.service';

@Component({
  selector: 'app-view-video',
  templateUrl: './view-video.page.html',
  styleUrls: ['./view-video.page.scss'],
})
export class ViewVideoPage implements OnInit {
  id;
  constructor(public popup: PopoverController, public util: UtilService, public navParams:NavParams) { }

  ngOnInit() {
    this.id = this.navParams.get("id");
    console.log("id", this.id);
  }

  close(){
    this.popup.dismiss(null);
  }

}
