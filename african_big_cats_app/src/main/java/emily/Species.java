package emily;

public enum Species {
    TIGER ("stripes", false),
    LION ("mane", false),
    JAGUAR ("spots", true);

    private final String furType;
    private final boolean sleepsInTrees;

    Species (String furType, boolean sleepsInTrees){
        this.furType = furType;
        this.sleepsInTrees = sleepsInTrees;
    }

    public String getFurType(){
        return this.furType;
    }

    public boolean getSleepsInTrees(){
        return this.sleepsInTrees;
    }   
}