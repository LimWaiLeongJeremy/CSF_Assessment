import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent {
	
	// TODO Task 3
	// For View 2


  param$!: Subscription
  restaurants: Restaurant[] = []
  
  constructor(private activateRoute: ActivatedRoute, private title: Title, private svc: RestaurantService) { }

  ngOnInit(): void {
    console.log("restaurant cuisine commponent")
      const cuisine = this.activateRoute.snapshot.params['cuisine']
      this.title.setTitle(`Customer ${cuisine}`)
      // this.param$ = this.activateRoute.params.subscribe(
        // (params) => {
        //   console.info('>>> v = ', params)
        //   this.restaurants = params['cuisine']
        //   this.title.setTitle(`${this.cuisine}`)
        // })

        this.param$ = this.activateRoute.params.subscribe(
        (params) => {
          console.info('>>> v = ', params)
          // this.restaurants = params['cuisine']
          // this.title.setTitle(`${this.cuisine}`)
        })
        

        this.svc.getRestaurantsByCuisine(cuisine)
                        .subscribe(data => {
                            this.restaurants = data;
                            console.log(data)
                        
    })
      }




  ngOnDestroy(): void {
      console.info('+++ Restaurant cuisine component destroyed')
      this.param$.unsubscribe()
  }

}
