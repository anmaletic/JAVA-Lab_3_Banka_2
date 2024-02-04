import java.util.LinkedList;

public class Racun {

    final private String brojRacuna;
    final private Vlasnik vlasnik;
    final private double pocetnoStanje;
    protected double trenutnoStanje;
    LinkedList<Promet> prometi = new LinkedList<>();

    public Racun(String brojRacuna, Vlasnik vlasnik) {
        this.brojRacuna = brojRacuna;
        this.vlasnik = vlasnik;
        this.pocetnoStanje = 0.0;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public double getPocetnoStanje() {
        return pocetnoStanje;
    }

    public double getTrenutnoStanje() {
        trenutnoStanje = pocetnoStanje;

        for (Promet p : prometi) {
            double tempDug = p.getIznosDug();
            double tempPot = p.getIznosPot();

            double iznos = tempDug == 0.0 ? tempPot : -1 * tempDug;

            trenutnoStanje += iznos;
        }

        return trenutnoStanje;
    }

    public boolean uplata(Iznos iznos) {
        System.out.println("Racun: uplata()");
        prometi.add(Promet.kreirajIznosPot(iznos));
        return true;
    }

    public boolean isplata(Iznos iznos) {
        System.out.println("Racun: isplata()");
        if (trenutnoStanje >= iznos.getIznos()) {
            prometi.add(Promet.kreirajIznosDug(iznos));
            return true;
        }
        return false;
    }

    public double obracunKamata(){
        return 0;
    };

    @Override
    public String toString() {
        return String.format(" Racun:  Broj: %s    Vlasnik: %-15s Trenutno stanje: %10.2f",
                brojRacuna, vlasnik.getImePrezime(), getTrenutnoStanje());
    }
}
