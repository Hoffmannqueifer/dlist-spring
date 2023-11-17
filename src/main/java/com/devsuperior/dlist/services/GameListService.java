package com.devsuperior.dlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.entities.GameList;
import com.devsuperior.dlist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gamelistRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> listGames = gamelistRepository.findAll();
		List<GameListDTO> dto = listGames.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}

}
