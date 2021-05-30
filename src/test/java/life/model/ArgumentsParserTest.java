package life.model;

import life.ArgumentsParser;
import life.Settings;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsParserTest {
  private static Settings getSettings(String[] args) {
    ArgumentsParser parser = new ArgumentsParser(args);
    return parser.parse();
  }

  @Test
  public void parseWidthTest() {
    String[] args = "--width 500".split(" ");
    Settings settings = getSettings(args);
    assertEquals(500, settings.width);
  }

  @Test
  public void parseBadWidthTest() {
    String[] args = "--width ten".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseBadValueWidthTest() {
    String[] args = "--width -500".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseHeightTest() {
    String[] args = "--height 400".split(" ");
    Settings settings = getSettings(args);
    assertEquals(400, settings.height);
  }

  @Test
  public void parseBadHeightTest() {
    String[] args = "--height ten".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }


  @Test
  public void parseBadValueHeightTest() {
    String[] args = "--height -400".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseSpeedTest() {
    String[] args = "--speed 1000".split(" ");
    Settings settings = getSettings(args);
    assertEquals(1000, settings.speed);
  }

  @Test
  public void parseBadSpeedTest() {
    String[] args = "--speed zero".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseBadValueSpeedTest() {
    String[] args = "--speed -5".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseAlivePercentTest() {
    String[] args = "--alivePercent 50".split(" ");
    Settings settings = getSettings(args);
    double epsilon = 0.00001;
    assertTrue(Math.abs(0.5 - settings.alivePercent) < epsilon );
  }

  @Test
  public void parseBadAlivePercentTest() {
    String[] args = "--alivePercent zero".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseBadValueAlivePercentTest() {
    String[] args = "--alivePercent 105".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

  @Test
  public void parseBadMinusValueAlivePercentTest() {
    String[] args = "--alivePercent -50".split(" ");
    assertThrows(IllegalArgumentException.class, () -> getSettings(args));
  }

}
