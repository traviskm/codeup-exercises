import java.util.Scanner;

public class MethodsExercises {
    // Exercise 1
        public static int addition(int num1, int num2) {
            return num1 + num2;
        }

        public static int subtraction(int num1, int num2) {
            return num1 - num2;
        }

        public static int multiplication(int num1, int num2) {
            return num1 * num2;
        }

        // Bonus 1a
            public static int bonusMultiplicationA(int num1, int num2) {
                int multiplied = 0;
                do {
                    multiplied += num1;
                    num2--;
                } while(num2 != 0);

                return multiplied;
            }

        // Bonus 1b
            public static int bonusMultiplicationB(int num1, int num2) {
                int multiplied = 0;
                if (num2 != 0) {
                    multiplied = num1 + bonusMultiplicationB(num1, num2 - 1);
                }
                return multiplied;
            }

        public static int division(int num1, int num2) {
            return num1 / num2;
        }

        public static int modulus(int num1, int num2) {
            return num1 % num2;
        }

    // Exercise 2
        // method used to check truthy-ness of number range in next two exercises
        public static boolean isBetween(int min, int max, int check) {
            return (min <= check && max >= check);
        }

        // method used to print range and grab input
        public static int getRangeInput(int min, int max, Scanner input) {
            System.out.println("Enter a number between " + min + " and " + max + ":");
            return input.nextInt();
        }

        public static int getInteger(int min, int max, Scanner input) {
            int userInt = getRangeInput(min, max, input);
            if (!isBetween(min, max, userInt)) {
                System.out.println("That wasn't within the range! Try again.");
                userInt = getInteger(min, max, input);
            }
            return userInt;
        }

    // Exercise 3
        // for loop
        public static void factorialFor(Scanner input) {
            int min = 1;
            int max = 10;
            int userInt = getInteger(min, max, input);
            String factorialOutput = "!" + userInt + " = ";
            long factorialNum = 1;
            for (int i = 1; i <= userInt; i++) {
                factorialNum *= i;
                factorialOutput += (i != 1) ? " x " + i : i;

                if (i == userInt) {
                    System.out.println(factorialOutput + " = " + factorialNum);
                    System.out.println("Would you like to continue?");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("yes")) {
                        userInt = getInteger(min, max, input);
                        i = 0;
                        factorialNum = 1;
                        factorialOutput = "!" + userInt + " = ";
                    }
                }
            }
        }

    // Exercise 3 BONUS
        /*
            Biggest number factorial held by a long: !20
            Change range to 1 -> 20
        */

        // Recursive function to calculate the factorial of a given number while building an output string to display it
        public static String calculateFactorial(int nextNum, int userInt, long factorialNum, String factorialString) {
            if (nextNum <= userInt) {
                factorialNum *= nextNum;
                factorialString += (nextNum != 1) ? " x " + nextNum : nextNum;
                factorialString = calculateFactorial(nextNum + 1, userInt, factorialNum, factorialString);
            } else {
                factorialString += " = " + factorialNum;
            }

            return factorialString;
        }

        // Recursive function to interact with user and determine starting values of the calculateFactorial function
        public static void factorialRecursion(Scanner input) {
            int min = 1;
            int max = 10;
            int userInt = getInteger(min, max, input);
            String startingString = "!" + userInt + " = ";

            System.out.println(calculateFactorial(1, userInt, 1, startingString));

            System.out.println("Would you like to continue?");
            String answer = input.next();
            if (answer.equalsIgnoreCase("yes")) {
                factorialRecursion(input);
            }
        }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // test output of addition()
        // System.out.println(addition(2, 6));

        // test output of subtraction()
        // System.out.println(subtraction(7, 5));

        // test the output of multiplication()
        // System.out.println(multiplication(8, 8));

        // test the output of division()
        // System.out.println(division(10, 2));

        // test the output of modulus()
        // System.out.println(modulus(8, 5));

        // test the output of bonusMultiplicationA()
        // System.out.println(bonusMultiplicationA(12, 10));

        // test the output of bonusMultiplicationB()
        // System.out.println(bonusMultiplicationB(5, 3));

        // Testing Exercise 2
        // int userInput = getInteger(1, 10, input);
        // System.out.println("Your number was: " + userInput);

        // Testing Exercise 3 - for loop
        // factorialFor(input);

        // Testing Exercise 3 - recursion
        // factorialRecursion(input);
    }
}
