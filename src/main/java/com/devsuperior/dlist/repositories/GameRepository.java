package com.devsuperior.dlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dlist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
