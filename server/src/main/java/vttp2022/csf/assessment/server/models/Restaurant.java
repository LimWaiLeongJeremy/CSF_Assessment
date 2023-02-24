package vttp2022.csf.assessment.server.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

// Do not modify this class
public class Restaurant {
	
	private String restaurantId;
	private String name;
	private String cuisine;
	private String address;
	private LatLng coordinates;
	private String mapUrl;

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return this.cuisine;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setCoordinates(LatLng coordinates) {
		this.coordinates = coordinates;
	}
	public LatLng getCoordinates() {
		return this.coordinates;
	}

	public void setMapURL(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getMapURL() {
		return this.mapUrl;
	}

	public static Restaurant create(Document doc) {
        Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(doc.getString("restaurant_id"));
		restaurant.setName(doc.getString("name"));
		restaurant.setCuisine(doc.getString("cuisine"));
		String address = doc.getString("address.building") 
						+ ","
						+ doc.getString("address.street")
						+ ","
						+ doc.getString("address.zipcode")
						+ ","
						+ doc.getString("address.borough");
		restaurant.setAddress(address);
		String coord
		// restaurant.setCoordinates(LatLng.create(doc));
		// restaurant.sefkinglagtMapURL(doc.getString(restaurant));
		
        return restaurant;
    }
	public JsonObject toJson() {
        return Json.createObjectBuilder()
			.add("restaurant_id", restaurantId)
			.add("name", name)
			.add("cuisine", cuisine)
			// .add("address", address)
			// .add("lat", coordinates.getLatitude())
			// .add("lng", coordinates.getLongitude())
            .build();
    }

	
}
