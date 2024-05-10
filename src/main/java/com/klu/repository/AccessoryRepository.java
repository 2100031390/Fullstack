package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.entity.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long>{

}
