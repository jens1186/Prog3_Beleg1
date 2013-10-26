/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beleg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class Read {
  
  public final String datei;
  Read(String datei){
    
    this.datei = datei;
    
  }
  
  public void lesen(String file){
    
    final ArrayList<String> words = new ArrayList<String>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String zeile;
      while ((zeile = br.readLine()) != null) {
          for (String s : zeile.split(" ")) {
              words.add(s);
          }
          System.out.println(zeile);
      }
    }
    catch (IOException e) {
      System.out.println("Die angegebene Datei konnte nicht gefunden werden.\n"
              + "Bitte ueberpruefen Sie ihre Eingabe");
    }
    
  }
  
  public void sortieren(){
    
    final ArrayList<String> words = new ArrayList<String>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("kant.txt"));
      String zeile;
      while ((zeile = br.readLine()) != null) {
          for (String s : zeile.split(" ")) {
              words.add(s.replaceAll("[_[^\\w\\däüöÄÜÖ\\+\\- ]]", ""));
          }
         
          //System.out.println(zeile);
      }
    }
    catch (IOException e) {
      System.out.println("Die angegebene Datei konnte nicht gefunden werden.\n"
              + "Bitte ueberpruefen Sie ihre Eingabe");
    }
    
    /* Liste alphabetisch aufsteigend sortieren (a...z) */
    Collections.sort(words);
    
    /* Ausgabe: Frank Hans Peter */
    for(String name : words){
      System.out.println(name);
    }
  }
  
  public void zaehlenAsc(){
    
    final ArrayList<String> words = new ArrayList<String>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("kant.txt"));
      String zeile;
      while ((zeile = br.readLine()) != null) {
        
        HashMap <ArrayList, Integer> map = new HashMap<ArrayList, Integer> (); // word | anzahl
        
        for (String s : zeile.split(" ")) {
              words.add(s.replaceAll("[_[^\\w\\däüöÄÜÖ\\+\\- ]]", ""));
              
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