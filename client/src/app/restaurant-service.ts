import { Restaurant, Comment } from './models'
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class RestaurantService {

	constructor(private http: HttpClient) { }
	// TODO Task 2 
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// public getCuisineList(???) {
	// 	// Implememntation in here

	// }

    getRestaurants(): Observable<Restaurant[]> {
        return this.http.get<any[]>(`/api/restaurants`)
    }

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getRestaurantsByCuisine(cuisine: string) {
		return this.http.get<Restaurant[]>(`api/${cuisine}/restaurants`)

	}
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// public getRestaurant(???): Promise<Restaurant> {
	// 	// Implememntation in here

	// }

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE
	// public postComment(comment: Comment): Promise<any> {
	// 	// Implememntation in here

	// }
}
