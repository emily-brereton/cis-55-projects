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
public class App 
{
    public static void main( String[] args )
    {
        // initialize numerical variables and scanner object
        // A and B are the two numbers to be calculated, result is the outcome
        // will need to round to 3 sig figs
        double A = 0.000;
        double B = 0.000;
        double result = 0.000;
        Scanner input = new Scanner(System.in);
        String choice = "";        

        // print display menu
        System.out.println("""
                --------------------------------------
                Chavvi Calc
                --------------------------------------
                """);
        System.out.println("A = " + A + "\t B = " + B );
        System.out.println("""
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
                """);
                
        // get user input
        while (!choice.equals("q")) {
            System.out.print("Enter a command: ");
            choice = input.nextLine();
            }        
        }
    }