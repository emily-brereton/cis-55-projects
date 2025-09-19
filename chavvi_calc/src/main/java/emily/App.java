package emily;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

/*
 * Student Name: Emily Brereton
 * Course: CIS 59-101
 * Term/Year: Fall 2025
 * Date: 9/25/25
 * Project Name: ChavviCalc App
 */
public class App {
    public static void main(String[] args) {

        // initialize numerical variables and scanner object
        // A and B are the two numbers to be calculated
        float A = 0.000f;
        float B = 0.000f;
        Scanner input = new Scanner(System.in);
        String choice = "";

        // initialize Calc object
        Calc calc = new Calc();   

        // get user input, until user exits program
        while (!choice.equalsIgnoreCase("q")) {

            calc.printMenu(A, B);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "a", "A" -> {
                    A = calc.getA(input);
                }
                case "b", "B" -> {
                    B = calc.getB(input);
                }
                case "+" -> {
                    A = calc.getSum(A, B);
                }
                case "-" -> {
                    A = calc.getDifference(A, B);
                }
                case "*" -> {
                    A = calc.getProduct(A, B);
                }
                case "/" -> {
                    A = calc.getQuotient(A, B);
                }
                case "c", "C" -> {
                    A = calc.clearA(A);
                    B = calc.clearB(B);
                }
                case "q", "Q" -> System.out.println("System terminated.");
                default -> System.out.println("Invalid entry. Please try again.");
            }
        }
        input.close();
    }
}


class Calc {

    // instance variables
    private float A;
    private float B;

    // default constructor. Initialize Object with A and B = 0.000
    public Calc() {
        this.A = 0.000f;
        this.B = 0.000f;
    }

    // overloaded constructor. Initialize Object with user defined values for A and B
    public Calc(float A, float B) {
        this.A = A;
        this.B = B;
    }

    // sets the value of A
    public void setA(float A) {
        this.A = A;
    }
    
    // gets the value of A
    // try/catch statement: try prompts user to enter data; catch prevents exception when user enters non-numerical data
    public float getA(Scanner input) {
        try {
            System.out.print("Enter a value for A: ");
            A = input.nextFloat();
            input.nextLine();
            return A; 
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a numerical value.");
            input.nextLine(); // clear the invalid input
            return this.A; // return the current value of A 
        }
    }

    // sets the value of B
    public void setB(float B) {
        this.B = B;
    }

    // gets the value of B
    // try/catch statement: try prompts user to enter data; catch prevents exception when user enters non-numerical data
    public float getB(Scanner input) {
        try {
            System.out.print("Enter a value for B: ");
            B = input.nextFloat();
            input.nextLine();
            return B;
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a numerical value.");
            input.nextLine(); // clear the invalid input
            return this.B; // return the current value of B 
        }
    }
    // adds A and B, sum is saved in variable A, and returns the new value of A
    public float getSum(float A, float B) {
        A = A + B;
        return A;
    }

    // subtracts B from A, difference is saved in variable A, and returns the new value of A    
    public float getDifference(float A, float B) {
        A = A - B;
        return A;
    }

    // multiplies A and B, product is saved in variable A, and returns the new value of A
    public float getProduct(float A, float B) {
        A = A * B;
        return A;
    }

    // divides A by B, quotient is saved in variable A, and returns the new value of A
    // if B = 0, error message is printed and A remains unchanged
    public float getQuotient(float A, float B) {
        if (B == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return A;
        } else {
            A = A / B;
            return A;
        }
    }

    // clears the value of A, returns A as 0.000
    public float clearA(float A) {
        A = 0.000f;
        return A;
    }

    // clears the value of B, returns B as 0.000
    public float clearB(float B) {
        B = 0.000f;
        return B;
    }

    // prints the menu to the console
    public void printMenu(float A, float B) {

        DecimalFormat df = new DecimalFormat("0.000"); // formats A and B to 3 decimal places (including trailing zeros)
        df.setRoundingMode(RoundingMode.HALF_UP); // rounds up if the next digit is 5 or greater

        String menuTitle = """
                --------------------------------------
                Chavvi Calc
                --------------------------------------
                """;
        String menuVariables = "A = " + df.format(A) + "\t B = " + df.format(B); // format A and B to 3 decimal places and save as string
        String menuCommands = """
                --------------------------------------
                a \t Enter a value for A
                b \t Enter a value for B
                + \t Add
                - \t Subtract
                * \t Multiply
                / \t Divide
                c \t Clear
                q \t Quit
                --------------------------------------
                """;
        String menu = (menuTitle + menuVariables + "\n" + menuCommands); // combine all menu strings
        System.out.println(menu);
    }

}

