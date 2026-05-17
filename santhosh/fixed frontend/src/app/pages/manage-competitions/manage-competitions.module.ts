import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ManageCompetitionsPageRoutingModule } from './manage-competitions-routing.module';

import { ManageCompetitionsPage } from './manage-competitions.page';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ManageCompetitionsPageRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ],
  declarations: [ManageCompetitionsPage]
})
export class ManageCompetitionsPageModule {}
