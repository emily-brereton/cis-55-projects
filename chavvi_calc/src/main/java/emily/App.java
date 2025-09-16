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

        calc.printMenu(A, B);

        // get user input
        while (!choice.equals("q")) {

            calc.printMenu(calc.getA(input), calc.getB(input));

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "a" -> {
                    calc.getA(input);
                }
                case "b" -> {
                    //B = getB(input, B);
                }
                case "+" -> {
                    //A = getSum(A, B);
                }
                case "-" -> {
                    //A = getDifference(A, B);
                }
                case "*" -> {
                    //A = getProduct(A, B);
                }
                case "/" -> {
                    //A = getQuotient(A, B);
                }
                case "c" -> {
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
        System.out.print("Enter a value for A: ");
        double A = input.nextDouble();
        input.nextLine();
        return A;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getB(Scanner input) {
        System.out.print("Enter a value for B: ");
        B = input.nextDouble();
        input.nextLine();
        return B;
    }

    public static double getSum(double A, double B) {
        A = A + B;
        return A;
    }

    public static double getDifference(double A, double B) {
        A = A - B;
        return A;
    }

    public static double getProduct(double A, double B) {
        A = A * B;
        return A;
    }

    public static double getQuotient(double A, double B) {
        if (B == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return A;
        } else {
            A = A / B;
            return A;
        }
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

/*
 * 
 * // switch between menu options to select relevant code
 * switch (choice) {
 * case "a" -> {
 * System.out.print("Enter a value for A: ");
 * A = input.nextDouble();
 * input.nextLine();
 * System.out.println("A = " + A);
 * }
 * case "b" -> {
 * System.out.print("Enter a value for B: ");
 * B = input.nextDouble();
 * input.nextLine();
 * System.out.println("B = " + B);
 * }
 * case "+" -> {
 * result = A + B;
 * System.out.printf("Result: %.3f\n", result);
 * }
 * case "-" -> {
 * result = A - B;
 * System.out.printf("Result: %.3f\n", result);
 * }
 * case "*" -> {
 * result = A * B;
 * System.out.printf("Result: %.3f\n", result);
 * }
 * case "/" -> {
 * if (B == 0) {
 * System.out.println("Error: Division by zero is not allowed.");
 * } else {
 * result = A / B;
 * System.out.printf("Result: %.3f\n", result);
 * }
 * }
 * case "c" -> {
 * A = 0.000;
 * B = 0.000;
 * result = 0.000;
 * System.out.println("Cleared. A = " + A + "\t B = " + B);
 * }
 * case "q" -> System.out.println("System terminated.");
 * default -> System.out.println("Invalid entry. Please try again.");
 * }
 * }
 * }
 * }
 */