package emily;

public class Tiger extends Panthera{

    private final String furType = "stripes";
    private final boolean sleepsInTrees = false;
    private final String species = "Tiger";

    Tiger(){
        name = "not null";
    }

    Tiger(String name){
        this.name = name;
    }

    public String getSpecies(){
        return species;
    }


    @Override
    public String toString() {
        return "Big Cat {species='" + species + " " + name + "'}";
    }

}
