package codesoftTask;

	import java.util.Random;
	import java.util.Scanner;

	public class NumberGuessingGame {

	    private static final int MIN = 1;
	    private static final int MAX = 100;
	    private static final int MAX_ATTEMPTS = 10;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int roundsWon = 0;
	        String playAgain;

	        do {
	            // Generate a random number between MIN and MAX
	            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
	            boolean guessedCorrectly = false;
	            int attemptsLeft = MAX_ATTEMPTS;

	            System.out.println("Welcome to the Guessing Game!");
	            System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ". You have " + MAX_ATTEMPTS + " attempts to guess it.");

	            while (attemptsLeft > 0 && !guessedCorrectly) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();
	                attemptsLeft--;

	                if (userGuess < MIN || userGuess > MAX) {
	                    System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
	                } else if (userGuess < numberToGuess) {
	                    System.out.println("Too low! Attempts left: " + attemptsLeft);
	                } else if (userGuess > numberToGuess) {
	                    System.out.println("Too high! Attempts left: " + attemptsLeft);
	                } else {
	                    guessedCorrectly = true;
	                    System.out.println("Congratulations! You guessed the number correctly.");
	                }
	            }

	            if (!guessedCorrectly) {
	                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
	            } else {
	                roundsWon++;
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next();
	        } while (playAgain.equalsIgnoreCase("yes"));

	        System.out.println("Game Over! You won " + roundsWon + " round(s).");
	        scanner.close();
	    }
	}

