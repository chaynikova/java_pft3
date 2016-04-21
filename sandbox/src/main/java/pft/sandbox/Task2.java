package pft.sandbox;

/**
 * Created by t.chaynikova on 4/20/2016.
 */
public class Task2 {

  public static void main(String[] args){
    Point p = new Point();
   p.x1 = 1;
   p.y1 = 1;
   p.x2 = 2;
   p.y2 = 2;

    System.out.println("Points coordinates: \nx1 = " + p.x1 + " and y1 = " + p.y1  + "\nx2 = " + p.x2 + " and y2 = " + p.y2  + "\nThe distance is: "  + distance (p));
      }

  public static double distance (Point p){
   p.x = p.x2-p.x1;
   p.y = p.y2-p.y1;
   p.x = Math.pow(p.x,2);
   p.y = Math.pow(p.y,2);
   double diff = p.x+p.y;
   return Math.sqrt(diff);

  }
}
