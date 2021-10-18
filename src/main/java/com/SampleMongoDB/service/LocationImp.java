package com.SampleMongoDB.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.SampleMongoDB.Repository.LocationRepo;
import com.SampleMongoDB.model.Location;

@Service
public class LocationImp implements LocationService{

	@Autowired
	private LocationRepo locRepo;

	//Get all locations
	@Override
	@Transactional
	public List<Location> getLocation() {
		return locRepo.findAll();
	}

	//Save Location
	@Override
	@Transactional
	public Location saveLocation(Location loc) {
		return locRepo.save(loc);
	}

	//Update Location
	@Override
	@Transactional
	public Location update(Location loc, String id) {
		Optional<Location> location = locRepo.findById(id);
		if (location.isPresent()) {
			if (location.get().getAddress()!= null && !location.get().getAddress().isEmpty())
				location.get().setAddress(location.get().getAddress());
			if (location.get().getCity()!= null && !location.get().getCity().isEmpty())
				location.get().setCity(location.get().getCity());
			if (location.get().getState()!= null && !location.get().getState().isEmpty())
				location.get().setState(location.get().getState());
			if (location.get().getCountry()!= null && !location.get().getCountry().isEmpty())
				location.get().setCountry(location.get().getCountry());
			if (location.get().getZipcode()!= 0)
				location.get().setZipcode(location.get().getZipcode());
			return locRepo.save(loc);
	   }
		else {
			return null;
		}
	}

	//Delete Location
	@Override
	@Transactional
	public String deleteLoc(String id) {
		Optional<Location> LocId = locRepo.findById(id);
		if (LocId.isPresent()) {
			locRepo.deleteById(id);
			return "Location Deleted Successfully";
		}
			return "Location not found";
	}
	
	//Get Location by id
	@Override
	@Transactional
	public Optional<Location> findById(String id) {
		Optional<Location> LocId = locRepo.findById(id);
		if (LocId.isPresent()) {
		 locRepo.findById(id);
		 return LocId;
		}
		return null;
		}
	}
