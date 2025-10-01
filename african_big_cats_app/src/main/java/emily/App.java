package emily;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Student Name: Emily Brereton
 * Course: CIS 59-101
 * Term/Year: Fall 2025
 * Date: 10/23/25
 * Project Name: African Big Cats App
 */
public class App {
    public static void main(String[] args) {

        ArrayList<Panthera> allBigCats = new ArrayList<Panthera>();
        Scanner input = new Scanner(System.in);
        String selection = "";
        

        while(!selection.equals("q")){
            new Menu().printMenu();
            selection= input.nextLine().toLowerCase();

            switch (selection){
                case "c" -> {

                }
                case "d" -> {

                }
                case "f" -> {

                }
                case "l" -> {

                }
                case "q" -> {
                    System.out.println("Thank you for using the African Big Cats App!");

                 }
                default -> {
                    System.out.println("Invalid selection. Please try again");
                }
            }
        }
    }
}

class Menu {

    public void printMenu(){
        System.out.println("""
                ------------------------------------------------------------
                African Big Cats App
                ------------------------------------------------------------
                    c       [C]reate a big cat
                    d       [D]elete a big cat
                    f       [F]ind a big cat
                    l       [L]ist all big cats
                    q       [Q]uit
                ------------------------------------------------------------
                Enter a command: 
                """);
    }

}