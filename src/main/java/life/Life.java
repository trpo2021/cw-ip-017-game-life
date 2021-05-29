package life;

public class Life {
  private final int width;
  private final int height;
  private boolean[][] currentGeneration;
  private boolean[][] previousGeneration;
  private boolean[][] prePreviousGeneration;
  private int generationCount;
  private int aliveCount;
  private boolean isGameOver = false;

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

  public Life(boolean[][] generation) {
    this.width = generation[0].length;
    this.height = generation.length;

    currentGeneration = new boolean[height][width];
    previousGeneration = new boolean[height][width];
    prePreviousGeneration = new boolean[height][width];

    for (int i = 0; i < height; i++) {
      System.arraycopy(generation[i], 0, previousGeneration[i], 0, width);
      System.arraycopy(generation[i], 0, currentGeneration[i], 0, width);
    }

    generationCount = 1;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (currentGeneration[i][j]) {
          aliveCount++;
        }
      }
    }
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

  public int getGenerationCount() {
    return generationCount;
  }

  public boolean isAlive(int y, int x) {
    return currentGeneration[y][x];
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  private void initWorld(double alivePercent) {
    currentGeneration = new boolean[height][width];
    previousGeneration = new boolean[height][width];
    prePreviousGeneration = new boolean[height][width];
    generationCount = 1;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        boolean isAlive = Math.random() < alivePercent;
        previousGeneration[i][j] = isAlive;
        currentGeneration[i][j] = isAlive;

        if (isAlive) {
          aliveCount++;
        }
      }
    }
  }

  public void nextGeneration() {
    for (int i = 0; i < height; i++) {
      System.arraycopy(previousGeneration[i], 0, prePreviousGeneration[i], 0, width);
    }

    for (int i = 0; i < height; i++) {
      System.arraycopy(currentGeneration[i], 0, previousGeneration[i], 0, width);
    }

    generationCount++;
    aliveCount = 0;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int aliveNeighboursCount = aliveNeighboursCount(i, j);

        if (previousGeneration[i][j]) {
          currentGeneration[i][j] = aliveNeighboursCount >= 2 && aliveNeighboursCount <= 3;
        } else {
          currentGeneration[i][j] = aliveNeighboursCount == 3;
        }

        if (currentGeneration[i][j]) {
          aliveCount++;
        }
      }
    }

    checkGameOver();
  }

  private int aliveNeighboursCount(int yCoordinate, int xCoordinate) {
    int count = 0;

    for (int i = xCoordinate - 1; i <= xCoordinate + 1; i++) {
      int x = i;
      if (x < 0) {
        x += width;
      } else if (x >= width) {
        x -= width;
      }

      for (int j = yCoordinate - 1; j <= yCoordinate + 1; j++) {
        if (i == xCoordinate && j == yCoordinate) {
          continue;
        }

        int y = j;
        if (y < 0) {
          y += height;
        } else if (y >= height) {
          y -= height;
        }

        if (previousGeneration[y][x]) {
          count++;
        }
      }
    }

    return count;
  }

  private void checkGameOver() {
    if (aliveCount == 0) {
      isGameOver = true;
      return;
    }

    if (compareTwoGeneration(currentGeneration, previousGeneration)) {
      isGameOver = true;
      return;
    }

    if (compareTwoGeneration(currentGeneration, prePreviousGeneration)) {
      isGameOver = true;
    }
  }

  private boolean compareTwoGeneration(boolean[][] first, boolean[][] second) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (first[i][j] != second[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
