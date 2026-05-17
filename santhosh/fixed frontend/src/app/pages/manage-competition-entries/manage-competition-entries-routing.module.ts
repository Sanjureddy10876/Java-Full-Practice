import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ManageCompetitionEntriesPage } from './manage-competition-entries.page';

const routes: Routes = [
  {
    path: '',
    component: ManageCompetitionEntriesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ManageCompetitionEntriesPageRoutingModule {}
