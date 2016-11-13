
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Instantiate the game
 * @author Ling
 */
public class Game {

	private int sequence = 1;
	private final int randomComputer = 1;
	private final int smaterComputer = 2;
	private final int predictableComputer = 3;
	/**
	 * 
	 */
	private final int humanPlayer = 4;
	private boolean humanOppent = false;
	private Scanner kb = new Scanner(System.in);
	private int selection;

	/**
	 * 
	 */
	public void running() {
		System.out.print("Please enter your name: ");
		Player human = new Player(kb.nextLine());
		System.out.print("Random computer[1], Smater computer[2], " + 
		"Predictable computer[3]," + " Human Player[4]"
				+ " which one? : ");
		Computer opponent;

		switch (kb.nextInt()) {
		case predictableComputer:
			opponent = new PredictableComputer("Predictable Computer");
			run(human, opponent);
			break;

		case randomComputer:
			opponent = new RandomComputer("Random Computer");
			run(human, opponent);
			break;

		case smaterComputer:
			opponent = new Computer("Smart Computer");
			run(human, opponent);
			break;

		case humanPlayer:
			opponent = new HumanPlayer("Human Player");
			humanOppent = true;
			run(human, opponent);
			break;

		default:
			System.out.println("invaild input");
			break;
		}

	}

	/**
	 * Show information of player on the console
	 * @param player1
	 * @param player2
	 */
	private void screen(Player player1, Computer player2) {
		System.out.println(player1.getName() + " Deck: " + player1.getSize() + "   " 
	                + player2.getName() + " Deck: "+ player2.getSize());
		System.out.println("Human player: " + player1.getAttributes());
		System.out.println("Computer player " + player2.getAttributes());
		if (sequence == 1 || humanOppent == true) {
			System.out.println("***************************************************");
			System.out.println("Hearts[0] " + "Spades[1] " + "Diamonds[2] " + "Clubs[3] ");
			System.out.println("***************************************************");
			System.out.print("Press keyboard to select the attribute to compare: ");
			selection = kb.nextInt();
		}
	}

	/**
	 * @param player1
	 * @param player2
	 */
	private void run(Player player1, Computer player2) {
		while (player1.getSize() != 0 && player2.getSize() != 0) {
			screen(player1, player2);
			comparing(player1, player2);
			// System.out.println("***************************************************");
			System.out.println(" ");
			gameOver(player1, player2);
		}
	}

	/**
	 * Game over when condition satisfied
	 * @param player1
	 * @param player2
	 */
	private void gameOver(Player player1, Computer player2) {
		if (player1.getSize() == 0) {
			System.out.println("GAME OVER, "+ player2.getName()+" WIN");
		}
		if (player2.getSize() == 0) {
			System.out.println("GAME OVER, "+player1.getName()+" WIN");
		}
	}

	/**
	 * @param player1
	 * @param player2
	 * @return true if player1 > player2
	 */
	private boolean comparing(Player player1, Computer player2) {
		try {
			if (sequence == 1 || humanOppent == true) {

				if (player1.Compare(player2, selection) == true) {
					player2.removeCard();
					player1.shiftCard();
					sequence = 1;
					System.out.println(player1.getName() + " win");
					System.out.println(" ");
					return true;
				} else {
					player1.removeCard();
					player2.shiftCard();
					sequence = 0;
					System.out.println(player1.getName() + " lose");
					return false;
				}
			}

			if (sequence == 0) {

				if (player2.Compare(player1, selection) == true) {
					System.out.println("value of computer: " + player2.getAttributeValue(Computer.position)
							+ "     value of player: " + player1.getAttributeValue(Computer.position));
					player1.removeCard();
					player2.shiftCard();
					sequence = 0;
					System.out.println(player1.getName() + " lose");
					return false;
				} else {
					System.out.println("value of computer: " + player2.getAttributeValue(Computer.position)
							+ "     value of player: " + player1.getAttributeValue(Computer.position));
					player2.removeCard();
					player1.shiftCard();
					sequence = 1;
					System.out.print(player1.getName() + " win");
					System.out.println(" ");
					return true;
				}
			}
		} catch (IOException ioe) {
			System.out.println("Cannot found it");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Input out of Bounds --- not in [0,3]");
		}

		return false;
	}

}
