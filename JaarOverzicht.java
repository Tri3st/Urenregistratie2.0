import java.util.ArrayList;

public class JaarOverzicht extends Overzicht {
    private int jaarnummer;
    private double gewerktJaar;
    private double overurenJaar;
    private int dagen;
    private ArrayList<Werkdag> lijst;

    public JaarOverzicht(ArrayList<Werkdag> jaar, int jaarnummer) {
        this.jaarnummer = jaarnummer;
        this.lijst = kloonL(jaar);
        this.dagen = lijst.size();

        double sumG = 0.00;
        double sumO = 0.00;
        for (Werkdag w: lijst) {
            sumG += w.getGewerkt();
            sumO += w.getOveruren();
        }
        this.gewerktJaar = sumG;
        this.overurenJaar = sumO;
    }

    @Override
    public double getGewerkt() {
        return this.gewerktJaar;
    }

    @Override
    public double getOveruren() {
        return this.overurenJaar;
    }

    @Override
    public String toString() {
        return "Overzicht jaar " + this.jaarnummer + "\n" +
                "Gewerkt  : " + this.gewerktJaar + "\n" +
                "Overuren : " + this.overurenJaar;
    }
}