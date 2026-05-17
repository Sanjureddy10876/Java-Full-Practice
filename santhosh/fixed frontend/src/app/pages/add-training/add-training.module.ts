import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AddTrainingPageRoutingModule } from './add-training-routing.module';

import { AddTrainingPage } from './add-training.page';
import { MaterialModule } from '../material.module';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AddTrainingPageRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    SharedModule
  ],
  declarations: [AddTrainingPage]
})
export class AddTrainingPageModule {}
