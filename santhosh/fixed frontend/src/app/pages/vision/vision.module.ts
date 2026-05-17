import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VisionPageRoutingModule } from './vision-routing.module';

import { VisionPage } from './vision.page';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VisionPageRoutingModule,
    SharedModule
  ],
  declarations: [VisionPage]
})
export class VisionPageModule {}
