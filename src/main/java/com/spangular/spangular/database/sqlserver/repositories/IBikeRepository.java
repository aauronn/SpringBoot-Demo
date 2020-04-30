package com.spangular.spangular.database.sqlserver.repositories;

import java.util.UUID;

import com.spangular.spangular.database.sqlserver.models.Bike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IBikeRepository
 */
@Repository
public interface IBikeRepository extends JpaRepository<Bike, UUID>{

    
}