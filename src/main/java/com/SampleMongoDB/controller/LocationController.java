package com.SampleMongoDB.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SampleMongoDB.Repository.LocationRepo;
import com.SampleMongoDB.model.Location;
import com.SampleMongoDB.service.LocationService;

@RestController
@RequestMapping("/api")
@Validated
public class LocationController {

	@Autowired
    LocationService locservice;
	
	@Autowired
	LocationRepo locRepo;
	
	//Get all Locations
	@GetMapping("/locations")
	public List<Location> getLocation() {
		return locservice.getLocation();
	}
	
	//Save Location
	@PostMapping("/locations/save")
	public ResponseEntity<Location> saveLocation(@Valid @RequestBody Location loc) {
		 locservice.saveLocation(loc);
		 return new ResponseEntity<Location>(loc, HttpStatus.OK);
	}
		
	//Update Location
	@PutMapping("/update/{id}")
	public Location UpdateLoc(@PathVariable("id") String id,@RequestBody Location loc){
		return locservice.update(loc,id);
	}
	
	//Delete Location
	@DeleteMapping("/deleteLoc/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		return locservice.deleteLoc(id);
	}
	
	//Get Location by id
	@GetMapping("/locations/{id}")
	public Optional<Location> getloc(@PathVariable String id) {
		return locservice.findById(id);
	}

	//Get Location by city
	@GetMapping("/citylocations/{city}")
	public List<Location> getlocByCity(@PathVariable String city) {
		return locRepo.getCity(city);
	}
	
	//Get Location by state
	@GetMapping("/statelocations/{state}")
	public List<Location> getlocByState(@PathVariable String state) {
		return locRepo.getState(state);
	}
		
	//Get Location by country
	@GetMapping("/countrylocations/{country}")
	public List<Location> getlocByCountry(@PathVariable String country) {
		return locRepo.getCountry(country);
	}
	
	//Get Location by Zipcode
	@GetMapping("/zipcodelocations/{zipcode}")
	public List<Location> getlocByZipcode(@PathVariable int zipcode) {
		return locRepo.getZipcode(zipcode);
	}
	
}