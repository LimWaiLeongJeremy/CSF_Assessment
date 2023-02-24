import { Component,OnInit } from '@angular/core';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit{

  restaurants: Restaurant[] = []
  constructor(private svc: RestaurantService) { }

  ngOnInit(): void {
      this.getRestaurants()
  }

  getRestaurants() {
    console.log('Getting restaurants!');
    this.svc.getRestaurants()
                      .subscribe(data => {
                          this.restaurants = data;
                          console.log(data)
  
    })
  }


}
