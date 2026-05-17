import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ManageCompetitionEntriesPageRoutingModule } from './manage-competition-entries-routing.module';

import { ManageCompetitionEntriesPage } from './manage-competition-entries.page';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ManageCompetitionEntriesPageRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ],
  declarations: [ManageCompetitionEntriesPage]
})
export class ManageCompetitionEntriesPageModule {}
