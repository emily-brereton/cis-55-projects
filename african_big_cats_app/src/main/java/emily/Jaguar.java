package emily;

public class Jaguar extends Panthera{

    private final String furType = "spots";
    private final boolean sleepsInTrees = true;
    String species;

    Jaguar(){
        name = "";
        species = "Jaguar";
    }

    Jaguar (String name){
        this.name = name;
        this.species = "Jaguar";
    }

    public String Species(){
        return species;
    }

    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "species: " + Species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";

        return s;

    }
}