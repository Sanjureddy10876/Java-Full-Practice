import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ContestModel } from 'src/app/models/ContestModel';
import { UtilService } from '../util/util.service';
import { EnrollmentsModels } from 'src/app/models/EnrollmentsModels';
import { SearchModel } from 'src/app/models/SearchModel';
import { SubmittedEntriesModel } from 'src/app/models/SubmittedEntriesModel';
import { WinnerModel } from 'src/app/models/WinnerModel';

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {

  constructor(private util : UtilService) { }

  getActiveCompetitions() : Observable<ContestModel[]>{
    return this.util.get<ContestModel[]>('competitions/active');
  }

  search(searchModel : SearchModel) : Observable<ContestModel[]>{
    return this.util.post<ContestModel[]>('competitions/search', searchModel);
  }

  enrollInComp(compId){
    return this.util.post(`competitions/enrollment/${compId}`, null);
  }

  getAllEnrolments(): Observable<EnrollmentsModels[]>{
    return this.util.get<EnrollmentsModels[]>('competitions/enrollment');
  }

  getCompetitionDetails(compId) : Observable<ContestModel>{
    return this.util.get<ContestModel>(`competitions/${compId}`);
  }

  attachFileToEnrolledCompetition(submittedEntryId : string, fileId : string){
    return this.util.post(`competitions/enrollment/${submittedEntryId}/${fileId}`, null);
  }

  subscribeToCompetition(compId : string, payId : string){
    return this.util.post(`competitions/subscribe/${compId}/${payId}`, null);
  }

  saveOrUpdateComp(comp : ContestModel){
    return this.util.post(`competitions`, comp);
  }

  getAllSubmittedEntries(compId) :Observable<[]>{
    return this.util.get(`competitions/enrollment/${compId}`);
  }

  getShortlistedEntries(compId) :Observable<[]>{
    return this.util.get(`competitions/shortlisted/${compId}`);
  }

  markShortlisted(submittedEntryId) :Observable<[]>{
    return this.util.post(`competitions/shortlist/${submittedEntryId}`, null);
  }

  markWinners(winnerList : SubmittedEntriesModel[]) :Observable<[]>{
    return this.util.post(`competitions/winner`, winnerList);
  }

  getCompetitionWinners(compId) : Observable<WinnerModel[]>{
    return this.util.get<WinnerModel[]>(`competitions/winners/${compId}`);
  }

  getAllCompetitionWinners() : Observable<WinnerModel[]>{
    return this.util.get<WinnerModel[]>(`competitions/allwinners`);
  }

  createSubscriptionOrder(comp : ContestModel) : Observable<string>{
    return this.util.post<string>(`competitions/subscribe/${comp.competitionId}`, null);
  }

  processPayment(orderId, payment_id) : Observable<string>{
    return this.util.post<string>(`competitions/subscribe/${orderId}/${payment_id}/null/null`, null);
  }

  processPaymentError(orderId, errorCode, errorDesc) : Observable<string>{
    return this.util.post<string>(`competitions/subscribe/${orderId}/null/${errorCode}/${errorDesc}`, null);
  }
}
