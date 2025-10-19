package emily;

import java.util.Random;

/*
 * Panthera base class that simulates GPS information
 */
public class PantheraGPS {

    // constants
    private final Integer maxLongitude = 1000;
    private final Integer maxLatitude = 1000;
    protected final float minSpeed = 0f;
    protected final float maxSpeed = 50.0f;

    // attributes
    protected String name;
    protected Species species;

    protected Float longitude;
    protected Float latitude;
    protected Float speed;

    protected int weight;
    protected String furType;
    protected boolean sleepsInTrees;

    private Random longitudeRandom;
    private Random latitudeRandom;

    // constructor
    public PantheraGPS() {
        name = "";
    }

    // serializes attributes into a string
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + Menu.formatName(name);
        s += ", ";
        s += "species: " + this.species;
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "current speed: " + this.getSpeed();
        s += ", ";
        s += "weight: " + this.getWeight();
        s += ", ";
        s += "fur type: " + this.species.getFur();
        s += ", ";
        s += "sleeps in trees: " + this.species.getSleepsInTrees();
        s += " }";
        return s;
    }

    // getters and setters
    public String name() {
        return this.name;
    }

    public Species species() {
        return this.species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // make a seed, based on the name
    private Integer seed(String s) {
        Integer seed = 0;

        for (Integer i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }

        return seed;
    }

    protected void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }

    // longitude of the panthera
    protected Float longitude() {
        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        return longitude;
    }

    // latitude of the panthera
    protected Float latitude() {
        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
        return latitude;
    }
}