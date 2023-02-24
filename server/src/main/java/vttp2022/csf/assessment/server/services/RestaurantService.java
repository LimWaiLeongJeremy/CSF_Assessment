package vttp2022.csf.assessment.server.services;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.MapCache;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private MapCache mapCache;
	String old = "";
	String replaced = "";
	// TODO Task 2 
	// Use the following method to get a list of cuisines 
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public LinkedHashSet<String> getCuisines(int limit, int offset) {
		LinkedHashSet<Restaurant> resArrFilter = new LinkedHashSet<>();
		List<Restaurant> resArrNoFilter = restaurantRepo.getCuisines(limit, offset);
		LinkedHashSet<String> listOfCuisines = new LinkedHashSet<String>();

		resArrNoFilter.forEach((Restaurant rNoFilter) -> {
			listOfCuisines.add(rNoFilter.getCuisine());
		});
		listOfCuisines.forEach(c -> {
			if (c.contains("/")) {
				old = c;
				String cNew = c.replace("/", "_");
				replaced = cNew;
			}
		});
		listOfCuisines.remove(old);
		listOfCuisines.add(replaced);

		return listOfCuisines;
	}  

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public LinkedHashSet<Restaurant> getRestaurantsByCuisine(String cuisine) {
		if(cuisine.contains("_")){
			cuisine = cuisine.replace("_", "/");
		}
		LinkedHashSet<Restaurant> listOfCuisines = new LinkedHashSet<Restaurant>();		
		List<Restaurant> resArr = restaurantRepo.getRestaurantsByCuisine(cuisine);
		
		resArr.forEach((Restaurant rNoFilter) -> {
			listOfCuisines.add(rNoFilter);
		});
		
		return listOfCuisines;
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// public Optional<Restaurant> getRestaurant(???) {
	// 	// Implmementation in here
		
	// }

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}
	//
	// You may add other methods to this class
}
