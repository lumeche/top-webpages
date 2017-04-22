import { Component, OnInit,Input } from '@angular/core';
import {Visit} from '../../classes/visit';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.css']
})
export class VisitComponent implements OnInit {

  @Input()
  visit=Visit;
  constructor() { }

  ngOnInit() {
  }

}
