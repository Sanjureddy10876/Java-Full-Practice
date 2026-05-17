import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ViewPlaylistPage } from './view-playlist.page';

const routes: Routes = [
  {
    path: '',
    component: ViewPlaylistPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ViewPlaylistPageRoutingModule {}
