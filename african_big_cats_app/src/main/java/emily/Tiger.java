package emily;

public class Tiger extends Panthera{

    //private final String furType = "stripes";
    //private final boolean sleepsInTrees = false;

    Tiger(){
        name = "";
        Species t = Species.TIGER;   
    }

    Tiger(String name){
        this.name = name;
        this.species = Species.TIGER;
    }

   /*  public String Species(){
        return species;
    }

      @Override
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

    }*/
}
