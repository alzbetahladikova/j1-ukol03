package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        System.out.println("Program spuštěn.");

        Disk disk = new Disk("Disk 1");
        disk.setKapacita(1073741824);
        disk.setVyuziteMisto(250000);

        Disk disk2 = new Disk("Disk 2");
        disk2.setKapacita(1073741824);
        disk2.setVyuziteMisto(100000);

        Pamet pamet = new Pamet();
        pamet.setKapacita(16);

        Procesor procesor = new Procesor();
        procesor.setRychlost(300000000);
        procesor.setVyrobce("AMD");

        Pocitac bety = postavPocitac(procesor, pamet, disk, disk2);
        bety.zapniSe();
        System.out.println(bety);
        bety.vytvorSouborOVelikosti(20000);
        bety.vymazSouborOVelikosti(20000);
        bety.vypniSe();
    }

    private static Pocitac postavPocitac(Procesor procesor, Pamet pamet, Disk disk, Disk disk2) {
        Pocitac bety = new Pocitac();
        bety.setDisk(disk);
        bety.setDisk2(disk2);
        bety.setProcesor(procesor);
        bety.setPamet(pamet);
        return bety;
    }

}
