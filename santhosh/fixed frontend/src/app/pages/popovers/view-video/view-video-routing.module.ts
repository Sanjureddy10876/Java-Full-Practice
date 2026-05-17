import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ViewVideoPage } from './view-video.page';

const routes: Routes = [
  {
    path: '',
    component: ViewVideoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ViewVideoPageRoutingModule {}
