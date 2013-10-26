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
  
  private final String arg0;
  private final String arg1;
  
  
  public Parameter(String arg0, String arg1) {
    this.arg0 = arg0;
    this.arg1 = arg1;
  }

  public void echo() {
    System.out.println("Programmname\t: " +arg0);
    System.out.println("Dateiname\t: " +arg1);
  }
  
  public String getName ( ){
    return arg1;
  }
  
  
}
