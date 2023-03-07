package cz.czechitas.ukol3;

import java.util.Objects;

public class Pocitac {

    private Procesor procesor;

    private Pamet pamet;

    private Disk disk;
    private boolean jeZpanuty;

    /*
        public boolean isJeZpanuty() {
            return jeZpanuty;
        }
    */
    public void zapniSe() {
        System.out.println("Počítač je zapnutý!");
    }
   /* public void chyboveHlaseni(String disk, String pamet, String procesor) {
        Objects.requireNonNull(disk);
        Objects.requireNonNull(procesor);
        Objects.requireNonNull(pamet);

        if (disk.isBlank()) {
            System.err.println("Chybí disk!");
        }
        if (pamet.isBlank()) {
            System.err.println("Chybí paměť!");
        }
        if (procesor.isBlank()) {
            System.err.println("Chybí procesor!");
        }
       if (!(procesor.isBlank()) && !(pamet.isBlank()) && !(disk.isBlank())) {
            System.out.println("Počítač je zapnutý!");
        }

       */




    public void vypniSe() {
        System.out.println("Počítač je vypnutý");
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

   /* public void setJeZpanuty(boolean jeZpanuty) {
        this.jeZpanuty = jeZpanuty;
    }

    */

    @Override
    public String toString() {
        return "Počítač:"
                + procesor +
                pamet +
                disk

                ;
    }
}
