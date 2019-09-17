package models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HeroSQ {
    private String heroName;
    private int heroAge;
    private  String weakPoint;
    private String knownPower;
    private static List<HeroSQ> instances = new ArrayList<>();
    private boolean publish;
    private LocalDateTime createdAt;
    private int Id;

    public HeroSQ(String heroName, int heroAge, String weakPoint, String knownPower){

        this.heroName = heroName;
        this.heroAge = heroAge;
        this.weakPoint = weakPoint;
        this.knownPower = knownPower;
        this.publish = false;
        this.createdAt= LocalDateTime.now();
        instances.add(this);
        this.Id= instances.size();
    }
    public static ArrayList<HeroSQ> getAll() {
        return (ArrayList<HeroSQ>) instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }

    public boolean getPublish()
    {
        return this.publish;
    }

    public LocalDateTime getCreatedAt() {
      return createdAt;
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

    public void update(String name,int age,String specialPower,String weakness) {
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.weakPoint = weakPoint;
        this.knownPower = knownPower;
    }

    public void deleteHero(){
        instances.remove(Id-1);
    }

}
