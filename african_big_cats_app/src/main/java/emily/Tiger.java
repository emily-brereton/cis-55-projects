package emily;

public class Tiger extends Panthera{

    private final String furType = "stripes";
    private final boolean sleepsInTrees = false;
    String species;

    Tiger(){
        name = "not null";
    }

    Tiger(String name){
        this.name = name;
        this.species = "Tiger";
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
