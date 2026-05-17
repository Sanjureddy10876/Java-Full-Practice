import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { CheckTutorial } from './guards/check-tutorial.guard';
import { AuthGuard } from './guards/auth-guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'welcome',
    loadChildren: () => import('./pages/welcome/welcome.module').then( m => m.WelcomePageModule),
    // canActivate: [AuthGuard]
  },
  {
    path: 'otp',
    loadChildren: () => import('./pages/popovers/otp/otp.module').then( m => m.OtpPageModule)
  },
  {
    path: 'profile',
    loadChildren: () => import('./pages/profile/profile.module').then( m => m.ProfilePageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'user-details',
    loadChildren: () => import('./pages/user-details/user-details.module').then( m => m.UserDetailsPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'upload-entry/:compId',
    loadChildren: () => import('./pages/upload-entry/upload-entry.module').then( m => m.UploadEntryPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'manage-competitions',
    loadChildren: () => import('./pages/manage-competitions/manage-competitions.module').then( m => m.ManageCompetitionsPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'manage-competition-entries/:compId',
    loadChildren: () => import('./pages/manage-competition-entries/manage-competition-entries.module').then( m => m.ManageCompetitionEntriesPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'tutorial',
    loadChildren: () => import('./pages/tutorial/tutorial.module').then(m => m.TutorialModule),
    canLoad: [CheckTutorial]
  },
  {
    path: 'faq',
    loadChildren: () => import('./pages/faq/faq.module').then( m => m.FaqPageModule)
  },
  {
    path: 'about-us',
    loadChildren: () => import('./pages/about-us/about-us.module').then( m => m.AboutUsPageModule)
  },
  {
    path: 'vision',
    loadChildren: () => import('./pages/vision/vision.module').then( m => m.VisionPageModule)
  },
  {
    path: 'language',
    loadChildren: () => import('./pages/popovers/language/language.module').then( m => m.LanguagePageModule)
  },
  {
    path: 'contact-us',
    loadChildren: () => import('./pages/contact-us/contact-us.module').then( m => m.ContactUsPageModule)
  },
  {
    path: 'view-video',
    loadChildren: () => import('./pages/popovers/view-video/view-video.module').then( m => m.ViewVideoPageModule)
  },
  {
    path: 'winners',
    loadChildren: () => import('./pages/winners/winners.module').then( m => m.WinnersPageModule)
  },
  {
    path: 'participate-in-comp',
    loadChildren: () => import('./pages/participate-in-comp/participate-in-comp.module').then( m => m.ParticipateInCompPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'learn-music',
    loadChildren: () => import('./pages/learn-music/learn-music.module').then( m => m.LearnMusicPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'view-playlist/:trainingId',
    loadChildren: () => import('./pages/view-playlist/view-playlist.module').then( m => m.ViewPlaylistPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'add-training/:trainingId',
    loadChildren: () => import('./pages/add-training/add-training.module').then( m => m.AddTrainingPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'landing',
    loadChildren: () => import('./pages/landing/landing.module').then( m => m.LandingPageModule)
  }
  ,
  {
    path: 'landing/:link',
    loadChildren: () => import('./pages/landing/landing.module').then( m => m.LandingPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
