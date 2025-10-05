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

    String name;
    Species species;

    Float longitude;
    Float latitude;

    private Random longitudeRandom;
    private Random latitudeRandom;

    // constructor
    public PantheraGPS() {

        // initialize attributes

        // seed the random number generators for repeatable results
        //this.longitudeRandom = new Random();
        //this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        //this.latitudeRandom = new Random();
        //this.latitudeRandom.setSeed(this.seed(name + "latitude"));

        // move the panthera into it's initial position
        //this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        //this.latitude = latitudeRandom.nextFloat() * maxLatitude;

    }

    // serializes attributes into a string
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "species: " + this.species;
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += " }";

        return s;

    }

    // getters
    public String name() {
        return this.name;
    }

    public Species species() {
        return this.species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    // make a seed, based on the name
    private Integer seed(String s) {
        Integer seed = 0;

        for (Integer i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }

        return seed;
    }

    public void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }

    // longitude of the panthera
    public Float longitude() {
        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        return longitude;
    }

    // latitude of the panthera
    public Float latitude() {
        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
        return latitude;
    }
}