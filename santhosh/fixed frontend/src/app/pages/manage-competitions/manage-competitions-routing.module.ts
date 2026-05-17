import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ManageCompetitionsPage } from './manage-competitions.page';

const routes: Routes = [
  {
    path: '',
    component: ManageCompetitionsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ManageCompetitionsPageRoutingModule {}
