public class TekuciRacun extends Racun {

    private double dozvoljeniMinus;
    private double zateznaKamata;
    private double kamata;

    public TekuciRacun(String brojRacuna, Vlasnik vlasnik, double dozvoljeniMinus, double zateznaKamata, double kamata) {
        super(brojRacuna, vlasnik);
        this.dozvoljeniMinus = dozvoljeniMinus;
        this.zateznaKamata = zateznaKamata;
        this.kamata = kamata;
    }

    public double getDozvoljeniMinus() {
        return dozvoljeniMinus;
    }

    public void setDozvoljeniMinus(double dozvoljeniMinus) {
        this.dozvoljeniMinus = dozvoljeniMinus;
    }

    public double getZateznaKamata() {
        return zateznaKamata;
    }

    public void setZateznaKamata(double zateznaKamata) {
        this.zateznaKamata = zateznaKamata;
    }

    public double getKamata() {
        return kamata;
    }

    public void setKamata(double kamata) {
        this.kamata = kamata;
    }

    @Override
    public boolean isplata(Iznos iznos) {
        System.out.println("TekuciRacun: isplata()");
        if (trenutnoStanje  + dozvoljeniMinus >= iznos.getIznos()) {
            prometi.add(Promet.kreirajIznosDug(iznos));
            return true;
        }
        return false;
    }

    public double obracunKamata(){
        System.out.println("TekuciRacun: obracunKamata()");

        var staroStanje = trenutnoStanje;
        var iznos = 0.0;
        var razlika = 0.0;

        if (trenutnoStanje > 0 && kamata != 0) {
            iznos = trenutnoStanje * (1 * kamata/100);
            prometi.add(Promet.kreirajIznosPot(new Iznos(iznos, "HRK")));
        }
        else if (trenutnoStanje < 0 && zateznaKamata != 0) {
            iznos = -1 * trenutnoStanje * (1 * kamata/100);
            prometi.add(Promet.kreirajIznosDug(new Iznos(iznos, "HRK")));
        }
        return razlika;
    }
}
