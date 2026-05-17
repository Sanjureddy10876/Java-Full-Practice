import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.scss'],
})
export class ErrorComponent implements OnInit {

  @Input('condition') condition: boolean = false;

  @Input('msg') msg: string;


  constructor() { }

  ngOnInit() {}

}
