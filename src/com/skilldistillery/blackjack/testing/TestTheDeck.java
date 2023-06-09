package com.skilldistillery.blackjack.testing;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class TestTheDeck {

	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.checkDeckSize());
		final int initialDeckSize =deck.checkDeckSize();
		// for each of the 53 cards in the deck display each card
		for (int cardNumber = 0; cardNumber < initialDeckSize; cardNumber++) {
			Card card = deck.dealCard();
			System.out.println(card + " " + deck.checkDeckSize());
		}
	}

}
