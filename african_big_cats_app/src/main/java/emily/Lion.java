package emily;

public class Lion extends Panthera{

    Lion(){
        name = "";
        Species l = Species.LION;
        furType = l.getFur();
        sleepsInTrees = l.getSleepsInTrees();  
    }  

    Lion(String name){
        this.name = name;
        this.species = Species.LION;
        this.longitude = super.longitude();
        this.latitude = super.latitude();
        this.weight = super.weight;
        this.speed = super.speed;
        furType = species.getFur();
        sleepsInTrees = species.getSleepsInTrees();
    }
}
