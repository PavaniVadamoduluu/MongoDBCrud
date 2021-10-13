package com.SampleMongoDB.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.SampleMongoDB.model.Location;

@Repository
public interface LocationRepo extends MongoRepository<Location, String>{

	  @Query("{city : ?0}")      
	  // SQL Equivalent : SELECT * FROM LOCATION where city = Vizag
      List<Location> getCity(String city);

	  @Query("{state : ?0}") 
	  List<Location> getState(String state);

	  @Query("{country : ?0}")
	  List<Location> getCountry(String country);

	  @Query("{zipcode : ?0}")
	  List<Location> getZipcode(int zipcode);
}
