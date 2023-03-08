package cz.czechitas.ukol3;

import com.sun.source.tree.DoWhileLoopTree;

public class Pocitac {
    //vycházím z předpokladu, že disk může, ale nemusí být v PC obsažen

    private Procesor procesor;

    private Pamet pamet;

    private Disk disk;
    private Disk2 disk2;
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

    public Disk2 getDisk2() {
        return disk2;
    }

    public void setDisk2(Disk2 disk2) {
        this.disk2 = disk2;
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long aktualniZaplneniDisku = disk.getVyuziteMisto() + velikost;
            long aktualniZaplneniDisku2 = disk2.getVyuziteMisto() + velikost;
            overKapacituASplnUlohu(velikost, aktualniZaplneniDisku, aktualniZaplneniDisku2)
            ;
        }


    }

    private void overKapacituASplnUlohu(long velikost, long aktualniZaplneniDisku, long aktualniZaplneniDisku2) {
        if (aktualniZaplneniDisku > disk.getKapacita()) {
            overMistoNaDisku2Asplnulohu(velikost, aktualniZaplneniDisku2);
        } else {
            disk.setVyuziteMisto(aktualniZaplneniDisku);
            System.out.println("Byl vytvořen soubor o velikosti " + velikost + " bajtů.");
            System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku + " bajtů.");
            System.out.println("Zbývá " + (disk.getKapacita() - aktualniZaplneniDisku) + " bajtů.");
        }
    }

    private void overMistoNaDisku2Asplnulohu(long velikost, long aktualniZaplneniDisku2) {
        if (aktualniZaplneniDisku2 > disk2.getKapacita()) {
            System.err.println("Nesdostatek místa na disku!!! Soubor nelze uložit!!");
        } else {
            disk2.setVyuziteMisto(aktualniZaplneniDisku2);
            System.out.println("Byl vytvořen soubor o velikosti " + velikost + " bajtů.");
            System.out.println("Využité místo na disku2 je nyní " + aktualniZaplneniDisku2 + " bajtů.");
            System.out.println("Zbývá " + (disk2.getKapacita() - aktualniZaplneniDisku2) + " bajtů.");
        }
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long aktualniZaplneniDisku = disk.getVyuziteMisto() - velikost;
            long aktualniZaplneniDisku2 = disk2.getVyuziteMisto() - velikost;
            overVelikostSouboruASmaz(velikost, aktualniZaplneniDisku, aktualniZaplneniDisku2);
        }
    }

    private void overVelikostSouboruASmaz(long velikost, long aktualniZaplneniDisku, long aktualniZaplneniDisku2) {
        if (disk2.getVyuziteMisto() > velikost) {
            disk2.setVyuziteMisto(aktualniZaplneniDisku2);
            System.out.println("Byl smazán soubor o velikosti " + velikost + " bajtů.");
            System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku2 + " bajtů.");
            System.out.println("Zbývá " + (disk2.getKapacita() - aktualniZaplneniDisku2) + " bajtů.");
        } else {
            vymazSouborZDiskuVypisHlaseni(velikost, aktualniZaplneniDisku);
        }
    }

    private void vymazSouborZDiskuVypisHlaseni(long velikost, long aktualniZaplneniDisku) {
        if (aktualniZaplneniDisku < 0) {
            System.err.println("Něco je špatně, kapacita disku nemůže být menší než nula!");
        } else {
            disk.setVyuziteMisto(aktualniZaplneniDisku);
            System.out.println("Byl smazán soubor o velikosti " + velikost + " bajtů.");
            System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku + " bajtů.");
            System.out.println("Zbývá " + (disk.getKapacita() - aktualniZaplneniDisku) + " bajtů.");
        }
    }

    @Override
    public String toString() {
        return "Počítač:" + procesor + pamet + disk+disk2;
    }
}
