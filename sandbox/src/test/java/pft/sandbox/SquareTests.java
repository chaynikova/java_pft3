package pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by t.chaynikova on 5/10/2016.
 */
public class SquareTests {

  @Test
  public void testArea(){

    Square s = new Square (5);
    Assert.assertEquals(s.area(), 25.0);
  }
}
