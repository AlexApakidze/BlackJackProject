package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("♥"), SPADES("♠"), CLUBS("♣"), DIAMONDS("♦");

	private final String symbol;

	Suit(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

}
