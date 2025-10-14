package emily;

import java.util.Random;

abstract class Panthera extends PantheraGPS{

// constructor
public Panthera(){
    super();
    this.weight = initializeWeight();
    this.speed = startingSpeed();
}

public void roar(){
    System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
}

private int initializeWeight(){
    Random rand = new Random();
    int weight = rand.nextInt(10, 601);
    setWeight(weight);
    return weight;
}

private float startingSpeed(){
    Random rand = new Random();
    float speed = minSpeed + rand.nextFloat() * (maxSpeed - minSpeed);
    setSpeed(speed);
    return speed;
}
}