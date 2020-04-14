package com.spangular.spangular.bikes.repositories;

import java.util.UUID;

import com.spangular.spangular.bikes.models.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IBikeRepository
 */
public interface IBikeRepository extends JpaRepository<Bike, UUID>{

    
}