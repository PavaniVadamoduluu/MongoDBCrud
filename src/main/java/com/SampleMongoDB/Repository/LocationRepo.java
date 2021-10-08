package com.SampleMongoDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SampleMongoDB.model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer>{

}
