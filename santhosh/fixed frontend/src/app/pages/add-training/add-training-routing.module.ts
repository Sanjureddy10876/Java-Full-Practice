import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddTrainingPage } from './add-training.page';

const routes: Routes = [
  {
    path: '',
    component: AddTrainingPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddTrainingPageRoutingModule {}
