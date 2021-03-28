import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.temporal.*;

public class Werkdag {
  private LocalDate datum;
  private int weeknr;
  private LocalTime beginTijd;
  private LocalTime eindTijd;
  private LocalTime pauze;
  private double gewerkt;
  private Soort soort;
  private String opmerking = "";
  private Locale locale = new Locale("nl","NL");
  private DateTimeFormatter datumF = DateTimeFormatter.ofPattern("dd-MM-yy");
  private DateTimeFormatter tijdF = DateTimeFormatter.ofPattern("HH:mm");
  
  public Werkdag(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, LocalTime pauze, Soort soort){
    this.datum = datum;
    this.weeknr = datum.get(WeekFields.of(locale).weekOfYear());
    this.beginTijd = beginTijd;
    this.eindTijd = eindTijd;
    this.pauze = pauze;
    this.soort = soort;
    this.gewerkt = calcGewerkt();
  }
  
  public Werkdag(LocalDate datum, LocalTime beginTijd, LocalTime eindTijd, LocalTime pauze){
    this(datum, beginTijd, eindTijd, pauze, Soort.WERK);
  }
  
  public LocalDate getDatum(){
    return this.datum;
  }
  
  public int getWeeknr(){
    return this.weeknr;
  }
  
  public LocalTime getBeginTijd(){
    return this.beginTijd;
  }
  
  public LocalTime getEindTijd(){
    return this.eindTijd;
  }
  
  public LocalTime pauze(){
    return this.pauze;
  }
  
  public double getGewerkt(){
    return this.gewerkt;
  }
  
  public Soort getSoort(){
    return this.soort;
  }
  
  public String getOpmerking(){
    return this.opmerking;
  }
  
  public void setSoort(Soort soort){
    this.soort = soort;
  }
  
  public void setOpmerking(String opmerking){
    this.opmerking = opmerking;
  }
  
  public Werkdag kloonW(){
    Werkdag wd = new Werkdag(
      this.datum, this.beginTijd, 
      this.eindTijd, this.pauze, this.soort
      );
      return wd;
  }
  
  private double calcGewerkt(){
    double hours = 0.00;
    double minutes = 0.00;
    hours = (double)(eindTijd.getHour() - beginTijd.getHour() - pauze.getHour());
    minutes = (eindTijd.getMinute()/60.00) - (beginTijd.getMinute()/60.00) - (pauze.getMinute()/60.00);
    return hours + minutes;
  }
  
  public double getOveruren(){
    return this.gewerkt - 8.00;
  }
  
  public String toString(){
    String st = "";
    String beginStr = beginTijd.format(tijdF);
    String eindStr = eindTijd.format(tijdF);
    String pauzeStr = pauze.format(tijdF);
    String datumStr = datum.format(datumF);
    st += String.format("%8s %2d %5s %5s %5s %-8s %s", datumStr, this.weeknr, beginStr, eindStr, pauzeStr, this.soort.toString(), this.opmerking);
    return st;
  }
  
  
}