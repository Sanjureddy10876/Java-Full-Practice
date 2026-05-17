import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { WinnersPageRoutingModule } from './winners-routing.module';

import { WinnersPage } from './winners.page';
import { SharedModule } from '../shared.module';
import {DialogModule} from 'primeng/dialog';
import { MaterialModule } from '../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    WinnersPageRoutingModule,
    SharedModule,
    DialogModule,
    MaterialModule
  ],
  declarations: [WinnersPage]
})
export class WinnersPageModule {}
