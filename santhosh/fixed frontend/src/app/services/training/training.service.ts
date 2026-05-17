import { Injectable } from '@angular/core';
import { UtilService } from '../util/util.service';
import { BehaviorSubject, Observable } from 'rxjs';
import { TrainingModel } from 'src/app/models/TrainingModel';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  public trainings : BehaviorSubject<TrainingModel[]> = new BehaviorSubject<TrainingModel[]>([]);

  constructor(public util : UtilService) { 

  }

  getAllTrainings(){
    return this.util.get<TrainingModel[]>('trainings');
  }

  saveTraining(training : TrainingModel){
    return this.util.post('training', training);
  }

  createSubscriptionOrder(training : TrainingModel) : Observable<string>{
    return this.util.post<string>(`trainings/subscribe/${training.trainingId}`, null);
  }

  processPayment(orderId, payment_id) : Observable<string>{
    return this.util.post<string>(`trainings/subscribe/${orderId}/${payment_id}/null/null`, null);
  }

  processPaymentError(orderId, errorCode, errorDesc) : Observable<string>{
    return this.util.post<string>(`trainings/subscribe/${orderId}/null/${errorCode}/${errorDesc}`, null);
  }
}
