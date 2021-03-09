import java.util.Scanner;

public class RollDice {
    // Initialize variables used throughout the app
    public static int diceNum = 2;
    public static int dSides = 6;
    public static Scanner input = new Scanner(System.in);

    // Ask and recieve dice sides
    public static void getDiceSides() {
        System.out.println("How many sides for the dice?");
        dSides = input.nextInt();
    }

    // Prompt if user wants to roll
    public static boolean willRoll(boolean again) {
        String question = again ? "Do you want to roll again?" : "Do you want to roll the dice?";
        System.out.println(question);
        return input.next().equalsIgnoreCase("yes");
    }

    // Generate random number for each die
    public static int rollDice() {
        return (int) Math.floor(Math.random() * (dSides + 1));
    }

    // Main loop
    public static void loop() {
        int i = 1;
        do {
            System.out.println(rollDice());
            i++;
        } while (i <= diceNum);

        if (willRoll(true)) {
            loop();
        }
    }

    // First ask if user wants to roll
    public static void main(String args[]) {
        if (willRoll(false)) {
            getDiceSides();
            loop();
        } else {
            System.out.println("Thanks for coming!");
        }
    }
}
