package pft.sandbox;

/**
 * Created by t.chaynikova on 4/20/2016.
 */
public class Task2 {

  public static void main(String[] args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(2,2);

    System.out.println("Points coordinates: \nx1 = " +  p1.x + " and y1 = " + p1.y  + "\nx2 = " + p2.x + " and y2 = " + p2.y  + "\nThe distance is: "  + distance (p1,p2));
      }

  public static double distance (Point p1, Point p2){
   p1.x = p2.x-p1.x;
   p2.y = p2.y-p1.y;
   p1.x = Math.pow(p1.x,2);
   p2.y = Math.pow(p2.y,2);
   double diff = p1.x+p2.y;
   return Math.sqrt(diff);

  }
}
