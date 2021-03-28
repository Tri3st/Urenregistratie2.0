import java.util.ArrayList;
public abstract class Overzicht {
  
  public abstract double getGewerkt();
  public abstract double getOveruren();
  
  protected ArrayList<Werkdag> kloonL(ArrayList<Werkdag> lijstje){
    ArrayList<Werkdag> newlist = new ArrayList<>();
    for(Werkdag w: lijstje) newlist.add(w.kloonW());
    return newlist;
  }
}