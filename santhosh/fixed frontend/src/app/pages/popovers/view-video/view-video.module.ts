import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ViewVideoPageRoutingModule } from './view-video-routing.module';
import { MaterialModule } from '../../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ViewVideoPageRoutingModule,
    MaterialModule
  ],
  declarations: []
})
export class ViewVideoPageModule {}
