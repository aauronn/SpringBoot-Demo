package com.spangular.spangular.controllers;

import java.util.List;
import java.util.UUID;

import com.spangular.spangular.models.Bike;
import com.spangular.spangular.repositories.IBikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * BikesController
 */
@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private IBikeRepository _bikeRepository;

    /**
     * Get a list of bikes
     * @return
     */
    @GetMapping
    public List<Bike> GetBikes(){

        // Get all bikes from repository
        List<Bike> bikes = _bikeRepository.findAll();

        return bikes;
    }

    /**
     * Get a bike by Id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Bike GetBikeById(@PathVariable("id") UUID id){
        
        // Get a bike from repository
        Bike FoundBike = _bikeRepository.getOne(id);

        return FoundBike;
    }

    /**
     * Add a new bike
     * @param biketoAdd
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bike AddBike(@RequestBody Bike biketoAdd){

        Bike BikeToAdd = biketoAdd;
        BikeToAdd.setId(UUID.randomUUID());

        return _bikeRepository.save(BikeToAdd);
    }

    
}