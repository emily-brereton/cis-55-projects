package emily;

import java.util.Random;

abstract class Panthera extends PantheraGPS{

    int weight;
    float speed;

// constructor
public Panthera(){
    super();
    this.weight = initializeWeight();
    this.speed = startingSpeed();
}

public void roar(){
    System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
}

public int initializeWeight(){
    Random rand = new Random();
    int weight = rand.nextInt(10, 601);
    setWeight(weight);
    return weight;
}

public float startingSpeed(){
    Random rand = new Random();
    float speed = minSpeed + rand.nextFloat() * (maxSpeed - minSpeed);
    setSpeed(speed);
    return speed;
}
}