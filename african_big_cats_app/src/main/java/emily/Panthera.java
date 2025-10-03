package emily;

abstract class Panthera extends PantheraGPS{

    int weight;
    String furType;
    boolean sleepsInTrees;

// constructor
public Panthera(){
    super();
};

public void roar(){
    System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
}

public String toString() {
    return super.toString();
      /*   String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";

        return s; */

    }

}
