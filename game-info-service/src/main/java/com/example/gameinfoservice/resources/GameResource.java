package com.example.gameinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gameinfoservice.models.Game;

@RestController
@RequestMapping("/games")
public class GameResource {
	
	@RequestMapping("/{gameId}")
	public Game getGameInfo(@PathVariable("gameId") String gameId) {
		return new Game(gameId, "Test Name");
		
	}

}
