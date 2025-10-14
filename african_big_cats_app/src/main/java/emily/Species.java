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

    protected String getFur(){
        return this.furType;
    }

    protected boolean getSleepsInTrees(){
        return this.sleepsInTrees;
    }   
}