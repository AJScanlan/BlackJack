package com.ajscanlan.blackjack;

import java.util.Scanner;

public class GameLoop {

	static Player player;
	static Player dealer;

	Scanner scan = new Scanner(System.in);
	static boolean quit = false;
	static boolean win = true;;


	public static void main(String[] args) {
		GameLoop gameLoop = new GameLoop();
		while(!quit){
			gameLoop.loop();
			gameLoop.dealerLoop();	

			if(player.getPlayerHand().getValue() == dealer.getPlayerHand().getValue()){
				System.out.println("Push");
			} else{
				if(GameLogic.check(player, dealer)){
					System.out.println("You win");
				} else {
					System.out.println("You lose");
				}
			}
			gameLoop.askToQuit();
		}
	}

	private void askToQuit() {
		int choice;
		String tempString;
		System.out.println("Press 1 to play again, 2 to quit");
		tempString = scan.next();
		choice = Integer.parseInt(tempString);

		if(choice == 2){
			quit = true;
			scan.close();
		}

	}

	private void dealerLoop() {
		dealer = new Player();
		while(dealer.getPlayerHand().getValue() <= 17){
			dealer.getPlayerHand().addCard(GameLogic.deal());
		}

		System.out.println("Dealer value: " + dealer.getPlayerHand().getValue());

	}

	private void loop() {

		GameLogic.setupGame();

		player = new Player();

		int choice = 0;
		String temp;

		if(player.getPlayerHand().getValue() == 21){
			System.out.println("BLACKJACK");
			scan.close();
			return;
		}

		while(player.getPlayerHand().getValue() < 21){

			//System.out.println(player.getPlayerHand().toString());
			System.out.println(player.getPlayerHand().getValue());
			System.out.println("Press 1 to Hit or 2 to Stand");

			temp = scan.next();
			choice = Integer.parseInt(temp);

			if(choice == 1){
				player.getPlayerHand().addCard(GameLogic.deal());
			} else {
				break;
			}

		}

		System.out.println("Player value: " + player.getPlayerHand().getValue());

		//		if(player.getPlayerHand().getValue() > 21){
		//			win = false;
		//		}


		//scan.close();

	}

}

