/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beleg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


/**
 *
 * @author Jens
 */
public final class Read {
  
  private String datei;
  private String inhalt_roh="";
  private ArrayList<String> inhalt;
  private SortedMap <String, Integer> wortanzahl_map; 

  
  Read(String datei){
    
    this.datei = datei;
    this.lesen(datei);
    
  }
  
  public void lesen(String file){
    
    this.inhalt = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String zeile ;
      br.read();
      while ((zeile = br.readLine()) != null) {
          builder.append(zeile);
          builder.append("\n");
      }
      this.inhalt_roh = builder.toString();
      
      StringTokenizer inhalt4inhalt = new StringTokenizer(this.inhalt_roh,
              "§$«»<>.,_+!?;:\"\n ()[]");
      while (inhalt4inhalt.hasMoreElements()){
              String tempWort = inhalt4inhalt.nextElement().toString() ;
              if(tempWort.length()>1 && tempWort.matches("[a-zA-ZäÄüÜöÖß]*"))
              {
              this.inhalt.add(tempWort);
              }
          }
    }
    catch (IOException e) {
      System.out.println("Die angegebene Datei konnte nicht gefunden werden.\n"
              + "Bitte ueberpruefen Sie ihre Eingabe");
    }
    
  }
  
   public void ausgeben(){
       System.out.print(this.inhalt_roh);
   }
  
  public void sortieren(boolean alphabetisch){
    if(alphabetisch == true)
    {
    /* Liste alphabetisch aufsteigend sortieren (a...z) */
    Collections.sort(this.inhalt);
    }
    else if(alphabetisch == false) {
    // create comparator for reverse order
    Comparator cmp = Collections.reverseOrder();  
    
    /* Liste alphabetisch aufsteigend sortieren (z...a) */
    Collections.sort(this.inhalt, cmp);
    }
    /* Ausgabe: Frank Hans Peter */
    for(String wort : this.inhalt){
      System.out.println(wort);
    }
  }
  
  private void zaehleWortanzahl(){
      for(String wort : this.inhalt){
          if(!wortanzahl_map.containsKey(wort))
              {
                wortanzahl_map.put(wort, 1);
              }
          else
              {
                wortanzahl_map.put(wort,wortanzahl_map.get(wort)+1);
              }
      }
  }
      
  
  private void druckeWort(int min, int max){
      for(String wort : wortanzahl_map.keySet()){
      if(wortanzahl_map.get(wort)> min && wortanzahl_map.get(wort)< max)
      {
        System.out.printf("%-40s", wort) ;
        System.out.printf("%10s", wortanzahl_map.get(wort));
        System.out.println("");
      }
    }
  }
  
  public void AusgabeA_Z(int min , int max){
      
      this.wortanzahl_map = new TreeMap();
      zaehleWortanzahl();
      druckeWort(min, max);
  }
  
  public void AusgabeZ_A(int min , int max){
    
        this.wortanzahl_map = new TreeMap(Collections.reverseOrder());
        zaehleWortanzahl();
        druckeWort(min, max);      
    }
    
  


  
}