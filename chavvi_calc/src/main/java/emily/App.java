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
        // a and b are the two numbers to be calculated
        float a = 0.0f;
        float b = 0.0f;
        Scanner input = new Scanner(System.in);
        String choice = "";

        // initialize Calc object
        Calc calc = new Calc();   

        // get user input, until user exits program
        while (!choice.equalsIgnoreCase("q")) {

            calc.printMenu(a,b);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "a","A" -> {
                    a = calc.getA(input);
                }
                case "b","B" -> {
                    b = calc.getB(input);
                }
                case "+" -> {
                    a = calc.add(a,b);
                }
                case "-" -> {
                    a = calc.subtract(a,b);
                }
                case "*" -> {
                    a = calc.multiply(a,b);
                }
                case "/" -> {
                    a = calc.divide(a,b);
                }
                case "c","C" -> {
                    a = calc.clearA(a);
                    b = calc.clearB(b);
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
    private float a;
    private float b;

    // default constructor. Initialize Object with a and b = 0.000
    public Calc() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    // overloaded constructor. Initialize Object with user defined values for a and b
    public Calc(float a,float b) {
        this.a = a;
        this.b = b;
    }

    // sets the value of a
    public void setA(float a) {
        this.a = a;
    }
    
    // gets the value of a
    // try/catch statement: try prompts user to enter data; catch prevents exception when user enters non-numerical data
    public float getA(Scanner input) {
        System.out.println("Enter a value for a: ");
        a = getNumber(input, a);
        return a;
    }

    // sets the value of b
    public void setB(float b) {
        this.b = b;
    }

    // gets the value of b
    public float getB(Scanner input) {
        System.out.println("Enter a value for b: ");
        b = getNumber(input, b);
        return b;
    }

    // method to obtain a value for any variable, from the user
    // try/catch statement: try prompts user to enter data; catch prevents exception when user enters non-numerical data
    public float getNumber(Scanner input, float n) {
        try {
            n = input.nextFloat();
            input.nextLine();
            return n;
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a numberical value.");
            input.nextLine();
            return n;
        }
    }


    // adds a and b, sum is saved in variable A, and returns the new value of a
    public float add(float a,float b) {
        a = a + b;
        return a;
    }

    // subtracts b from a, difference is saved in variable a, and returns the new value of a    
    public float subtract(float a,float b) {
        a = a - b;
        return a;
    }

    // multiplies a and b, product is saved in variable a, and returns the new value of a
    public float multiply(float a,float b) {
        a = a * b;
        return a;
    }

    // divides a by b, quotient is saved in variable a, and returns the new value of a
    // if b = 0, error message is printed and A remains unchanged
    public float divide(float a,float b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return a;
        } else {
            a = a / b;
            return a;
        }
    }

    // clears the value of a, returns a as 0.000
    public float clearA(float a) {
        a = 0.0f;
        return a;
    }

    // clears the value of b, returns b as 0.000
    public float clearB(float b) {
        b = 0.0f;
        return b;
    }

    // prints the menu to the console
    public void printMenu(float a,float b) {

        DecimalFormat df = new DecimalFormat("0.000");
        df.setRoundingMode(RoundingMode.HALF_UP);

        String menuTitle = """
                --------------------------------------
                Chavvi Calc
                --------------------------------------
                """;
        // format a and b to 3 decimal places and save as string
        String menuVariables = "a = " + df.format(a) + "\t b = " + df.format(b);
        String menuCommands = """
                --------------------------------------
                a \t Enter a value for a
                b \t Enter a value for b
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

