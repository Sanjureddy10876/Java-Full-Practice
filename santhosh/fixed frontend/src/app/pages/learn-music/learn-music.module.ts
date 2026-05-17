import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LearnMusicPageRoutingModule } from './learn-music-routing.module';

import { LearnMusicPage } from './learn-music.page';
import { SharedModule } from '../shared.module';
import { MaterialModule } from '../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LearnMusicPageRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    MaterialModule
  ],
  declarations: [LearnMusicPage]
})
export class LearnMusicPageModule {}
