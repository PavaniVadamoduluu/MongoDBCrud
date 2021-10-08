package com.SampleMongoDB.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SampleMongoDB.model.Location;
import com.SampleMongoDB.service.LocationService;

@RestController
@RequestMapping("/api")
public class LocationController {

	public LocationService locservice;
	
	@Autowired
	@Qualifier("locservice")
	public void setLocationService(LocationService locservice){
	    this.locservice=locservice;
	}
	
	@GetMapping("/locations")
	public List<Location> getLocation() {
		return locservice.getLocation();
	}
	
	@PostMapping("/locations/save")
	public Location saveLocation(@RequestBody Location loc) {
		return locservice.saveLocation(loc);
	}
	
	@PutMapping(value= "/updatelocation/{id}")
	public Location updateLoc(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Location details by id is invoked.");
		Optional<Location> loc =  locservice.updateLoc(id);
		if(!loc.isPresent())
			throw new Exception("Could not find Location with id- " + id);
		return loc.get();
	}
	
	@DeleteMapping("/deleteLoc/{id}")
	public String deleteLoc(@PathVariable("id") int id) throws Exception {
			Optional<Location> loc =  locservice.deleteLoc(id);
			if(!loc.isPresent())
				throw new Exception("Could not find Location with id- " + id);
		 return "deleted location succesfully.";
	}
	
}