package com.mywebapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mywebapp.model.Alien;



public interface AlienRepo extends JpaRepository<Alien, Integer>{

	List<Alien> findByTechnology(String technology);

	List<Alien> findByAlienIdGreaterThan(int i);
	
	@Query("FROM alien WHERE technology=?1 order by alienName")
	List<Alien> findByTechSorted(String technology);
	
	
}
