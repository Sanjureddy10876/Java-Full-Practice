import { Injectable } from '@angular/core';
import { UtilService } from '../util/util.service';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FileService {
  options = {};
  constructor(public util : UtilService) { 
    let headers = new HttpHeaders({
      'Content-Type': undefined
    });
    this.options = { headers: headers };
  }

  uploadFile(formData : FormData){
    return this.util.postFormData('file', formData);
  }

  deleteFile(fileId : string){
    return this.util.delete('file/' + fileId);
  }

  getFile(fileId : string){
    return this.util.get('file/' + fileId);
  }
}
