package pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by t.chaynikova on 5/18/2016.
 */
public class PointTests {
  @Test
  public void testArea(){

    Point p1 = new Point (5,6);
    Point p2 = new Point (10,20);
    Assert.assertEquals(p1.distance(p2), 14.866068747318506);
  }
  @Test
public void testArea2(){

  Point p3 = new Point (17,12);
  Point p4 = new Point (11,22);
  Assert.assertEquals(p3.distance(p4), 11.661903789690601);
}

}
