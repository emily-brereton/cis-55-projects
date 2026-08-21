package emily;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

/*
 * Student Name: Emily Brereton
 * Course: CIS 55-101
 * Term/Year: Fall 2026
 * Date: 8/20/26
 * Project Name: ChavviCalc App
 */
public class App {
    public static void main(String[] args) {

        float a = 0.0f;
        float b = 0.0f;
        Scanner input = new Scanner(System.in);
        String choice = "";
        Menu menu = new Menu();
        Calc calc = new Calc();   

        // print menu and get user input, until user exits program
        while (!choice.equalsIgnoreCase("q")) {

            menu.printMenu(calc);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            switch (choice) {
                case "a","A" -> {
                    calc.setA(calc.saveX("Enter a value for a: ",input));
                }
                case "b","B" -> {
                    calc.setB(calc.saveX("Enter a value for b: ",input));
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
                    a = calc.clear(a);
                    b = calc.clear(b);
                }
                case "q","Q" -> System.out.println("System terminated.");
                default -> System.out.println("Invalid entry. Please try again.");
            }
        }
        input.close();
    }
}

class Menu {

    // prints the menu to the console, formats and rounds a and b to three places 
    public void printMenu(Calc calc) {

        DecimalFormat df = new DecimalFormat("0.000");
        df.setRoundingMode(RoundingMode.HALF_UP);

        String menuTitle = """
                --------------------------------------
                Chavvi Calc
                --------------------------------------
                """;
        String menuVariables = "a = " + df.format(calc.getA()) + "\t b = " + df.format(calc.getB());
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
    String menu = (menuTitle + menuVariables + "\n" + menuCommands);
        System.out.println(menu);
    }

}


class Calc {

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

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }


    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }
    
    // method to obtain a value for any variable
    // try/catch statement: try prompts user to enter data; catch prevents exception when user enters non-numerical data
    private float getNumber(Scanner input,float n) {
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

    public float saveX(String message, Scanner input) {
        System.out.println(message);
        return getNumber(input,a);
    }


    // public float getB(Scanner input) {
    //     System.out.println("Enter a value for b: ");
    //     return getNumber(input, b);
    // }

    public float add(float a,float b) {
        return a += b;
    }

    public float subtract(float a,float b) {
        return a -= b;
    }

    public float multiply(float a,float b) {
        return a *= b;
    }

    // if b = 0, error message is printed and a remains unchanged
    public float divide(float a,float b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return a;
        } else {
            return a /= b;
        }
    }

    // reset variable to 0.0
    public float clear(float x) {
        return 0.0f;
    }
}