package com.ajscanlan.blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Card extends JPanel {

	private static final long serialVersionUID = 1L;

	//State =============================================================
	int value;
	String suit, rank;
	Image image = null;
	String imagePath;
	Dimension dimension = new Dimension(76, 110);
	//	private boolean flipped;

	//CONSTRUCTOR =======================================================
	public Card(int value, String suit, String rank) {
		super();
		this.setSize(dimension);
		//this.setOpaque(true);
		this.value = value;
		this.suit = suit;
		this.rank = rank;
	}

	//Overriding paint method - Credit to Artjom Porss - https://github.com/ArtjomsPorss
	public void paintComponent(Graphics g){
		//	if(!flipped){
		//InputStream input = Card.class.getClassLoader().getResourceAsStream(imagePath);
		//super.paint(g);
		try {
			image = ImageIO.read(getClass().getResource(imagePath));
			image = image.getScaledInstance((int) dimension.getWidth(), (int) dimension.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, null);
		//g.drawRect(0, 0, 79, 122);
		//		}else{
		//			g.setColor(Color.GRAY);
		//			g.fillRect(0, 0, 80, 123);
		//			g.setColor(Color.BLACK);
		//			g.drawRect(0, 0, 79, 122);
		//		}

	}

	public void loadImage(){
		imagePath = "/cards/";

		//add suit to image filename path
		switch(this.getSuit()){
		case "Spades" : imagePath += "S/"; break;
		case "Clubs" : imagePath += "C/"; break;
		case "Hearts" : imagePath += "H/"; break;
		case "Diamonds" : imagePath += "D/"; break;
		}

		switch(this.getRank()){
		case "Ace" : imagePath += "A"; break;
		case "Jack" : imagePath += "J"; break;
		case "King" : imagePath += "K"; break;
		case "Queen" : imagePath += "Q"; break;

		default: imagePath += this.getRank(); break;
		}

		imagePath += ".png";

	}

	//Getters and Setters ===============================================
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

	//Overriding toString() method  =====================================
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

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 150);
	}



}
