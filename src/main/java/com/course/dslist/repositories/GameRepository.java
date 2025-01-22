package com.course.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
