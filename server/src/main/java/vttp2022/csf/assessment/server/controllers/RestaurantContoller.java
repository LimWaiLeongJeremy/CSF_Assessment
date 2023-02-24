package vttp2022.csf.assessment.server.controllers;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;
import vttp2022.csf.assessment.server.services.RestaurantService;

@Controller
@RequestMapping(path = "/api")
public class RestaurantContoller {

    @Autowired
    private RestaurantService restaurantSvc;
    
    @GetMapping(path = "/restaurants")
    @ResponseBody
    public ResponseEntity<String> getCuisines()  {
        System.out.println("getCuisine");
        LinkedHashSet<String> resArr = restaurantSvc.getCuisines(20, 0);
        List<String> test =resArr.stream().toList();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        test.stream()
            .forEach(v -> {
                arrBuilder.add(v);
            });

        return ResponseEntity.ok(arrBuilder.build().toString());
    }
// 3772

    @GetMapping(path = "/{cuisine}/restaurants")
    @ResponseBody
    public ResponseEntity<String> getRestaurants(@PathVariable String cuisine)  {
        System.out.println("GetRestaurant");
        LinkedHashSet<Restaurant> resArr = restaurantSvc.getRestaurantsByCuisine(cuisine);
        List<Restaurant> resList = resArr.stream().toList();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        resList.stream()
            .forEach(v -> {
                arrBuilder.add(v.toJson());
            });

        return ResponseEntity.ok(arrBuilder.build().toString());

    }

}
