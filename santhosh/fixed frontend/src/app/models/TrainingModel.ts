import { TrainingContentModel } from './TrainingContentModel';

export class TrainingModel {
    trainingId: string;

    trainingContents: TrainingContentModel[];

    category: string;

    trainingName: string;

    trainingDesc: string;

    isSubscriptionRequired: string;

    subscriptionAmount: string;

    trainingPhoto: string;

    isSubscribed : boolean;
}