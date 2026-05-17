import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UploadEntryPage } from './upload-entry.page';

const routes: Routes = [
  {
    path: '',
    component: UploadEntryPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UploadEntryPageRoutingModule {}
