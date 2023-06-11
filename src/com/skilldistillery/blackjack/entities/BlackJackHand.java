package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : playerHand) {

			handValue = handValue + card.getValue();
		}

		return handValue;
	}

	public boolean isBlackJack() {
		if (this.getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		}
		return false;
	}
	
	public boolean isHighAce() {
		for (Card card : playerHand) {
			if(card.getRank() == Rank.ACE) {
				return true;
			}
		}
		return false;
	}

}
