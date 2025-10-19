package emily;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Student Name: Emily Brereton
 * Course: CIS 59-101
 * Term/Year: Fall 2025
 * Date: 10/23/25
 * Project Name: African Big Cats App Part 1
 */
public class App {
    public static void main(String[] args) {

        ArrayList<PantheraGPS> allBigCats = new ArrayList<PantheraGPS>();
        Scanner input = new Scanner(System.in);
        String selection = "";

        while (!selection.equals("q")) {
            Menu menu = new Menu();
            menu.printMenu();
            selection = input.nextLine().toLowerCase();

            switch (selection) {
                case "c" -> {
                    menu.createCat(input, allBigCats);
                }
                case "d" -> {
                    menu.deleteCat(input, allBigCats);
                }
                case "f" -> {
                    menu.findCat(input, allBigCats);
                }
                case "l" -> {
                    menu.listCats(allBigCats);
                }
                case "q" -> {
                    System.out.println("Thank you for using the African Big Cats App!");
                }
                default -> {
                    System.out.println("Invalid selection. Please try again");
                }
            }
        }
        input.close();
    }
}