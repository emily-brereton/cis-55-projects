package emily;

public class Tiger extends Panthera{

    

    Tiger(){
        name = "";
        Species t = Species.TIGER; 
        furType = t.getFur();
        sleepsInTrees = t.getSleepsInTrees();  
    }

    Tiger(String name){
        this.name = name;
        this.species = Species.TIGER;
        this.longitude = super.longitude();
        this.latitude = super.latitude();
        this.weight = super.weight;
        this.speed = super.speed;
        furType = species.getFur();
        sleepsInTrees = species.getSleepsInTrees();
    }

}
