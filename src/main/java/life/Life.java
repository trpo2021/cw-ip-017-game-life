package life;

public class Life {
  private final int width;
  private final int height;
  private boolean[][] currentGeneration;
  private boolean[][] previousGeneration;
  private int generationCount;
  private int aliveCount;

  public Life(int width, int height, double alivePercent) {
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("height and width should be more than zero");
    }

    if (alivePercent < 0 || alivePercent > 1) {
      throw new IllegalArgumentException("alivePercent should be from 0 to 1");
    }

    this.height = height;
    this.width = width;
    initWorld(alivePercent);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getAliveCount() {
    return aliveCount;
  }

  public boolean isAlive(int y, int x) {
    return currentGeneration[y][x];
  }

  private void initWorld(double alivePercent) {
    currentGeneration = new boolean[this.height][this.width];
    previousGeneration = new boolean[this.height][this.width];
    generationCount = 1;

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        boolean isAlive = Math.random() < alivePercent;
        previousGeneration[i][j] = isAlive;
        currentGeneration[i][j] = isAlive;

        if (isAlive) {
          aliveCount++;
        }
      }
    }
  }
}
