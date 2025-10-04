package emily;

abstract class Panthera extends PantheraGPS{

    int weight;
    float speed;

// constructor
public Panthera(){
    super();
};

public void roar(){
    System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
}

public float speed(){
    return speed;
}

public int getWeight() {
    return weight;
}
public void setWeight(int weight) {
    this.weight = weight;
}
public float getSpeed() {   
    return speed;
}
public void setSpeed(float speed) {
    this.speed = speed; 
}
}