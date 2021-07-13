package com.bandipo.blogapi.services.serviceImplementation;

import com.bandipo.blogapi.exceptions.ResourceNotFoundException;
import com.bandipo.blogapi.model.Location;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.repositories.LocationRepository;
import com.bandipo.blogapi.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {


    private final LocationRepository locationRepository;

    public List<Location> getALLLocation() {
        return (List<Location>) locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id) {


        return locationRepository.findById(id);
    }

    @Override
    public List<User> getUsersByLocationId(Long id){
        Optional<Location> locationById = locationRepository.findById(id);
        return locationById.map(Location::getUsers).orElse(null);

    }

    @Override

    public void addLocation(Location location){
        locationRepository.save(location);
    }


    @Override
    public void updateLocation(Location location){

            locationRepository.save(location);



    }

    @Override
    public void deleteLocation(long id) {
        locationRepository.deleteById(id);
    }
}
