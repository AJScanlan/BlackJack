package com.ajscanlan.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
	
	public static ArrayList<Card> deck = new ArrayList<>();
	
	public static void setupGame(){
		populateDeck();
		shuffle();
	} 
	
	public static void populateDeck(){
		populateDeck("Hearts");
		populateDeck("Diamonds");
		populateDeck("Clubs");
		populateDeck("Spades");
	}
	
	public static void populateDeck(String suit){
		int suitLimit = (52 / 4);
		String tempRank = "";
		
		for(int i = 2, j = 0; i < (suitLimit + 2); ++i){
			
			j = i;
			
			if(i <= 10){
				tempRank = Integer.toString(i);
			} else {
				switch(i){
				case 11: tempRank = "Jack";
				break;
				
				case 12: tempRank = "Queen";
				break;
				
				case 13: tempRank = "King";
				break;
				
				case 14: tempRank = "Ace";
				break;
				
				default: System.out.println("Something went wrong");
				}
				
				j = 10;
				
			}
			
			Card tempCard = new Card(j, suit,  tempRank);
			
			deck.add(tempCard);
		}
	}
	
	public static void shuffle(){
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}

	public static Card deal(){
		Card tempCard;
		tempCard = deck.get(0);
		deck.remove(0);
		return tempCard;
	}

	public static boolean check(Player player){
		int playerValue;
		
		playerValue = player.getPlayerHand().getValue();
		
		if(playerValue > 21){
			System.out.println("Loser");
			return false;
		} else {
			return true;
		}
		
	}
}
