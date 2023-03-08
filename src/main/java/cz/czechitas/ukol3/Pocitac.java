package cz.czechitas.ukol3;

import com.sun.source.tree.DoWhileLoopTree;

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
            overStavSystemuASpustSe();
        } else {
            System.err.println("Počítač již je zapnutý");

        }

    }


    private void overStavSystemuASpustSe() {

        if (disk != null && pamet != null && procesor != null) {
            jeZapnuty = true;
            System.out.println("Počítač se zapnul!");
        } else {
            System.err.println("Chybí komponenta");
            nahlasChybejiciKomponenty();
        }
    }

    private void nahlasChybejiciKomponenty() {
        if (disk == null) {
            System.err.println("Chybí disk!");
        }
        if (pamet == null) {
            System.err.println("Chybí paměť!");
        }
        if (procesor == null) {
            System.err.println("Chybí procesor!");
        }
    }


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


    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long aktualniZaplneniDisku = disk.getVyuziteMisto() + velikost;
            if (aktualniZaplneniDisku > disk.getKapacita()) {
                System.err.println("Nesdostatek místa na disku!!! Soubor nelze uložit!!");
            } else {
                disk.setVyuziteMisto(aktualniZaplneniDisku);
                System.out.println("Byl vytvořen soubor o velikosti " + velikost + " bajtů.");
                System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku + " bajtů.");
                System.out.println("Zbývá " + (disk.getKapacita() - aktualniZaplneniDisku) + " bajtů.");
            }
        }


    }

    public void vymazSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long aktualniZaplneniDisku = disk.getVyuziteMisto() - velikost;
            if (aktualniZaplneniDisku < 0) {
                System.err.println("Něco je špatně, kapacita disku nemůže být menší než nula!");
            } else {
                disk.setVyuziteMisto(aktualniZaplneniDisku);
                System.out.println("Byl smazán soubor o velikosti " + velikost + " bajtů.");
                System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku + " bajtů.");
                System.out.println("Zbývá " + (disk.getKapacita() - aktualniZaplneniDisku) + " bajtů.");
            }
        }
    }

    @Override
    public String toString() {
        return "Počítač:" + procesor + pamet + disk;
    }
}
