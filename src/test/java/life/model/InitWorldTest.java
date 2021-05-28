package life.model;

import life.Life;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitWorldTest {
  public static double inaccuracyValue = 0.05;

  @Test
  public void testIncorrectWidth() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Life(-5, 20, 0.5));
    assertEquals("height and width should be more than zero", exception.getMessage());
  }

  @Test
  public void testIncorrectHeight() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Life(50, -5, 0.5));
    assertEquals("height and width should be more than zero", exception.getMessage());
  }

  @Test
  public void testIncorrectAlivePercentLessZero() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Life(40, 20, -1));
    assertEquals("alivePercent should be from 0 to 1", exception.getMessage());
  }

  @Test
  public void testIncorrectAlivePercentMoreOne() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Life(40, 20, 2));
    assertEquals("alivePercent should be from 0 to 1", exception.getMessage());
  }

  @Test
  public void testAlivePercent50() {
    assertTrue(testNumberAliveCount(0.5));
  }

  @Test
  public void testAlivePercent25() {
    assertTrue(testNumberAliveCount(0.25));
  }

  @Test
  public void testAlivePercent0() {
    assertTrue(testNumberAliveCount(0));
  }

  @Test
  public void testAlivePercent100() {
    assertTrue(testNumberAliveCount(1));
  }

  private boolean testNumberAliveCount(double alivePercent) {
    int width = 100;
    int height = 100;
    int allCells = width * height;

    Life life = new Life(width, height, alivePercent);

    return life.getAliveCount() > allCells * (alivePercent - inaccuracyValue)
        && life.getAliveCount() < allCells * (alivePercent + inaccuracyValue);
  }
}
