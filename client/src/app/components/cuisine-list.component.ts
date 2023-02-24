import { Component,OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit{

  cuisines :any[] = [];
  constructor(private svc: RestaurantService) { }

  ngOnInit(): void {
    console.log('Getting cuisines!');
    this.svc.getRestaurants()
                      .subscribe(data => {
                          this.cuisines = data;
                          console.log(data)
                          
  })
  
  }
}
