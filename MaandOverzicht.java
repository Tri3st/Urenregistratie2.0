import java.util.ArrayList;

public class MaandOverzicht extends Overzicht {
    private int maandnr;
    private double gewerktMaand;
    private double overurenMaand;
    private int dagen;
    private ArrayList<Werkdag> lijst;

    public MaandOverzicht(ArrayList<Werkdag> maand, int maandnr) {
        this.maandnr = maandnr;
        this.dagen = maand.size();
        this.lijst = super.kloonL(maand);
        double sumG = 0.00;
        double sumO = 0.00;
        for (Werkdag w: lijst) {
            sumG += w.getGewerkt();
            sumO += w.getOveruren();
        }
        this.gewerktMaand = sumG;
        this.overurenMaand = sumO;
    }

    @Override
    public double getGewerkt() {
        return this.gewerktMaand;
    }

    @Override
    public double getOveruren() {
        return this.overurenMaand;
    }

    public String toString(){
        return "Overzicht maand " + this.maandnr + "\n" +
                "Gewerkt  : " + this.gewerktMaand + "\n" +
                "Overuren : " + this.overurenMaand;
    }
}