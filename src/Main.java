
public class Main {

    public static void main(String[] args) {
        Vlasnik fizicki = new Vlasnik("11111111111", "Ivo", "Ivic");
        PravnaOsoba pravni = new PravnaOsoba("22222222222", "Ana", "Anic");

        Racun r1 = new TekuciRacun("1", fizicki, 100, 14, 4);
        Racun r2 = new Orocenje("2", pravni, 5);

        System.out.println(r1);
        System.out.println(r2);

        r1.uplata(new Iznos(100, "HRK"));
        r2.uplata(new Iznos(200, "HRK"));

        System.out.println(r1);
        System.out.println(r2);

        r1.obracunKamata();
        r2.obracunKamata();

        System.out.println(r1);
        System.out.println(r2);

        r1.isplata(new Iznos(200, "HRK"));
        r2.isplata(new Iznos(10, "HRK"));

        System.out.println(r1);
        System.out.println(r2);

        r1.obracunKamata();
        r2.obracunKamata();

        System.out.println(r1);
        System.out.println(r2);
    }
}