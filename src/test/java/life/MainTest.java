package life;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
  @Test
  public void testSum() {
    Assert.assertEquals(5, Main.sum(3, 2));
  }

  @Test
  public void testDifference() {
    Assert.assertEquals(3, Main.difference(10, 7));
  }
}
