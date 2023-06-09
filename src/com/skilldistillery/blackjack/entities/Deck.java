package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends Card {

	private List<Card> deck = new ArrayList<>();

	public Deck() {

		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);

				deck.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return this.deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);

	}

}
