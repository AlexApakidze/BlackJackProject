package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Deck deck = new Deck();
		int userChoice;
		int value = 0;
		Card dealtCard;
		int dealtCardValue = 0;

		System.out.println("How many cards do you want?");
		while (!sc.hasNextInt()) {
			System.out.println("Please pick a whole number less than 53");
			sc.nextLine();
		}
		userChoice = sc.nextInt();

		if (userChoice > 52 || userChoice < 0) {
			System.out.println("That many cards dont exist in a playing deck\nPlease make the appropriate choice");
			userChoice = sc.nextInt();
		}

		for (int i = 0; i < userChoice; i++) {
			deck.shuffle();
			dealtCard = deck.dealCard();
			dealtCardValue = dealtCard.getValue();
			System.out.println(dealtCard);
			value = value + dealtCardValue;
		}
		System.out.println("Cards valued at " + value);

	}
}
