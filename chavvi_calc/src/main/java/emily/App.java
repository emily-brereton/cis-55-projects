package emily;

import java.util.Scanner;
import java.lang.Math;

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
        // will need to round to 3 sig figs

        double A = 0.000;
        double B = 0.000;
        Scanner input = new Scanner(System.in);
        String choice = "";

        Calc calc = new Calc();


        // get user input
        while (!choice.equals("q")) {

            calc.printMenu(A, B);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "a" -> {
                    A = calc.getA(input);
                }
                case "b" -> {
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
                case "c" -> {
                    A = calc.clearA(A);
                    B = calc.clearB(B);
                }
                case "q" -> System.out.println("System terminated.");
                default -> System.out.println("Invalid entry. Please try again.");
            }
        }
        input.close();
    }
}


class Calc {

    private double A;
    private double B;

    public Calc() {
        this.A = 0.000;
        this.B = 0.000;
    }

    public Calc(double A, double B) {
        this.A = A;
        this.B = B;
    }

    public void setA(double A) {
        this.A = A;
    }
    
    public double getA(Scanner input) {
        try {
            System.out.print("Enter a value for A: ");
            double A = input.nextDouble();
            input.nextLine();
            return A; 
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a numerical value.");
            input.nextLine(); // clear the invalid input
            return this.A; // return the current value of A 
        }
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getB(Scanner input) {
        try {
            System.out.print("Enter a value for B: ");
            B = input.nextDouble();
            input.nextLine();
            return B;
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a numerical value.");
            input.nextLine(); // clear the invalid input
            return this.B; // return the current value of B 
        }
    }

    public double getSum(double A, double B) {
        A = A + B;
        return A;
    }

    public double getDifference(double A, double B) {
        A = A - B;
        return A;
    }

    public double getProduct(double A, double B) {
        A = A * B;
        return A;
    }

    public double getQuotient(double A, double B) {
        if (B == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return A;
        } else {
            A = A / B;
            return A;
        }
    }

    public double clearA(double A) {
        A = 0.000;
        return A;
    }

    public double clearB(double B) {
        B = 0.000;
        return B;
    }

 public void printMenu(double A, double B) {
    String menuTitle = """
                --------------------------------------
                Chavvi Calc
                --------------------------------------
                """;
        String menuVariables = "A = " + /*String.format("%.3f",*/ A + "\t B = " + /*String.format("%.3f",*/ B;
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
        String menu = (menuTitle + menuVariables + "\n" + menuCommands);
        System.out.println(menu);
    }

}

