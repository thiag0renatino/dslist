package com.course.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
