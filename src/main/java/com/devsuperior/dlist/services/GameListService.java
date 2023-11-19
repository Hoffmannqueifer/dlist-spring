package com.devsuperior.dlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.entities.GameList;
import com.devsuperior.dlist.projections.GameMinProjection;
import com.devsuperior.dlist.repositories.GameListRepository;
import com.devsuperior.dlist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gamelistRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> listGames = gamelistRepository.findAll();
		List<GameListDTO> dto = listGames.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> listGames = gameRepository.searchByList(listId);
		GameMinProjection obj = listGames.remove(sourceIndex);
		listGames.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gamelistRepository.updateBelongingPosition(listId, listGames.get(i).getId(), i);
		}
	}

}
