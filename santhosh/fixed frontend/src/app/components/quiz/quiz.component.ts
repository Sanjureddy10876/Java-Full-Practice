import { Component, OnInit, Input } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor } from '@angular/forms';
import { UtilService } from 'src/app/services/util/util.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: QuizComponent,
    multi: true
  }]
})
export class QuizComponent implements OnInit, ControlValueAccessor {

  @Input('disabled') disabled: boolean;

  @Input('question') question: string;

  @Input('options') options : string[];

  @Input('answer') answer : string;

  @Input('showStatus') showStatus : boolean;

  @Input('src') src : string;

  private onTouch: Function = () => {};
  private onChange: Function = (value : string) => {};
  public qResponse : string;
  public color = 'primary';
  public msg = '';

  constructor(public util : UtilService) { }
  
  writeValue(value: any): void {
    this.onChange(value);
  }
  registerOnChange(fn: any): void {
    this.onChange = fn;
  }
  registerOnTouched(fn: any): void {
    this.onTouch = fn; 
  }
  setDisabledState?(isDisabled: boolean): void {
    this.disabled = isDisabled;
  }

  emitValue(){
    this.writeValue(this.qResponse);
    this.displayAnswer();
  }

  displayAnswer(){
    this.showStatus = true;
    this.disabled = true;
    if(this.answer == this.qResponse){
      this.color = 'success';
      this.msg = 'Your answer is correct.';
    }else{
      this.color = 'danger';
      this.msg = `You answer is incorrect. Correct answer is ${this.answer}`;
    }
  }

  ngOnInit() {}

}
