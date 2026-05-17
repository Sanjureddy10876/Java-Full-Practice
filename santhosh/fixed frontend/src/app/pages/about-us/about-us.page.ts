import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.page.html',
  styleUrls: ['./about-us.page.scss'],
})
export class AboutUsPage implements OnInit {

  public currentId = '';

  constructor() { }

  ngOnInit() {
  }

  toggle(id : string){
    if(this.currentId == id){
      this.currentId = '';
      id = '';
    }
    return this.currentId = id;
  }

}
