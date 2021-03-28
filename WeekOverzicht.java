import java.util.ArrayList;

public class WeekOverzicht extends Overzicht {
  private int weeknummer;
  private double gewerktWeek;
  private double overurenWeek;
  private int dagen;
  private ArrayList<Werkdag> lijst;
  
  public WeekOverzicht(ArrayList<Werkdag> week, int weeknummer){
    this.weeknummer = weeknummer;
    this.lijst = super.kloonL(week);
    this.dagen = lijst.size();
    
    double sumG = 0.00;
    double sumO = 0.00;
    for (Werkdag w: lijst) {
      sumG += w.getGewerkt();
      sumO += w.getOveruren();
    }
    this.gewerktWeek = sumG;
    this.overurenWeek = sumO;
    
  }
  
  public double getGewerkt(){
    return this.gewerktWeek;
  }
  
  public double getOveruren(){
    return this.overurenWeek;
  }
  
  public String toString(){
    return "Overzicht week " + this.weeknummer + "\n" + 
    "Gewerkt  : " + this.gewerktWeek + "\n" +
    "Overuren : " + this.overurenWeek;
  }
}