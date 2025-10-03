package emily;

public class Lion extends Panthera{

    private final String furType = "mane";
    private final boolean sleepsInTrees = false;
    String species;

    Lion(){
        name = "";
        species = "Lion";
    }

    Lion (String name){
        this.name = name;
        this.species = "Lion";
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