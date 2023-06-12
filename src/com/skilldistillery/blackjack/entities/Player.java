package com.skilldistillery.blackjack.entities;

public class Player {

	protected Hand hand = new BlackJackHand();

	public Hand getHand() {
		return hand;
	}

	public int getHandValue() {
		return hand.getHandValue();
	}

	public void addCard(Card card) {
		hand.addCardToHand(card);
	}

	public boolean hasBlackJack() {
		return hand.getHandValue() == 21 && hand.getHand().size() == 2;
	}

}
