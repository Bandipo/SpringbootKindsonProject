package com.bandipo.blogapi.services;

import com.bandipo.blogapi.model.Location;
import com.bandipo.blogapi.model.User;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<User> getUsersByLocationId(Long id);
     List<Location> getALLLocation();
     Optional<Location> getLocationById(Long id);
     void addLocation(Location location);
     void updateLocation(Location location);

    void deleteLocation(long id);
}
