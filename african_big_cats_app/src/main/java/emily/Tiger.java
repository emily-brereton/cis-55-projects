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

}
