import { Component, OnInit } from '@angular/core';
import { Visit } from '../../classes/visit';
import { VisitService } from '../../services/visit.service';

@Component({
  selector: 'app-visit-list',
  templateUrl: './visit-list.component.html',
  styleUrls: ['./visit-list.component.css'],
  providers:[VisitService]
})
export class VisitListComponent implements OnInit {
  visits: Visit[];
  
  constructor(private visitService: VisitService) { }

  ngOnInit() {
    this.visitService.getVisits().then(visits=>this.visits=visits);
  }

}
