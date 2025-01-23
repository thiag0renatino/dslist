package com.course.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.dslist.dto.GameListDTO;
import com.course.dslist.entities.GameList;
import com.course.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository listRepository;
	
	@Transactional(readOnly =  true)
	public List<GameListDTO> findAll(){
		List<GameList> result = listRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
