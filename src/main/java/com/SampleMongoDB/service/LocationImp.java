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
		Optional<Location> findById = locRepo.findById(id);
		if (findById.isPresent()) {
			Location location = findById.get();
			if (location.getAddress()!= null && !location.getAddress().isEmpty())
				location.setAddress(location.getAddress());
			if (location.getCity()!= null && !location.getCity().isEmpty())
				location.setCity(location.getCity());
			if (location.getState()!= null && !location.getState().isEmpty())
				location.setState(location.getState());
			if (location.getCountry()!= null && !location.getCountry().isEmpty())
				location.setCountry(location.getCountry());
			if (location.getZipcode()!= 0)
				location.setZipcode(location.getZipcode());
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
