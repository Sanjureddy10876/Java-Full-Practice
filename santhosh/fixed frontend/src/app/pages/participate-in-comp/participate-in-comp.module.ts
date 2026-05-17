import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ParticipateInCompPageRoutingModule } from './participate-in-comp-routing.module';

import { ParticipateInCompPage } from './participate-in-comp.page';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ParticipateInCompPageRoutingModule,
    SharedModule
  ],
  declarations: [ParticipateInCompPage]
})
export class ParticipateInCompPageModule {}
