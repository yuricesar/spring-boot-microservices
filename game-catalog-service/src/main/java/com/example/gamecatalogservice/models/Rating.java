package com.example.gamecatalogservice.models;

public class Rating {
	
	private String gameId;
	private int rating;
	
	public Rating() {
		
	}
	
	public Rating(String gameId, int rating) {
		this.gameId = gameId;
		this.rating = rating;
	}
	
	public String getGameId() {
		return gameId;
	}
	
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

}
