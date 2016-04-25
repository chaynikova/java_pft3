package pft.sandbox;

/**
 * Created by t.chaynikova on 4/20/2016.
 */
public class Task2 {

 public static void main (String [] args){
Point p1 = new Point(1, 1);
Point p2 = new Point(2, 2);
 //  p1.x = 1;
//   p1.y = 1;
  // p2.x = 2;
 //  p2.y = 2;

   //double x1 = 1;
  // double x2 = 2;
 //  double y1 = 1;
 //  double y2 = 2;

   System.out.println("Distance is: " + distance(p1, p2));
 }

  public static double distance (Point p1, Point p2){

    return Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
  }
}
