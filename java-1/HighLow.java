import java.util.Scanner;

public class HighLow {
    // Initialize variables used throughout the game
    public static Scanner input = new Scanner(System.in);
    public static int userGuess = 0;
    public static int guessNum = 0;
    public static int guessLimit = 10;
    public static int compNum = 0;
    public static int guessMin = 1;
    public static int guessMax = 100;

    // Generate the random number
    public static void randomNumber() {
        compNum = (int) Math.floor(Math.random() * (guessMax + guessMin));
    }

    // Validate that the number is between the min & max
    public static boolean isBetween(int min, int max, int check) {
        return (min <= check && max >= check);
    }

    public static void guessAgain() {
        if (input.next().equalsIgnoreCase("yes")) {
            guessNum = 0;
            randomNumber();
            guess();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    // Check if the user's guess was lower, higher, or correct
    public static void checkGuess() {
        if (userGuess < compNum) {
            System.out.println("Your guess is lower.");
            guess();
        } else if (userGuess > compNum) {
            System.out.println("Your guess is higher");
            guess();
        } else {
            System.out.println("You got it right! You guessed " + guessNum + " times.\nWant to go again?");
            guessAgain();
        }
    }

    // Check if the user has reached the maximum number of guesses
    public static void checkMaxGuesses() {
        if (guessNum == guessLimit) {
            System.out.println("You've reached the maximum number of guesses!\nWant to try again?");
            guessAgain();
        }
    }

    // Main loop, asks for user input and uses checkGuess();
    public static void guess() {
        System.out.println("Guess a number between 1 and 100:");
        int initial = input.nextInt();
        if (isBetween(guessMin, guessMax, initial)) {
            guessNum++;
            checkMaxGuesses();
            userGuess = initial;
            checkGuess();
        } else {
            System.out.println("Your guess was not in the required range!");
            guess();
        }
    }

    // Generate the initial random number and begin the loop
    public static void main(String args[]) {
        randomNumber();
        guess();
    }
}
