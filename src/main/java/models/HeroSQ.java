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

    public HeroSQ(String data){

        this.heroName = data;
        this.heroAge = heroAge;
        this.weakPoint = weakPoint;
        this.knownPower = knownPower;

    }

    public String getHeroName() {
        return heroName;
    }
}
