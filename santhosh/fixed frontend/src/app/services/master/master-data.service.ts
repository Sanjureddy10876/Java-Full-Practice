import { Injectable } from '@angular/core';
import { UtilService } from '../util/util.service';
import { MstStateModel } from 'src/app/models/MstStateModel';
import { BehaviorSubject } from 'rxjs';
import { CompCategoryModel } from 'src/app/models/CompCategoryModel';

@Injectable({
  providedIn: 'root'
})
export class MasterDataService {

  private state : BehaviorSubject<MstStateModel[]>  = new BehaviorSubject<MstStateModel[]>([]);
  private category : BehaviorSubject<CompCategoryModel[]>  = new BehaviorSubject<CompCategoryModel[]>([]);
  
  getCategory(){
    if(this.category.getValue().length < 1){
      this.reloadMasterData();
    }

    return this.category;
  }

  getState(){
    if(this.state.getValue().length < 1){
      this.reloadMasterData();
    }
    return this.state;
  }

  constructor(private util : UtilService) { 
    this.initializeMasterData();
  }

  loadMasterCategories() {
    return this.util
                .get<CompCategoryModel[]>('master/categories')
                .subscribe(
                  res => this.getCategory().next(res)
                );
  }

  loadMasterStates() {
    return this.util
                .get<MstStateModel[]>('master/state')
                .subscribe(
                  res => this.getState().next(res)
                );
  }

  initializeMasterData(){
    this.loadMasterStates();
    this.loadMasterCategories();
  }

  reloadMasterData(){
    this.initializeMasterData();
  }

  getStateDescByKey(key: string){
    if(key == null){
      return '';
    }
    let state = this.getState()
                  .getValue()
                  .filter(d => d.key + '' == key + '')[0];
    return state.desc;
  }

  getCategoryDescByKey(key: string){
    if(key == null){
      return '';
    }
    let category = this.getCategory()
                      .getValue()
                      .filter(d => d.key + '' == key + '')[0];
    return category.desc;
  }
}
