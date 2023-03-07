package cz.czechitas.ukol3;

public class Procesor {
    private String vyrobce;
    private long rychlost;


    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    @Override
    public String toString() {
        return "Procesor: " + "výrobce " + vyrobce + ", " + "rychlost " + rychlost + " Hz" + "; ";
    }
}
