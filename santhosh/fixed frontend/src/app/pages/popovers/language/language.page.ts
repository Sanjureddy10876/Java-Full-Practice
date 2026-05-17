import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { PopoverController } from '@ionic/angular';

@Component({
  selector: 'app-language',
  templateUrl: './language.page.html',
  styleUrls: ['./language.page.scss'],
})
export class LanguagePage implements OnInit {

  public language = '';
  public currentLanguage;

  constructor(public translateService : TranslateService, public popup: PopoverController) { }

  ngOnInit() {
    this.currentLanguage = localStorage.getItem('language');
  }

  changeLanguage(lang) {
    console.log('lang', lang);
    this.translateService.use(lang);
    localStorage.setItem('language', lang);
  }

  close(){
    this.popup.dismiss(null);
  }

}
