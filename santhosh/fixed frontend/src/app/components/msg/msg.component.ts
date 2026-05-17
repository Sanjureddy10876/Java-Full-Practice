import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-msg',
  templateUrl: './msg.component.html',
  styleUrls: ['./msg.component.scss'],
})
export class MsgComponent implements OnInit {

  @Input('key') key: string;

  @Input('value') value: string;

  constructor() { }

  ngOnInit() {}

}
