package com.ajscanlan.blackjack;

public class Player {
	Hand playerHand = new Hand();
	
	public Player(){
		playerHand.addCard(GameLogic.deal());
		playerHand.addCard(GameLogic.deal());
	}


	
	public Hand getPlayerHand() {
		return playerHand;
	}

}
