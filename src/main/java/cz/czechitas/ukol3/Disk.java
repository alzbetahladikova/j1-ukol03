package cz.czechitas.ukol3;

import static java.lang.String.format;

public class Disk {

    private String nazev;
    private long kapacita;
    private long vyuziteMisto;

    public Disk() {
    }

    public Disk(String nazev) {
        this.nazev = nazev;
    }

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return format("Disk: '%s', kapacita '%s' bajtů, využité místo '%s' bajtů; ", nazev, kapacita, vyuziteMisto);
    }

}
