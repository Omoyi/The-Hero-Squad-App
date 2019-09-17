package models;

import java.util.ArrayList;
import java.util.List;

public class SquadHR {
    private String sqName;
    private String cause;
    private int maxSize;
    private int id;
    private static ArrayList<SquadHR> instances = new ArrayList<>();
    private List<HeroSQ> heroesClass;

    public SquadHR(String sqName, String cause, int maxSize){
        this.sqName=sqName;
        this.cause=cause;
        this.maxSize=maxSize;
        instances.add(this);
        this.id = instances.size();
    }

    public String getSqName() {
        return sqName;
    }

    public String getCause() {
        return cause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getId() { return id; }

    public static ArrayList<SquadHR>getAll() { return instances; }

    public static void clear() { instances.clear(); }

    public void addHero(HeroSQ hero){ heroesClass.add(hero); }

    public List<HeroSQ> getHeroesClass() { return heroesClass; }

    public void update(String name,String cause,int size) {
        this.sqName =name;
        this.maxSize= maxSize;

    }

    public static SquadHR find(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void deleteSquad() {
        instances.remove(id - 1);

    }

}
