package pft.sandbox;

/**
 * Created by t.chaynikova on 4/20/2016.
 */
public class Task2 {

 public static void main (String [] args){

   double x1 = 1;
   double x2 = 2;
   double y1 = 1;
   double y2 = 2;

   System.out.println("Distance is: " + distance(x1, x2, y1, y2));
 }

  public static double distance (double x1, double x2, double y1, double y2){

    return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
  }
}
