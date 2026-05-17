import { Component, OnInit, HostListener, ElementRef, Input, HostBinding } from '@angular/core';
import { FileUploader, FileLikeObject, FileItem } from 'ng2-file-upload';
import { UtilService } from 'src/app/services/util/util.service';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { FileService } from 'src/app/services/file/file.service';

@Component({
  selector: 'app-multi-file-upload',
  templateUrl: './multi-file-upload.component.html',
  styleUrls: ['./multi-file-upload.component.scss'],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: MultiFileUploadComponent,
    multi: true
  }]
})
export class MultiFileUploadComponent implements OnInit, ControlValueAccessor {
  @Input('format') format : string;
  @Input('msg') msg: string;
  @Input('icon') icon: boolean = false;
  @Input('required') required: boolean = false;
  @Input('class') class: string = null;;
  private previousId : string;
  private file: File | null = null;
  public uploader: FileUploader = new FileUploader({});
  public hasBaseDropZoneOver: boolean = false;
  public showProgress : boolean = false;

  private onChange: Function = (file : File) => {
  };
  private onTouch: Function = () => {};
  private disabled: boolean = false;

  private _ID = '';

  constructor(private util : UtilService, private host: ElementRef<HTMLInputElement>, private fileSrvc: FileService) { 
  }

  dropped(event){
  }

  @HostListener('change', ['$event.target.files']) emitFiles( event: FileList ) {
    this.deleteFile(this.previousId);
    const file = event && event.item(0);
    this.file = file;
    this.uploadFile();
  }

  @HostBinding('attr.id')
  externalId = '';

  @Input()
  set id(value: string) {
    this._ID = value;
    this.externalId = null;
  }

  get id() {
    return this._ID;
  }


  writeValue(obj: any): void {
    //console.log('writeValue');
    this.host.nativeElement.value = '';
    this.previousId = null;
    this.file = null;
    this.onTouch();
    this.uploader.clearQueue();
  }
  registerOnChange(fn: any): void {
    this.onChange = fn;
    //console.log('writeValue');
  }
  registerOnTouched(fn: any): void {
    this.onTouch = fn;  
    //console.log('writeValue');
  }
  setDisabledState?(isDisabled: boolean): void {
  }

  ngOnInit() {}

  clear(){
    this.uploader.clearQueue();
    this.deleteFile(this.previousId);
  }

  getFiles(): FileLikeObject[] {
    return this.uploader.queue.map((fileItem) => {
      return fileItem.file;
    });
  }

  fileOverBase(ev): void {
    this.hasBaseDropZoneOver = ev;
  }

  reorderFiles(reorderEvent: CustomEvent): void {
    let element = this.uploader.queue.splice(reorderEvent.detail.from, 1)[0];
    this.uploader.queue.splice(reorderEvent.detail.to, 0, element);
  }

  uploadFile(){
    if(this.file){
      this.showProgress = true;
      if(this.format){
        let extns : string[] = this.file.name.split(".");
        let fileEntn = extns[extns.length - 1];
        if(!this.format.includes(fileEntn)){
          this.clear();
          this.util.errorMsg('You can only upload files with following formats : ' + this.format);
          this.showProgress = false;
          return;
        }
      }
      const formData: FormData = new FormData();
      formData.append("file", this.file, this.file.name);
      this.fileSrvc
          .uploadFile(formData)
          .subscribe(
            res => {
              console.log('File upload res -->', res);
              this.previousId = res['uuid'];
              this.onChange(this.previousId);
              console.log('new id', this.previousId);
              this.util.presentToast('File uploaded successfully!');
              this.showProgress = false;
            },
            err => {
              this.showProgress = false;
              this.util.presentToast("File upload failed. Please contact system administrator.");
              this.clear();
          });
    }
  }

  deleteFile(fileId){
    if(fileId){
      this.fileSrvc
        .deleteFile(fileId)
        .subscribe(
          res => {
            console.log('File delete res -->', res);
            this.onChange(null);
          },
          err => this.util.errorHandler(err)
        )
    }
  }

  openFileDialog(id){
    document.getElementById(id).click()
  }
}
