package emily;

import java.util.Random;

public class Lion extends Panthera{

     //private final String furType = "stripes";
    //private final boolean sleepsInTrees = false;

    Lion(){
        name = "";
        Species l = Species.LION;   
    }

    Lion(String name){
        this.name = name;
        this.species = Species.LION;
        this.longitude = super.longitude();
        this.latitude = super.latitude();
    }

}
