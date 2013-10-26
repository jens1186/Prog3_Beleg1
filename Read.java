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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
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
    
    Hashtable <String, Integer> map = new Hashtable<> (); // word | anzahl
        
    for(String wort : this.inhalt){
          if(!map.containsKey(wort))
              {
                map.put(wort, 1);
              }
          else
              {
                map.put(wort,map.get(wort)+1);
              }
              //System.out.println(wordMap);
      }
    Enumeration e = map.keys();
         while (e.hasMoreElements()) {
      //      sKey = iterator.next();
             
        String alias = (String)e.nextElement();
        System.out.printf("%-40s", alias) ;
        System.out.printf("%10s", map.get(alias));
        System.out.println("");
    }
    }
    
  


  
}