package emily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    protected void printMenu(){
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

    private void printCreateMenu(){
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

    // switch statement methods
    protected void createCat(Scanner input, ArrayList<PantheraGPS> allBigCats){
        String bigCatChoice = "";
        while (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")) {
            printCreateMenu();
            bigCatChoice = input.nextLine();
            bigCatChoice = bigCatChoice.toLowerCase();
                if (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")){
                    System.out.println("Invalid selection. Please try again");
                    }
            }
        System.out.println("Enter a name for your big cat: ");
        String name = input.nextLine();
        name = name.toUpperCase();
        name = noDuplicateName(name, allBigCats);
        HashMap<String,PantheraGPS> bigCats = makeHashMap(name);
        PantheraGPS newCat = bigCats.get(bigCatChoice);
        allBigCats.add(newCat);
        System.out.println(formatName(name) + " saved to your population."); 
        System.out.println(newCat.toString());
    }

    protected void deleteCat(Scanner input, ArrayList<PantheraGPS> allBigCats){
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

    protected void findCat(Scanner input, ArrayList<PantheraGPS> allBigCats){
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

    protected void listCats(ArrayList<PantheraGPS> allBigCats){
        System.out.println("Here is your current population:");
        for (var p : allBigCats) { System.out.println(p.toString());
        } 
    }


    // helper methods
    protected static String formatName(String name){
        if (name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }   

    private HashMap<String,PantheraGPS> makeHashMap(String name){
        HashMap<String,PantheraGPS> bigCats = new HashMap<String,PantheraGPS>();
            bigCats.put("t",new Tiger(name));
            bigCats.put("l",new Lion(name));
            bigCats.put("j",new Jaguar(name));
            return bigCats;
    }

    private String noDuplicateName(String name, ArrayList<PantheraGPS> allBigCats){
        for (var p : allBigCats) {
            if (p.name.equals(name)) {
                System.out.println("A big cat with that name already exists. Please choose a different name.");
                return "";
            }
        }
        return name;
    }
}