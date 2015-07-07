package com.ajscanlan.blackjack;

import java.util.Scanner;

public class GameLoop {

	public static void main(String[] args) {
		GameLoop gameLoop = new GameLoop();
		gameLoop.loop();
	}

	private void loop() {
		
		GameLogic.setupGame();

		Player player = new Player();
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		String temp;

		while(GameLogic.check(player)){
			System.out.println(player.getPlayerHand().toString());
			System.out.println("Press 1 to Hit");
			temp = scan.next();
			choice = Integer.parseInt(temp);

			if(choice == 1){
				player.getPlayerHand().addCard(GameLogic.deal());
			}

		}

		scan.close();
	}
}

