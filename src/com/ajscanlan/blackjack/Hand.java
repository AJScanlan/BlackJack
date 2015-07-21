package com.ajscanlan.blackjack;

import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> hand = new ArrayList<>();
	
	public Hand(Card card1, Card card2){
		this.hand.add(card1);
		this.hand.add(card2);
	}
	
	public Hand() {
		
	}

	public int getValue(){
		int value = 0;
		
		for(int i = 0; i < hand.size(); ++i){
			value += hand.get(i).getValue();
		}
		
		return value;
	}
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public String toString(){
		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i < hand.size(); ++i){
			temp.append("Card " + (i + 1) + ": " + hand.get(i).toString() + " ");
		}
		
		return temp.toString();
	}

	public Card getCard(int i){
		return hand.get(i);
	}
	
	public int getSize(){
		return hand.size();
	}
}
