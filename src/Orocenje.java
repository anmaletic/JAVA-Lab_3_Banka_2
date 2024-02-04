public class Orocenje extends Racun {

    private double kamata;

    public Orocenje(String brojRacuna, Vlasnik vlasnik, double kamata) {
        super(brojRacuna, vlasnik);
        this.kamata = kamata;
    }


    public double getKamata() {
        return kamata;
    }

    public void setKamata(double kamata) {
        this.kamata = kamata;
    }

    @Override
    public boolean isplata(Iznos iznos) {
        System.out.println("Orocenje: isplata()");
        return false;
    }

    public double obracunKamata(){
        System.out.println("Orocenje: obracunKamata()");

        var staroStanje = trenutnoStanje;
        var iznos = 0.0;
        var razlika = 0.0;

        if (trenutnoStanje > 0 && kamata != 0) {
            iznos = trenutnoStanje * (1 * kamata/100);
            prometi.add(Promet.kreirajIznosPot(new Iznos(iznos, "HRK")));
        }

        return razlika;
    }
}
