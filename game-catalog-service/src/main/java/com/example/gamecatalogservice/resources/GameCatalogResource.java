package com.example.gamecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.gamecatalogservice.models.CatalogItem;
import com.example.gamecatalogservice.models.Game;
import com.example.gamecatalogservice.models.Rating;
import com.example.gamecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class GameCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" +  userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Game game = restTemplate.getForObject("http://game-info-service/games/" + rating.getGameId(), Game.class);
			
			/*
			 * Game game = webClientBuilder.build()
			 * .get()
			 * .uri("http://localhost:8082/games/" + rating.getGameId())
			 * .retrieve()
			 * .bodyToMono(Game.class)
			 * .block();
			 */
			
			return new CatalogItem(game.getName(), "Desc", rating.getRating());
		}).collect(Collectors.toList());

	}

}
