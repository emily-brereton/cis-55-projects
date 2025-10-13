package emily;

public class Jaguar extends Panthera{

   //private final String furType = "stripes";
    //private final boolean sleepsInTrees = false;

    Jaguar(){
        name = "";
        Species j = Species.JAGUAR;
        furType = j.getFur();
        sleepsInTrees = j.getSleepsInTrees();     
    }

    Jaguar(String name){
        this.name = name;
        this.species = Species.JAGUAR;
        this.longitude = super.longitude();
        this.latitude = super.latitude();
        this.weight = super.weight;
        this.speed = super.speed;
        furType = species.getFur();
        sleepsInTrees = species.getSleepsInTrees();
    }
}

