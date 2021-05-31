package life.model;

import life.Life;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NextGenerationTest {
  @Test
  public void soloCellDie() {
    boolean[][] generation = new boolean[3][3];
    generation[1][1] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertFalse(life.isAlive(1, 1));
  }

  @Test
  public void twoCellsDie() {
    boolean[][] generation = new boolean[3][3];
    generation[2][2] = true;
    generation[1][1] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertFalse(life.isAlive(1, 1));
    assertFalse(life.isAlive(2, 2));
  }

  @Test
  public void threeCellsLife() {
    boolean[][] generation = new boolean[4][4];
    generation[2][2] = true;
    generation[1][1] = true;
    generation[1][2] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertTrue(life.isAlive(1, 1));
    assertTrue(life.isAlive(2, 2));
    assertTrue(life.isAlive(1, 2));
  }

  @Test
  public void threeCellsLifeAndOneNew() {
    boolean[][] generation = new boolean[3][4];
    generation[2][2] = true;
    generation[1][1] = true;
    generation[1][2] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertTrue(life.isAlive(1, 1));
    assertTrue(life.isAlive(2, 2));
    assertTrue(life.isAlive(1, 2));
    assertTrue(life.isAlive(2, 1));
  }

  @Test
  public void threeCellsDie() {
    boolean[][] generation = new boolean[5][5];
    generation[0][1] = true;
    generation[1][1] = true;
    generation[1][4] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertFalse(life.isAlive(0, 1));
    assertFalse(life.isAlive(1, 1));
    assertFalse(life.isAlive(1, 4));
  }

  @Test
  public void fourLifeCelllifeAndOneDie() {
    boolean[][] generation = new boolean[5][5];
    generation[1][2] = true;
    generation[2][1] = true;
    generation[2][2] = true;
    generation[2][3] = true;
    generation[3][2] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertFalse(life.isAlive(2, 2));
    assertTrue(life.isAlive(1, 2));
    assertTrue(life.isAlive(2, 1));
    assertTrue(life.isAlive(2, 3));
    assertTrue(life.isAlive(3, 2));
  }

  @Test
  public void threeCellLifeAndSixNew() {
    boolean[][] generation = new boolean[3][3];
    generation[0][0] = true;
    generation[1][0] = true;
    generation[2][0] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertTrue(life.isAlive(0, 0));
    assertTrue(life.isAlive(0, 1));
    assertTrue(life.isAlive(0, 2));
    assertTrue(life.isAlive(1, 0));
    assertTrue(life.isAlive(1, 1));
    assertTrue(life.isAlive(1, 2));
    assertTrue(life.isAlive(2, 0));
    assertTrue(life.isAlive(2, 1));
    assertTrue(life.isAlive(2, 2));
  }

  @Test
  public void nineCellsDie() {
    boolean[][] generation = new boolean[3][3];
    generation[0][0] = true;
    generation[0][1] = true;
    generation[0][2] = true;
    generation[1][0] = true;
    generation[1][1] = true;
    generation[1][2] = true;
    generation[2][0] = true;
    generation[2][1] = true;
    generation[2][2] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertFalse(life.isAlive(0, 0));
    assertFalse(life.isAlive(0, 1));
    assertFalse(life.isAlive(0, 2));
    assertFalse(life.isAlive(1, 0));
    assertFalse(life.isAlive(1, 1));
    assertFalse(life.isAlive(1, 2));
    assertFalse(life.isAlive(2, 0));
    assertFalse(life.isAlive(2, 1));
    assertFalse(life.isAlive(2, 2));
  }
}
