package emily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    protected void printMenu() {
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

    private void printCreateMenu() {
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

    // Methods for menu options
    protected void createCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {

        String bigCatChoice = "";
        while (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")) {
            printCreateMenu();
            bigCatChoice = input.nextLine();
            bigCatChoice = bigCatChoice.toLowerCase();
            if (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")) {
                System.out.println("Invalid selection. Please try again");
            }
        }

        // name is saved in all upper case for easy comparison and retrieval
        // reject user-inputted name if a big cat object already exists with that name
        System.out.println("Enter a name for your big cat: ");
        String name = input.nextLine();
        name = name.toUpperCase();
        name = noDuplicateName(name, allBigCats);

        // HashMap instantiates correct Panthera object (Lion, Tiger, or Jaguar)
        HashMap<String, PantheraGPS> bigCats = makeHashMap(name);
        PantheraGPS newCat = bigCats.get(bigCatChoice);
        allBigCats.add(newCat);
        System.out.println(formatName(name) + " saved to your population.");

        // name formatted for display only
        System.out.println(newCat.toString());
    }

    // only removes big cat if the formatted input exactly matches an existing big
    // cat's name ("Dan" would not remove "Dani")
    protected void deleteCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {
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

    // search arrayList for a specific big cat
    // returns all cats whose name contains the user-inputted String
    // (i.e. "Dan" would return "Dan," "Dani," "Daniel")
    // prints latitude, longitude, speed, and species information for big cat(s)
    protected void findCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {
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

    // prints latitude, longitude, speed, and species info for all big cats
    protected void listCats(ArrayList<PantheraGPS> allBigCats) {
        System.out.println("Here is your current population:");
        for (var p : allBigCats) {
            System.out.println(p.toString());
        }
    }

    // standard name formatting for display only
    protected static String formatName(String name) {
        if (name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    // HashMap stores constructors for Panthera objects
    private HashMap<String, PantheraGPS> makeHashMap(String name) {
        HashMap<String, PantheraGPS> bigCats = new HashMap<String, PantheraGPS>();
        bigCats.put("t", new Tiger(name));
        bigCats.put("l", new Lion(name));
        bigCats.put("j", new Jaguar(name));
        return bigCats;
    }

    // only rejects user input if the formatted name matches exactly
    // ("Dan" accepted, even if "Dani" exists)
    private String noDuplicateName(String name, ArrayList<PantheraGPS> allBigCats) {
        for (var p : allBigCats) {
            if (p.name.equals(name)) {
                System.out.println("A big cat with that name already exists. Please choose a different name.");
                return "";
            }
        }
        return name;
    }
}