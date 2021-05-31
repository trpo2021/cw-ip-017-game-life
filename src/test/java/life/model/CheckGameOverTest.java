package life.model;

import life.Life;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckGameOverTest {
  @Test
  public void IsGameOverNoCellsLeft() {
    boolean[][] generation = new boolean[3][3];
    generation[1][1] = true;
    generation[2][1] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertTrue(life.isGameOver());
  }

  @Test
  public void IsGameOverStableConfiguration() {
    boolean[][] generation = new boolean[4][4];
    generation[1][1] = true;
    generation[1][2] = true;
    generation[2][1] = true;
    generation[2][2] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    assertTrue(life.isGameOver());
  }

  @Test
  public void IsGameOverPeriodicConfiguration() {
    boolean[][] generation = new boolean[10][10];
    generation[4][5] = true;
    generation[4][6] = true;
    generation[4][7] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    life.nextGeneration();
    assertTrue(life.isGameOver());
  }

  @Test
  public void IsNotGameOver() {
    boolean[][] generation = new boolean[10][10];
    generation[4][4] = true;
    generation[5][5] = true;
    generation[5][6] = true;
    generation[4][6] = true;
    generation[3][6] = true;
    Life life = new Life(generation);
    life.nextGeneration();
    life.nextGeneration();
    life.nextGeneration();
    life.nextGeneration();
    assertFalse(life.isGameOver());
  }
}
