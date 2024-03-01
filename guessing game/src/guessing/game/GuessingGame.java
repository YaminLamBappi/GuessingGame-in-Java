/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessing.game;

/**
 *
 * @author yamin
 */
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            // Difficulty selection
            System.out.println("Choose difficulty level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-1000)");
            int difficulty = scanner.nextInt();

            int maxNumber, allowedGuesses;
            switch (difficulty) {
                case 1:
                    maxNumber = 50;
                    allowedGuesses = 10;
                    break;
                case 2:
                    maxNumber = 100;
                    allowedGuesses = 7;
                    break;
                case 3:
                    maxNumber = 1000;
                    allowedGuesses = 5;
                    break;
                default:
                    System.out.println("Invalid difficulty level. Exiting...");
                    return;
            }

            // Game logic
            int secretNumber = (int) (Math.random() * maxNumber + 1);
            int guessCount = 0;
            int guess;
            

            do {
                System.out.print("Guess a number between 1 and " + maxNumber + ": ");
                guess = scanner.nextInt();
                guessCount++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again. Guess warmer.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again. Guess colder.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + guessCount + " tries (difficulty: " + difficulty + ").");
                }
            } while (guess != secretNumber && guessCount < allowedGuesses);

            // Display results with difficulty level and ask to play again
            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + guessCount + " tries (difficulty: " + difficulty + ").");
            } else {
                System.out.println("You ran out of guesses! The secret number was: " + secretNumber);
            }

            System.out.println("\nWould you like to play again? (y/n)");
            playAgain = scanner.next(); // Reuse the existing variable

        } while (playAgain.equalsIgnoreCase("y")); // Keep looping as long as user wants to play again

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
