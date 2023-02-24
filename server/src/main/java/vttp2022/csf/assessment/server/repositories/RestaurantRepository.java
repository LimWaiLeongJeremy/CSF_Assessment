package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	@Autowired
	private MongoTemplate template;

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// db.restaurants.find({});
	public List<Restaurant> getCuisines(int limit, int offset) {
		Query query = (new Query()).limit(limit).skip(offset);
        return template.find(query, Document.class, "restaurants")
            .stream()
            .map(v -> { return Restaurant.create(v); })
            .toList();
		
	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// db.restaurants.find({ "cuisine" :  "{cuisine}" });  
	public List<Restaurant> getRestaurantsByCuisine(String cuisine) {

		Criteria criteria = Criteria.where("cuisine").is(cuisine);
        Query query = Query.query(criteria);
        return template.find(query, Document.class, "restaurants")
            .stream()
            .map(v -> { return Restaurant.create(v); })
            .toList();
    }

	

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method

	//  db.restaurants.find({ "name" :  "{name}" });  
	public Optional<Restaurant> getRestaurant(String name) {
		Criteria criteria = Criteria.where("name").is(name);
        Query query = Query.query(criteria);
		List<Document> doc = template.find(query, Document.class, "restaurants");
		Restaurant res = new Restaurant();
		res.create(doc.get(0));
        return Optional.of(res);
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}
	
	// You may add other methods to this class

}
