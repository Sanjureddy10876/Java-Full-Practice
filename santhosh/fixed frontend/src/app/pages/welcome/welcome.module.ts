import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { WelcomePageRoutingModule } from './welcome-routing.module';

import { WelcomePage } from './welcome.page';
import { FileUploadModule } from 'ng2-file-upload';
import { MultiFileUploadComponent } from 'src/app/components/multi-file-upload/multi-file-upload.component';
import { SharedModule } from '../shared.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    WelcomePageRoutingModule,
    SharedModule
  ],
  declarations: [WelcomePage]
})
export class WelcomePageModule {}
