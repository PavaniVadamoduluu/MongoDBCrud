package com.SampleMongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SampleMongoDB.Repository.LocationRepo;
import com.SampleMongoDB.model.Location;

@Component
@Service("LocationService")
public class LocationImp implements LocationService{

	public LocationRepo locRepo;
	
	@Autowired
	@Qualifier("locRepo")
	public void setLocationRepo(LocationRepo locRepo){
	    this.locRepo=locRepo;
	}
	
	@Override
	@Transactional
	public List<Location> getLocation() {
		return locRepo.findAll();
	}

	@Override
	@Transactional
	public Location saveLocation(Location loc) {
		return locRepo.save(loc);
	}

	@Override
	@Transactional
	public Optional<Location> updateLoc(int id) {
		return locRepo.findById(id);
	}

	@Override
	@Transactional
	public Optional<Location> deleteLoc(int id) {
		return deleteLoc(id);
	}

}
