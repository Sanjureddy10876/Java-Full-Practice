import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LearnMusicPage } from './learn-music.page';

const routes: Routes = [
  {
    path: '',
    component: LearnMusicPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LearnMusicPageRoutingModule {}
