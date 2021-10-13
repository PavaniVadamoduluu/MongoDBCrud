package com.SampleMongoDB.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.SampleMongoDB.model.Location;

@Component
public interface LocationService {

	List<Location> getLocation();

	Location saveLocation(Location loc);

	public String deleteLoc(String id);

	public Location update(Location loc, String id);

	Optional<Location> findById(String id);

}
