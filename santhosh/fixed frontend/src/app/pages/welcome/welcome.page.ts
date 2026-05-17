import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { UtilService } from 'src/app/services/util/util.service';
import { Router } from '@angular/router';
import { SocialSharing } from '@ionic-native/social-sharing/ngx';
import { CompetitionService } from 'src/app/services/competition/competition.service';
import { MasterDataService } from 'src/app/services/master/master-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.page.html',
  styleUrls: ['./welcome.page.scss'],
})
export class WelcomePage implements OnInit {
  
  constructor(public ls : LoginService, public util : UtilService, public r : Router, private compSrvc : CompetitionService, 
              public router : Router, private sharing : SocialSharing, private mst : MasterDataService) { 
              }
  
  ngOnInit() {
    
  }

  comingSoon(){
    this.util.presentToast('World of Music Coming Soon...');
  }

  share() {
    this.sharing
        .share("Hi, I am sharing the Surshree App with you. The app enables you to participate in various competition organized by Surshree. Download link is: <Link Will Be Updated Later>", "Download Surshree App", null, null)
        .catch(() => {
          this.util.presentToast('Sharing not supported. Please use Surshree app to Reffer it to your friends.');
        });
  }
}
