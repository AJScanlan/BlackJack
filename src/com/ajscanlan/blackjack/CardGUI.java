package com.ajscanlan.blackjack;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class CardGUI {
	JFrame frame;
	JPanel dealerPanel, playerPanel, uiPanel, deckPanel;
	private JButton newGame;

	public CardGUI(){

		//Setup JFrame
		frame = new JFrame();
		frame.setResizable(true);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 775, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Setup JPanels
		dealerPanel = new JPanel();
		dealerPanel.setBounds(10, 11, 582, 245);
		frame.getContentPane().add(dealerPanel);

		playerPanel = new JPanel();
		playerPanel.setBackground(Color.DARK_GRAY);
		playerPanel.getPreferredSize();
		playerPanel.setBounds(10, 267, 582, 264);
		frame.getContentPane().add(playerPanel);
		playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		uiPanel = new JPanel();
		uiPanel.setBounds(602, 267, 157, 264);
		frame.getContentPane().add(uiPanel);

		deckPanel = new JPanel();
		deckPanel.setBounds(602, 11, 157, 245);
		frame.getContentPane().add(deckPanel);
		frame.setVisible(true);

		//Setup JButtons
		JButton btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameLogic.hit();
			}
		});
		uiPanel.add(btnHit);

		JButton btnStand = new JButton("Stand");
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLoop.stand = true;
			}
		});
		uiPanel.add(btnStand);

		JButton btnDoubleDown = new JButton("Double Down");
		uiPanel.add(btnDoubleDown);
		
		newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameLoop.newGame();
			}
		});
		uiPanel.add(newGame);

	}

	public void paintCard(Card card, Player player){
		if(player == GameLoop.player){
			playerPanel.add(card);
		} else {
			dealerPanel.add(card);
		}
//		playerPanel.repaint();
		frame.repaint();
//		card.setVisible(true);
//		card.setOpaque(true);
//		card.repaint();
	}

	public void removeCards(){
//		playerPanel.removeAll();
//		dealerPanel.removeAll();
//		playerPanel.repaint();
//		frame.repaint();
	}
	
	public void repaintAll(){
//		playerPanel.repaint();
//		frame.repaint();
//		GameLoop.drawCard(GameLoop.player);
//		GameLoop.drawCard(GameLoop.dealer);
//		frame.pack();
	}
}
