package com.ajscanlan.blackjack;

import java.util.Scanner;

public class GameLoop {

	public static Player player;// = new Player();
	public static Player dealer;// = new Player();

	Scanner scan = new Scanner(System.in);
	static boolean running = true;
	static boolean win = true;
	static boolean stand;
	public int choice = 0;
	static GameLoop gameLoop = new GameLoop();

	static CardGUI gui;
	
//	public Thread thread = new Thread(this, "Display");


	public static void main(String[] args) {
		gui = new CardGUI();
		//while(!quit){
//		gameLoop.thread.start();
		GameLoop.newGame();
		//}


	}

	public static void newGame() {

		gui.removeCards();
		stand = false;
		GameLogic.setupGame();
		player = new Player();
		dealer = new Player();
		gameLoop.loop();
		gameLoop.dealerLoop();	
		
		if(GameLogic.check(player, dealer)){
			System.out.println("You win");
		} else {
			System.out.println("You lose");
		}
	}


	private void dealerLoop() {
		
		while(dealer.getPlayerHand().getValue() <= 17){
			dealer.getPlayerHand().addCard(GameLogic.deal());
			GameLoop.drawCard(dealer);
		}

		System.out.println("Dealer value: " + dealer.getPlayerHand().getValue());

	}

	private void loop() {

		GameLogic.setupGame();

		GameLoop.drawCard(dealer);

		if(player.getPlayerHand().getValue() == 21){
			System.out.println("BLACKJACK");
			return;
		}

		while(player.getPlayerHand().getValue() < 21 ^ stand){
			GameLoop.drawCard(player);
		}
		
		GameLoop.drawCard(player);

	}

	public static void drawCard(Player player){
		for(int i = 0; i < player.getPlayerHand().getSize(); ++i){
			player.getPlayerHand().getCard(i).loadImage();
			gui.paintCard(player.getPlayerHand().getCard(i), player);
			player.getPlayerHand().getCard(i).repaint();
		}
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(running){
//		//	gui.repaintAll();
//			System.out.println("Hello");
//		}
//	}
//	
//	public synchronized void start(){
//	//	System.out.println("hello");
//		running = true;
//		//thread = new Thread(this, "Display");
//		thread.start();
//	}
//	
//	public synchronized void stop(){
//		running = false;
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

