package models;
import java.util.ArrayList;
import java.util.List;

public class HeroSQ {
    private String heroName;
    private int heroAge;
    private  String weakPoint;
    private String knownPower;
    private static List<HeroSQ> instances = new ArrayList<HeroSQ>();
    private int Id;

    public HeroSQ(String data, int heroAge, String weakPoint, String knownPower){

        this.heroName = data;
        this.heroAge = heroAge;
        this.weakPoint = weakPoint;
        this.knownPower = knownPower;
        instances.add(this);
        Id = instances.size();
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public String weakPoint() {
        return weakPoint();
    }

    public String getKnownPower() {
        return knownPower;
    }

    public static List<HeroSQ> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return Id;
    }

    public static HeroSQ find(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static boolean seeHeroThroughName(String heroName)
    {
        boolean Present = false;
        for (int i =0; i<instances.size(); i++)
        {
            if (heroName.equalsIgnoreCase(instances.get(i).heroName) )
            {
                Present = true;
            }
        }

        return Present;
    }

}
