package emily;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    protected void printMenu() {
        System.out.println("""
                ------------------------------------------------------------
                African Big Cats App
                ------------------------------------------------------------
                    c   [C]reate a big cat
                    d   [D]elete a big cat
                    f   [F]ind a big cat
                    l   [L]ist all big cats
                    r   [R]isk report
                    w   [W]arning report
                    q   [Q]uit
                ------------------------------------------------------------
                Enter a command:
                """);
    }

    private void printCreateMenu() {
        System.out.println("""
                ------------------------------------------------------------
                What kind of big cat would you like to add?
                ------------------------------------------------------------
                    t   [T]iger
                    l   [L]ion
                    j   [J]aguar
                ------------------------------------------------------------
                Enter a command:
                """);
    }

    protected void createCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {

        // Prompt user until valid cat type is chosen
        String bigCatChoice;
        Set<String> validChoices = Set.of("t", "l", "j");

        do {
            printCreateMenu();
            bigCatChoice = input.nextLine().trim().toLowerCase();
            if (!validChoices.contains(bigCatChoice)) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (!validChoices.contains(bigCatChoice));

        // Get a unique name for the new cat
        String name = noDuplicateName(input, "none", allBigCats);

        // Create the appropriate PantheraGPS object based on user choice
        PantheraGPS newCat = switch (bigCatChoice) {
            case "l" -> new Lion(name);
            case "t" -> new Tiger(name);
            case "j" -> new Jaguar(name);
            default -> throw new IllegalArgumentException("Unexpected cat type: " + bigCatChoice);
        };

        allBigCats.add(newCat);
        System.out.println(formatName(name) + " saved to your population.");
        System.out.println(newCat);
    }

    protected void deleteCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        String message = "Please enter the name of the big cat you wish to delete: ";
        PantheraGPS catToDelete = catExists(input, allBigCats, message);
        allBigCats.remove(catToDelete);
        System.out.println(formatName(catToDelete.name()) + " has been removed from your population.");
    }

    protected void findCat(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        System.out.println("Please enter part or all of the name of the big cat you want to find: ");
        catsExist(input, allBigCats);
    }

    protected void listCats(ArrayList<PantheraGPS> allBigCats) {
        if (allBigCats.isEmpty()) {
            System.out.println("No big cats in your population yet.");
            return;
        }
        System.out.println("Here is your current population:");
        for (PantheraGPS p : allBigCats) {
            System.out.println(p);
        }
    }

    protected void riskReport(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        String message = "Enter the name of the first big cat to compare: ";
        PantheraGPS catA = catExists(input, allBigCats, message);

        message = "Enter the name of the second big cat to compare: ";
        PantheraGPS catB = catExists(input, allBigCats, message);

        double distance = distance(catA.getLongitude(), catB.getLongitude(), catA.getLatitude(), catB.getLatitude());
        System.out.printf("The distance between %s and %s is %.2f feet.%n",
                formatName(catA.name()), formatName(catB.name()), distance);
    }

    protected void warningReport(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        System.out.print("Enter your approximate longitude: ");
        float longitude = Float.parseFloat(input.nextLine());

        System.out.print("Enter your approximate latitude: ");
        float latitude = Float.parseFloat(input.nextLine());

        PantheraGPS closestCat = null;
        double minDistance = Double.MAX_VALUE;

        for (PantheraGPS p : allBigCats) {
            double compareDistance = distance(longitude, p.getLongitude(), latitude, p.getLatitude());
            if (compareDistance < minDistance) {
                closestCat = p;
                minDistance = compareDistance;
            }
        }

        if (closestCat != null) {
            System.out.printf("The closest cat is %s the %s, approximately %.2f feet away.%n",
                    formatName(closestCat.name()), closestCat.species(), minDistance);
        } else {
            System.out.println("No cats found in your population.");
        }
    }

    // ---------- Helper Methods ----------

    private void catsExist(Scanner input, ArrayList<PantheraGPS> allBigCats) {
        String nameToFind = input.nextLine().toUpperCase();
        boolean found = false;

        for (PantheraGPS p : allBigCats) {
            if (p.name.contains(nameToFind)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No big cat with that name was found.");
        }
    }

    private PantheraGPS catExists(Scanner input, ArrayList<PantheraGPS> allBigCats, String message) {
        PantheraGPS cat = null;
        boolean found = false;

        while (!found) {
            System.out.print(message);
            String name = input.nextLine().toUpperCase();

            for (PantheraGPS p : allBigCats) {
                if (p.name.equals(name)) {
                    cat = p;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No big cat with that name was found. Please try again.");
            }
        }
        return cat;
    }

    private double distance(float longA, float longB, float latA, float latB) {
        return Math.sqrt(Math.pow(longB - longA, 2) + Math.pow(latB - latA, 2));
    }

    protected static String formatName(String name) {
        if (name.isEmpty())
            return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private String noDuplicateName(Scanner input, String name, ArrayList<PantheraGPS> allBigCats) {
        while (name.equals("none")) {
            System.out.print("Enter a name for your big cat: ");
            name = input.nextLine().toUpperCase();

            for (PantheraGPS p : allBigCats) {
                if (p.name.equals(name)) {
                    System.out.println("A big cat with that name already exists. Please choose a different name.");
                    name = "none";
                    break;
                }
            }
        }
        return name;
    }
}
