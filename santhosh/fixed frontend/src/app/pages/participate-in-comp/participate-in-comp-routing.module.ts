import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ParticipateInCompPage } from './participate-in-comp.page';

const routes: Routes = [
  {
    path: '',
    component: ParticipateInCompPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ParticipateInCompPageRoutingModule {}
