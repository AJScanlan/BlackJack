package com.ajscanlan.blackjack;

public class Card {

	//State
	int value;
	String suit, rank;


	public Card(int value, String suit, String rank) {
		super();
		this.value = value;
		this.suit = suit;
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("[rank=");
		builder.append(rank);
		builder.append(", suit=");
		builder.append(suit);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
