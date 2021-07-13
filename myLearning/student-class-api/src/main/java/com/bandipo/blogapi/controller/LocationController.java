package com.bandipo.blogapi.controller;

import com.bandipo.blogapi.model.Location;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.services.LocationService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@AllArgsConstructor
@RequestMapping("/locations")
public class LocationController {


    LocationService locationService;

    @GetMapping()
    public List<Location> getAllLocation(){
        return locationService.getALLLocation();
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable Long id){
        return locationService.getLocationById(id);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<User>> getUsersByLocationId(@PathVariable Long id){

        return new ResponseEntity<>(locationService.getUsersByLocationId(id), HttpStatus.OK);
    }

    @PostMapping("/add-new-location")

    public ResponseEntity<?> addNewLocation(@RequestBody Location location){
                   locationService.addLocation(location);
        return new ResponseEntity<>("New Location Added",HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateNewLocation(@RequestBody Location location){
        locationService.updateLocation(location);
        return new ResponseEntity<>("Location updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteLocation(@PathVariable long id){
        locationService.deleteLocation(id);
        return new ResponseEntity<>("Location deleted", HttpStatus.OK);
    }
}
