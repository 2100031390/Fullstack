package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.entity.Pet;


@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	@Query("select count(P) from Pet P")
	public Long countParticipants();
	
	
	@Query("select P from Pet P where P.eid=:eid")
	public List<Pet> readAllbyEid(@Param("eid") Long eid);

}
