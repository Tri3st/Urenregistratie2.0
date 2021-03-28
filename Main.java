import java.time.LocalTime;
import java.time.LocalDate;

class Main {
  public static void main(String[] args) {
    LocalDate vandaag = LocalDate.now();
    LocalTime t1 = LocalTime.of(5, 0);
    LocalTime t2 = LocalTime.of(4, 30);
    LocalTime t5 = LocalTime.of(15, 15);
    LocalTime t6 = LocalTime.of(17, 45);
    LocalTime p = LocalTime.of(0, 30);
    
    Werkdag w1 = new Werkdag(vandaag, t1, t6, p);
    Werkdag w2 = new Werkdag(vandaag.plusDays(1), t2, t5, p);
    WerkdagLijst lijst = new WerkdagLijst();
    lijst.voegToe(w1);
    lijst.voegToe(w2);
    WeekOverzicht week1 = new WeekOverzicht(lijst.geefWeek(12), 12);
    WeekOverzicht week2 = new WeekOverzicht(lijst.geefWeek(13), 13);

   System.out.println(lijst);
   System.out.println(week1);
   System.out.println(week2);
  }
}