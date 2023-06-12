package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		int aceCount = 0;
		
		for (Card card : playerHand) {

			handValue = handValue + card.getValue();
			
			if (card.getRank() == Rank.ACE) {
				aceCount++;
			}
		}
		if ((this.hasAnAce() && handValue > 21)) {
			for (int i = 0; i < aceCount; i++) {
				handValue = handValue - 10;
			}
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

	
	public boolean hasAnAce() {
		for (Card card : playerHand) {
			if (card.getRank() == Rank.ACE) {
				return true;
			}
		}
		return false;
	}

}
