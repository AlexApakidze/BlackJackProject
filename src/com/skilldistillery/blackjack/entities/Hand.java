package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> playerHand = new ArrayList<>();

	Hand() {

	}

	@Override
	public String toString() {
		List<Card> currentHand = new ArrayList();
		for (Card card : playerHand) {
			currentHand.add(card);
		}

		return currentHand.toString();
	}

	public List<Card> getHand() {
		return playerHand;
	}

	public void addCardToHand(Card card) {
		playerHand.add(card);
	}

	public abstract int getHandValue();

	public void clearHand() {
		playerHand = null;
	}
}
