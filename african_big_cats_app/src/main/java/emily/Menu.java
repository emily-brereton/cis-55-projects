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
                    r       [R]isk report
                    w       [W]arning report
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
        while (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")
                && !bigCatChoice.equals("r") && !bigCatChoice.equals("w")) {
            printCreateMenu();
            bigCatChoice = input.nextLine();
            bigCatChoice = bigCatChoice.toLowerCase();
            if (!bigCatChoice.equals("t") && !bigCatChoice.equals("l") && !bigCatChoice.equals("j")
                    && !bigCatChoice.equals("r") && !bigCatChoice.equals("w")) {
                System.out.println("Invalid selection. Please try again");
            }
        }

        // prompt user to enter name
        // reject name if a big cat object already exists with that name
        String name = "none";
        name = noDuplicateName(input, name, allBigCats);

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
        String message = "Please enter the name of the big cat you wish to delete: ";
        PantheraGPS catToDelete = catExists(input, allBigCats, message);

        System.out.println(Menu.formatName(catToDelete.name()) + " has been removed from your population.");
        allBigCats.remove(catToDelete);
        /*
         * System.out.
         * println("Please enter the name of the big cat you want to delete: ");
         * String nameToDelete = input.nextLine();
         * nameToDelete = nameToDelete.toUpperCase();
         * boolean found = false;
         * for (var p : allBigCats) {
         * if (p.name.equals(nameToDelete) == true) {
         * allBigCats.remove(p);
         * System.out.println(Menu.formatName(nameToDelete) +
         * " has been removed from your population.");
         * found = true;
         * break;
         * }
         * }
         * if (found == false) {
         * System.out.println("No big cat with that name was found. Please try again.");
         */
    }

    // search arrayList for a specific big cat
    // returns all cats whose name contains the user-inputted String
    // (i.e. "Dan" would return "Dan," "Dani," "Daniel")
    // prints latitude, longitude, speed, and species information for big cat(s)
    protected void findCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        System.out.println("Please enter the name of the big cat you want to find: ");
        catsExist(input, allBigCats);
    }

    // prints latitude, longitude, speed, and species info for all big cats
    protected void listCats(ArrayList<PantheraGPS> allBigCats) {
        System.out.println("Here is your current population:");
        for (var p : allBigCats) {
            System.out.println(p.toString());
        }
    }

    // risk report
    protected void riskReport(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        String message = "Please enter the name of the first big cat you want to compare: ";
        PantheraGPS catA = catExists(input, allBigCats, message);
        System.out.println();

        message = "Please enter the name of the second big cat you want to compare: ";
        PantheraGPS catB = catExists(input, allBigCats, message);
        System.out.println();

        double distance = distance(catA.getLongitude(), catB.getLongitude(), catA.getLatitude(), catB.getLatitude());
        System.out.println(distance);
    }

    protected void warningReport(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        System.out.println("Please enter your approximate longitude: ");
        String lon = input.nextLine();
        float longitude = Float.parseFloat(lon);

        System.out.println("Please enter your approximate latitude: ");
        String lat = input.nextLine();
        float latitude = Float.parseFloat(lat);

        PantheraGPS closestCat = new PantheraGPS();
        double distance = 1000000.0;
        double compareDistance;

        for (PantheraGPS p : allBigCats) {
            compareDistance = distance(longitude, p.getLongitude(), latitude, p.getLatitude());
            if (compareDistance < distance) {
                closestCat = p;
                distance = compareDistance;
            }
        }
        System.out.println("The closest cat is " + closestCat.name() + " the " + closestCat.species() + ". They are "
                + distance + " feet away from you.");
    }

    /*
     * helper methods
     */

    // list all cats with names containing user-inputted string
    private void catsExist(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        boolean found = false;
        while (found != true) {
            String nameToFind = input.nextLine();
            nameToFind = nameToFind.toUpperCase();
            for (PantheraGPS p : allBigCats) {
                if (p.name.contains(nameToFind) == true) {
                    found = true;
                    System.out.println(p.toString());
                }
            }
            if (found == false) {
                System.out.println("No big cat with that name was found. Please try again.");
            }
        }
    }

    // return cat only if their name matches exactly
    private PantheraGPS catExists(Scanner input, ArrayList<PantheraGPS> allBigCats, String message) {
        PantheraGPS cat = new PantheraGPS();
        boolean found = false;
        while (found != true) {
            System.out.println(message);
            String name = input.nextLine();
            name = name.toUpperCase();
            for (PantheraGPS p : allBigCats) {
                if (p.name.equals(name) == true) {
                    found = true;
                    cat = p;
                }
            }
            if (found == false) {
                System.out.println("No big cat with that name was found. Please try again.");
            }
        }
        return cat;
    }

    // distance formula
    private double distance(float longA, float longB, float latA, float latB) {
        double distance = Math.sqrt(Math.pow((longB - longA), 2) + Math.pow((latB - latA), 2));
        return distance;
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
    private String noDuplicateName(Scanner input, String name, ArrayList<PantheraGPS> allBigCats) {
        while (name.equals("none")) {
            System.out.println("Enter a name for your big cat: ");
            name = input.nextLine();

            // name is saved in all upper case for easy comparison and retrieval
            name = name.toUpperCase();
            for (var p : allBigCats) {
                if (p.name.equals(name)) {
                    System.out.println("A big cat with that name already exists. Please choose a different name.");
                    name = "none";
                }
            }
        }
        return name;
    }
}