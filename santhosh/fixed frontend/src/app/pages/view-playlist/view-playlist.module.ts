import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule, AngularDelegate } from '@ionic/angular';

import { ViewPlaylistPageRoutingModule } from './view-playlist-routing.module';

import { ViewPlaylistPage } from './view-playlist.page';
import { SharedModule } from '../shared.module';
import { MaterialModule } from '../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ViewPlaylistPageRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    MaterialModule
  ],
  declarations: [ViewPlaylistPage]
})
export class ViewPlaylistPageModule {}
