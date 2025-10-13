package emily;

public class Jaguar extends Panthera{

   //private final String furType = "stripes";
    //private final boolean sleepsInTrees = false;

    Jaguar(){
        name = "";
        Species j = Species.JAGUAR;   
    }

    Jaguar(String name){
        this.name = name;
        this.species = Species.JAGUAR;
        this.longitude = super.longitude();
        this.latitude = super.latitude();
    }
}

