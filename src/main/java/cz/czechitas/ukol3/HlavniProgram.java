package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        System.out.println("Program spuštěn.");

        Disk disk = new Disk();
        disk.setKapacita(1073741824);
        disk.setVyuziteMisto(0);

        Disk2 disk2 =new Disk2();  //vycházím z předpokladu, že disk může, ale nemusí být v PC obsažen
        disk2.setKapacita(1073741824);
        disk2.setVyuziteMisto(0);

        Pamet pamet = new Pamet();
        pamet.setKapacita(16);

        Procesor procesor = new Procesor();
        procesor.setRychlost(300000000);
        procesor.setVyrobce("AMD");


        Pocitac bety = new Pocitac();
        bety.setDisk(disk);
        bety.setProcesor(procesor);
        bety.setPamet(pamet);
        bety.zapniSe();
        System.out.println(bety);
        bety.vytvorSouborOVelikosti(20);
        bety.vymazSouborOVelikosti(15);
        bety.vypniSe();


    }

}
