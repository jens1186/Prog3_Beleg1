/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beleg1;

/**
 *
 * @author Jens
 */
public class Parameter {
  
  private final String programmName;
  private final String dateiName;
   
  public Parameter(String arg0, String arg1) {
    this.programmName = arg0;
    this.dateiName = arg1;
  }

  public void echo() {
    System.out.println("Programmname\t: " + this.programmName);
    System.out.println("Dateiname\t: " + this.dateiName);
  }
  
  public String getName ( ){
    return this.dateiName;
  }
  
  
}
