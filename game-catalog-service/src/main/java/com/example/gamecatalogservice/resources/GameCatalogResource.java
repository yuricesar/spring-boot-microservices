package com.example.gamecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.gamecatalogservice.models.CatalogItem;
import com.example.gamecatalogservice.models.Game;
import com.example.gamecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class GameCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		List<Rating> ratings = Arrays.asList(
			new Rating("1234", 5),
			new Rating("5678", 4)
		);
		
		return ratings.stream().map(rating -> {
			Game game = restTemplate.getForObject("http://localhost:8082/games/" + rating.getGameId(), Game.class);
			return new CatalogItem(game.getName(), "Desc", rating.getRating());
		}).collect(Collectors.toList());

	}

}
