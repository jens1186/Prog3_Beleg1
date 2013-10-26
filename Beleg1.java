/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beleg1;

import java.util.*;

/**
 *
 * @author Jens
 */
public class Beleg1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      if(args.length != 2)
      {
        System.out.println("Bitte zu untersuchende Datei als Paramteter "
                + "angeben");
        System.out.println("Syntax: ./java Beleg1 <beispiel.txt>");
        System.exit(1);
      }
      else
      {
        new Parameter(args[0], args[1]).echo();
      }
      
        
        
        
        
      Read r = new Read(args[1]);
      Scanner sc = new Scanner(System.in);
      String eingabe = "";

      do{
        System.out.println("---\t Menueauswahl \t--------------------------");
        System.out.println("   [1] Woerter aufsteigend alphabetisch sortiert ");
        System.out.println("   [2] Woerter mit Haeufigkeit von min bis max\n"
                              + "\taufsteigend alphabetisch sortiert");
        System.out.println("   [3] Woerter absteigend alphabetisch sortiert");
        System.out.println("   [4] Woerter mit Haeufigkeit von min bis max\n "
                              + "\tabsteigend alphabetisch sortiert ");
        System.out.println("   [5] Woerter absteigend nach Haeufigkeit\n "
                              + "\tsortiert ");
        System.out.println("   [6] Woerter mit Haeufigkeit von min bis max\n "
                              + "\tabsteigend nach Haeufigkeit sortiert ");
        System.out.println("   [7] Woerter aufsteigend nach Haeufigkeit\n "
                              + "\tsortiert  ");
        System.out.println("   [8] Woerter mit Haeufigkeit von min bis max\n "
                              + "\taufsteigend nach Haeufigkeit sortiert");
        System.out.println("   [9] Anzahl Woerter feststellen");
        System.out.println("  [10] Woerterliste speichern ");
        System.out.println("  [11] Neue Woerterliste erzeugen");
        System.out.println("  [12] Textdatei anzeigen");
        System.out.println("  [13] Programm beenden");
        

        System.out.println("-------------------------------------------------");
        
        while(eingabe.matches("^[0-9]+$")== false) 
          {
            System.out.println("Bitte eine Zahl eingeben (1-13):\n");
            eingabe = sc.nextLine();
          }
        
        
        
        switch(Integer.parseInt(eingabe)){
          case 1:
            r.sortieren(true);
            eingabe = "";
            break;
          case 2:
            r.zaehlenAsc();
            eingabe = "";
            break;
          case 3:
            r.sortieren(false);
            eingabe = "";
            break;
          case 4:

            break;
          case 5:
            eingabe = "";
            break;   

          case 12:
            r.ausgeben();
            eingabe = "";
            break;
          case 13:
            System.exit(0);
            break;  
              
          default:
            System.out.println("Falsche Eingabe!\n"
                    + "Bitte eine Zahl eingeben (1-13)!\n");
            break;
        }
          
        } while (!"13".equals(eingabe));
        
    }

 
}
