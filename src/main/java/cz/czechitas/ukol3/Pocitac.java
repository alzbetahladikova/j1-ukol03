package cz.czechitas.ukol3;

import java.util.Objects;

public class Pocitac {

    private Procesor procesor;

    private Pamet pamet;

    private Disk disk;
    private boolean jeZapnuty;


    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {

        if (!jeZapnuty) {
            if (disk != null && pamet != null && procesor != null) {
                jeZapnuty = true;
                System.out.println("Počítač se zapnul!");
            }
            else {System.err.println("Chybí komponenta");}

        } else {
            System.err.println("Počítač již je zapnutý");
            ;
        }

    }


/*
        if (disk=null) {
            System.err.println("Chybí disk!");
        }
        if (pamet=null) {
            System.err.println("Chybí paměť!");
        }
        if (procesor=null) {
            System.err.println("Chybí procesor!");
        }
        if (!(procesor!=null && !(pamet.isBlank()) && !(disk.isBlank())) {
            System.out.println("Počítač je zapnutý!");
        }}

 */



    public void vypniSe() {
        if (jeZapnuty()) {
            jeZapnuty = false;
            System.out.println("Počítač se vypnul!");
        }

    }


    public Procesor getProcesor() {
        return procesor;
    }

    public void setProcesor(Procesor procesor) {
        this.procesor = procesor;
    }

    public Pamet getPamet() {
        return pamet;
    }

    public void setPamet(Pamet pamet) {
        this.pamet = pamet;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }


    @Override
    public String toString() {
        return "Počítač:" + procesor + pamet + disk;
    }
}
