package com.example.gamecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class GameCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		return Collections.singletonList(
				new CatalogItem("Super Mario Bros", "Test", 5)
		);
		
	}

}
