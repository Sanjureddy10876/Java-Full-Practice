import { NgModule } from '@angular/core';
import { ErrorComponent } from '../components/error/error.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { OtpPageModule } from './popovers/otp/otp.module';
import { QuizComponent } from '../components/quiz/quiz.component';
import { FooterComponent } from '../components/footer/footer.component';
import { TemplateComponent } from '../components/template/template.component';
import { MsgComponent } from '../components/msg/msg.component';
import { LanguagePage } from './popovers/language/language.page';
import { TranslateModule } from '@ngx-translate/core';
import { MultiFileUploadComponent } from '../components/multi-file-upload/multi-file-upload.component';
import { FileUploadModule } from 'ng2-file-upload';
import { ViewVideoPage } from './popovers/view-video/view-video.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    OtpPageModule,
    TranslateModule,
    FileUploadModule
  ],
  declarations: [
    ErrorComponent, QuizComponent, FooterComponent, TemplateComponent, MsgComponent, LanguagePage, MultiFileUploadComponent, ViewVideoPage
  ],
  exports: [
    ErrorComponent, QuizComponent, FooterComponent, TemplateComponent, TranslateModule, MsgComponent, LanguagePage, MultiFileUploadComponent, ViewVideoPage
  ],
  entryComponents: [
    LanguagePage, ViewVideoPage
  ]
})

export class SharedModule { }