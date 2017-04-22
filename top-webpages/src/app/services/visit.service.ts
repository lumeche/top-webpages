import { Injectable } from '@angular/core';
import { Visit} from '../classes/visit';
import {VISITS} from '../classes/data-visits';
@Injectable()
export class VisitService {
  constructor() { }
  
  getVisits():Promise<Visit[]>{
      return Promise.resolve(VISITS);
  }
}
