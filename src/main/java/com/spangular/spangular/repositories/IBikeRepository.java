package com.spangular.spangular.repositories;

import java.util.UUID;

import com.spangular.spangular.models.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IBikeRepository
 */
public interface IBikeRepository extends JpaRepository<Bike, UUID>{

    
}