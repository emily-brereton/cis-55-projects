package emily;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/*
 * Student Name: Emily Brereton
 * Course: CIS 59-101
 * Term/Year: Fall 2025
 * Date: 10/23/25
 * Project Name: African Big Cats App
 */
public class App {
    public static void main(String[] args) {

        var allBigCats = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String selection = "";
        

        while(!selection.equals("q")){
            Menu menu = new Menu();
            menu.printMenu();
            selection = input.nextLine().toLowerCase();

            switch (selection){
                case "c" -> {
                    menu.printCreateMenu();
                    String bigCatChoice = input.nextLine();
                    bigCatChoice = bigCatChoice.toLowerCase();
                    if (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")){
                        System.out.println("Invalid selection. Please try again");
                        break;
                    }
                    System.out.println("Enter a name for your big cat: ");
                    String name = input.nextLine();

                    HashMap<String,Object> bigCats = menu.makeHashMap(name);
                    var newCat = bigCats.get(bigCatChoice);

                    allBigCats.add(newCat);
                    System.out.println(name + " saved to your population.");

                    System.out.println(newCat.toString());
                    

                }
                case "d" -> {

                }
                case "f" -> {

                }
                case "l" -> {
                    System.out.println("Here is your current population:");
                    for (var p : allBigCats) { System.out.println(p.toString());
                    } 

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

    public void printCreateMenu(){
        System.out.println("""
            ------------------------------------------------------------
            Would you like to add a tiger, lion, or jaguar?
            ------------------------------------------------------------
                t       [T]iger
                l       [L]ion
                j       [J]aguar
            ------------------------------------------------------------
            Enter a command:
                    """);
    }

    public HashMap<String,Object> makeHashMap(String name){
        HashMap<String,Object> bigCats = new HashMap<>();
            bigCats.put("t",new Tiger(name));
            bigCats.put("l",new Lion(name));
            bigCats.put("j",new Jaguar(name));
            return bigCats;
    }

}