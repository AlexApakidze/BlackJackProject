package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BJApp {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BJApp bj = new BJApp();
		bj.run();
	}

	public void run() {
		dealer.welcomePlayer();
		dealer.shuffle();
		dealer.dealStartingHand(player);
		playBlackJack();
	}

	public void playBlackJack() {
		int choice = 0;
		boolean playerCanKeepHitting = true;
		boolean gameOn = true;

		while (gameOn) {

			while (playerCanKeepHitting) {

				if (player.hasBlackJack()) {
					showHands();
					System.out.println("You win!");
					playerCanKeepHitting = false;
					break;
				}

				if (dealer.hasBlackJack()) {
					showHands();
					System.out.println("You lose!");
					playerCanKeepHitting = false;
					break;
				}

				if (player.getHandValue() > 21) {
					showHands();
					System.out.println("You went over 21, you lose.");
					playerCanKeepHitting = false;
					break;
				}
				if (dealer.getHandValue() == player.getHandValue()) {
					showHands();
					System.out.println("Its a draw!");
				}

				System.out.println(dealer.getStartingHand());
				System.out.println("Your Hand: " + player.getHand());
				System.out.println("Hit: 1\nStay: 2");
				while (!sc.hasNextInt()) {
					System.out.println("Please pick 1 or 2.");
					sc.nextLine();
				}
				choice = sc.nextInt();
				
				while (choice > 2 || choice < 1) {
					System.out.println("Please pick 1 or 2.");
					try {
						choice = sc.nextInt();
					} catch (InputMismatchException e) {
						playerCanKeepHitting = false;
						break;
					}
				}
				sc.nextLine();

				switch (choice) {

				case 1:
					System.out.println(dealer.dealCardToPlayer(player) + " added to hand.\n");
					continue;
					
				case 2:
					if (dealer.getHandValue() < 17) {
						System.out.println("Dealer: " + dealer.getHand());
					}
					while (dealer.getHandValue() < 17) {
						System.out.println("Dealer draws a " + dealer.dealCardToPlayer(dealer));

					}
					if (dealer.getHandValue() >= 17) {
						playerCanKeepHitting = false;
						break;
					}
					
				default:
					System.out.println("That does not look like a 1 or 2 to me.\nYou lose!");
					continue;
				}

				if (dealer.getHandValue() > 21) {
					showHands();
					System.out.println("You Win!");
				} else if (dealer.getHandValue() > player.getHandValue()) {
					showHands();
					System.out.println("Dealer won.");
				} else if (dealer.getHandValue() < player.getHandValue()) {
					showHands();
					System.out.println("You Win!");
				} else if (dealer.getHandValue() == player.getHandValue()) {
					showHands();
					System.out.println("Its a draw!");
				}
			}

			boolean playerDecidesToPlayAgain = true;

			while (playerDecidesToPlayAgain) {
				choice = 0;
				System.out.println("\nPlay again?\n1: Yes\n2: No");
				while (!sc.hasNextInt()) {
					System.out.println("please pick 1 or 2.");
					sc.nextLine();
				}
				choice = sc.nextInt();
				while (choice > 2 || choice < 1) {
					System.out.println("Please pick 1 or 2.");
					choice = sc.nextInt();
				}

				sc.nextLine();
				switch (choice) {
				case 1:
					dealer = new Dealer();
					player = new Player();
					dealer.shuffle();
					dealer.dealStartingHand(player);
					playerCanKeepHitting = true;
					playerDecidesToPlayAgain = false;
					break;

				case 2:
					System.out.println("Thank you for playing!");
					playerCanKeepHitting = true;
					playerDecidesToPlayAgain = false;
					gameOn = false;
					break;
				default:
					System.out.println("That does not look like a 1 or 2 to me.");
					continue;
				}
			}
		}
	}

	public void showHands() {
		System.out.println("Dealer: " + dealer.getHand());
		System.out.println("Your Hand: " + player.getHand());
	}
}
