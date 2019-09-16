package models;

import java.util.ArrayList;

public class SquadHR {
    private String sqName;
    private String cause;
    private int maxSize;
    private static ArrayList<SquadHR> instances = new ArrayList<>();
    public SquadHR(String sqName, String cause, int maxSize){
        this.sqName=sqName;
        this.cause=cause;
        this.maxSize=maxSize;
        instances.add(this);
    }

    public String getSqName() {
        return sqName;yyyyyyyyyyyyyyy
    }

    public String getCause() {
        return cause;
    }

    public int getMaxSize() {
        return maxSize;
    }
    public static ArrayList<SquadHR>getAll() {
        return instances;
    }
}
