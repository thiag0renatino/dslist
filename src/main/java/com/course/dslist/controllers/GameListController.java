package com.course.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dslist.dto.GameListDTO;
import com.course.dslist.dto.GameMinDTO;
import com.course.dslist.dto.ReplacementDTO;
import com.course.dslist.services.GameListService;
import com.course.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService listService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = listService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body){
		listService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
	
}
