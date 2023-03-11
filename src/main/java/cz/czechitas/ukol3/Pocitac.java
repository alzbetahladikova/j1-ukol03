package cz.czechitas.ukol3;

public class Pocitac {
    //vycházím z předpokladu, že disk 2 může, ale nemusí být v PC obsažen

    private Procesor procesor;
    private Pamet pamet;
    private Disk disk, disk2;
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

    public Disk getDisk2() {
        return disk2;
    }

    public void setDisk2(Disk disk2) {
        this.disk2 = disk2;
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long aktualniZaplneniDisku = disk.getVyuziteMisto() + velikost;
            if (aktualniZaplneniDisku > disk.getKapacita()) {
                overMistoNaDisku2ASplnUlohu(velikost);
            } else {
                disk.setVyuziteMisto(aktualniZaplneniDisku);
                System.out.println("Byl vytvořen soubor o velikosti " + velikost + " bajtů.");
                System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku + " bajtů.");
                System.out.println("Zbývá " + (disk.getKapacita() - aktualniZaplneniDisku) + " bajtů.");
            }
        }
    }

    private void overMistoNaDisku2ASplnUlohu(long velikost) {
        long aktualniZaplneniDisku2 = disk2.getVyuziteMisto() + velikost;
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
            if (disk2.getVyuziteMisto() > velikost) {
                disk2.setVyuziteMisto(aktualniZaplneniDisku2);
                System.out.println("Byl smazán soubor o velikosti " + velikost + " bajtů.");
                System.out.println("Využité místo na disku je nyní " + aktualniZaplneniDisku2 + " bajtů.");
                System.out.println("Zbývá " + (disk2.getKapacita() - aktualniZaplneniDisku2) + " bajtů.");
            } else {
                vymazSouborZDiskuVypisHlaseni(velikost, aktualniZaplneniDisku);
            }
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
        String ln = System.lineSeparator() + " ❤ ";
        return "Počítač:" + ln + procesor + ln + pamet + ln + disk + ln + disk2;
    }
}
