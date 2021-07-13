package com.bandipo.blogapi.repositories;

import com.bandipo.blogapi.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Long> {

}
