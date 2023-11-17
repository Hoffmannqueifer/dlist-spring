package com.devsuperior.dlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dlist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
