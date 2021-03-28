import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class Main {
  public static void main(String[] args)  {
    String data = "";
    try {
      File myObj = new File("uurtjes.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data += myReader.nextLine() + "\n";
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    WerkdagLijst lijst = new WerkdagLijst();

    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
    String[] dataArr =  data.split("\n");
    for (String st: dataArr) {
      String[] temp = st.split(" ");
      Werkdag wtemp = new Werkdag(LocalDate.parse(temp[0], formatDate), LocalTime.parse(temp[1], formatTime),
              LocalTime.parse(temp[2], formatTime), LocalTime.parse(temp[3], formatTime));
      lijst.voegToe(wtemp);
    }


   System.out.println(lijst);

  }
}