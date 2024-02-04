import java.text.MessageFormat;

public class Promet {
    final private double iznosPot;
    final private double iznosDug;
    final private String valuta;

    private Promet(double iznosPot, double iznosDug, String valuta) {
        this.iznosDug = iznosDug;
        this.iznosPot = iznosPot;
        this.valuta = valuta;
    }

    public double getIznosPot() {
        return iznosPot;
    }

    public double getIznosDug() {
        return iznosDug;
    }

    public String getValuta() {
        return valuta;
    }

    public static Promet kreirajIznosDug(Iznos iznos){
        return new Promet(0.0, iznos.getIznos(), iznos.getValuta());
    }

    public static Promet kreirajIznosPot(Iznos iznos){
        return new Promet(iznos.getIznos(), 0.0, iznos.getValuta());
    }

    @Override
    public String toString() {
        return MessageFormat.format("""
                Promet:
                Uplata: {0}
                Isplata: {1}
                Valuta: {2}
                """, getIznosPot(), getIznosDug(), getValuta());
    }
}
