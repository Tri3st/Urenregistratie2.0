import java.util.ArrayList;
import java.time.LocalDate;
public class WerkdagLijst {
  private ArrayList<Werkdag> werkdagen;
  
  public WerkdagLijst(){
    werkdagen = new ArrayList<>();
  }
  
  public void voegToe(Werkdag wd){
    if (wd != null){
      werkdagen.add(wd);
    }
  }
  
  public Werkdag haalOp(int index){
    if (werkdagen.get(index)== null)return null;
    else return werkdagen.get(index);
  }
  
  public Werkdag zoekDatum(LocalDate datum){
    Werkdag wd = null;
    for (Werkdag w: werkdagen){
      if (w.getDatum().equals(datum)) wd = w;
    }
    return wd;
  }
  
  public ArrayList<Werkdag> geefWeek(int weeknummer){
    ArrayList<Werkdag> wl = new ArrayList<>();
    for(Werkdag w: werkdagen){
      if(w.getWeeknr() == weeknummer) wl.add(w);
    }
    return wl;
  }
  
  public ArrayList<Werkdag> geefLijst(Soort soort){
    
    return null;
  }
  
  public ArrayList<Werkdag> geefMaand(int maand){
    
    return null;
  }
  
  public ArrayList<Werkdag> geefJaar(int jaar){
    
    return null;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(Werkdag w: werkdagen){
      sb.append(w + "\n");
    }
    return sb.toString();
  }
  
  
}