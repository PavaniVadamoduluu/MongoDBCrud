package com.SampleMongoDB.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.SampleMongoDB.model.Location;

@Service
public interface LocationService {

	List<Location> getLocation();

	Location saveLocation(Location loc);

	Optional<Location> updateLoc(int id);

	Optional<Location> deleteLoc(int id);

}
