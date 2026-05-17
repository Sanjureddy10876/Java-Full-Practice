import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { UploadEntryPageRoutingModule } from './upload-entry-routing.module';

import { UploadEntryPage } from './upload-entry.page';
import { FileUploadModule } from 'ng2-file-upload';
import { SharedModule } from '../shared.module';
import { MaterialModule } from '../material.module';
import { DialogModule } from 'primeng/dialog';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    UploadEntryPageRoutingModule,
    SharedModule,
    MaterialModule,
    DialogModule
  ],
  declarations: [UploadEntryPage]
})
export class UploadEntryPageModule {}
