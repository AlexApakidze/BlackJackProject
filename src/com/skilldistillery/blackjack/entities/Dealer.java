package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {

	private Deck deck = new Deck();

	public void welcomePlayer() {
		System.out.println("** Welcome to BlackJack! **\n");
	}

	public void shuffle() {
		deck.shuffle();
	}

	public Card dealCardToPlayer(Player player) {
		Card dealtCard = deck.dealCard();

		player.addCard(dealtCard);

		return dealtCard;
	}

	public String getStartingHand() {
		Card faceUpCard = hand.getHand().get(1);
		return "Dealer Hand: " + "[??]" + faceUpCard;
	}

	public void dealStartingHands(Player player) {
		System.out.println("Dealer deals " + dealCardToPlayer(player) + " to you");
		dealCardToPlayer(this);
		System.out.println("Dealer places a card face down");
		System.out.println("Dealer deals " + dealCardToPlayer(player) + " to you");
		System.out.println("Dealer places " + dealCardToPlayer(this) + " face up\n");
	}

}
