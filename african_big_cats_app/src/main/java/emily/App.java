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

        ArrayList<PantheraGPS> allBigCats = new ArrayList<PantheraGPS>();
        Scanner input = new Scanner(System.in);
        String selection = "";
        

        while(!selection.equals("q")){
            Menu menu = new Menu();
            menu.printMenu();
            selection = input.nextLine().toLowerCase();

            switch (selection){
                case "c" -> {
                    String bigCatChoice = "";
                    while (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")) {
                        menu.printCreateMenu();
                        bigCatChoice = input.nextLine();
                        bigCatChoice = bigCatChoice.toLowerCase();
                            if (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")){
                                 System.out.println("Invalid selection. Please try again");
                                }
                            }
                        System.out.println("Enter a name for your big cat: ");
                        String name = input.nextLine();
                        name = name.toUpperCase();
                        name = menu.noDuplicateName(name, allBigCats);
                        

                    HashMap<String,PantheraGPS> bigCats = menu.makeHashMap(name);
                    PantheraGPS newCat = bigCats.get(bigCatChoice);

                    allBigCats.add(newCat);
                    System.out.println(Menu.formatName(name) + " saved to your population."); 
                    System.out.println(newCat.toString());
                }
                
                case "d" -> {
                    System.out.println("Please enter the name of the big cat you want to delete: ");
                    String nameToDelete = input.nextLine();
                    nameToDelete = nameToDelete.toUpperCase();
                    boolean found = false;
                    for (var p : allBigCats) {
                        if (p.name.equals(nameToDelete) == true) {
                            allBigCats.remove(p);
                            System.out.println(Menu.formatName(nameToDelete) + " has been removed from your population.");
                            found = true;
                            break;
                        }
                    }
                    if (found == false) {
                        System.out.println("No big cat with that name was found. Please try again.");
                    }
                }
                case "f" -> {
                    System.out.println("Please enter the name of the big cat you want to find: ");
                    String nameToFind = input.nextLine();
                    nameToFind = nameToFind.toUpperCase();
                    boolean found = false;
                    for (var p : allBigCats) {
                        if (p.name.contains(nameToFind) == true) {
                            System.out.println(p.toString());
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("No big cat with that name was found. Please try again.");
                    }

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
        input.close();
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

    public static String formatName(String name){
        if (name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }   

    public HashMap<String,PantheraGPS> makeHashMap(String name){
        HashMap<String,PantheraGPS> bigCats = new HashMap<String,PantheraGPS>();
            bigCats.put("t",new Tiger(name));
            bigCats.put("l",new Lion(name));
            bigCats.put("j",new Jaguar(name));
            return bigCats;
    }

    public String noDuplicateName(String name, ArrayList<PantheraGPS> allBigCats){
        for (var p : allBigCats) {
            if (p.name.equals(name)) {
                System.out.println("A big cat with that name already exists. Please choose a different name.");
                return "";
            }
        }
        return name;
    }

}