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
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 *
 * @author Jens
 */
public final class Read {
  
  private String datei;
  private String inhalt_roh="";
  private ArrayList<String> inhalt;
  
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
              this.inhalt.add(inhalt4inhalt.nextElement().toString());
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
      System.out.println(alphabetisch);
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
  
  public void zaehlenAsc(){
    
    final ArrayList<String> words = new ArrayList<>();
    HashMap <ArrayList, Integer> map = new HashMap<> (); // word | anzahl
        
    for(String wort : this.inhalt){
          if(!map.containsKey(words))
              {
                map.put(words, 1);
              }
              else
              {
                map.put(words,map.get(words)+1);
              }
              //System.out.println(wordMap);
      }
         Iterator<ArrayList> iterator = map.keySet().iterator();
         ArrayList<String> sKey = new ArrayList<String>();
         while (iterator.hasNext()) {
            sKey = iterator.next();
            System.out.println(sKey + " - " + map.get(sKey));
          
    }
    }
    
    catch (IOException e) {
      System.out.println("Die angegebene Datei konnte nicht gefunden werden.\n"
              + "Bitte ueberpruefen Sie ihre Eingabe");
    }
    
    /* Liste alphabetisch aufsteigend sortieren (a...z) */
    //Collections.sort(words);
    
    /* Ausgabe: Frank Hans Peter */
    //for(String name : words){
      //System.out.println(name);
      
    //}
  }
 


  
}