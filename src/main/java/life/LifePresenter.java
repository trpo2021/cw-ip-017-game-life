package life;

import java.io.IOException;

public class LifePresenter {
  private final Life life;
  private final long delay;

  public LifePresenter(Life life, long speed) {
    this.life = life;
    this.delay = speed;
  }

  public void run() {
    while (true) {
      clearScreen();
      showField();

      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
        break;
      }

      if (life.isGameOver()) {
        System.out.printf("Game over on %d generation\n", life.getGenerationCount());
        break;
      }

      life.nextGeneration();
    }
  }

  public void showField() {
    System.out.println("Generation # " + life.getGenerationCount());
    System.out.println("AliveCount # " + life.getAliveCount());

    for (int i = 0; i < life.getHeight(); i++) {
      for (int j = 0; j < life.getWidth(); j++) {
        char symbol = life.isAlive(i, j) ? '*' : ' ';
        System.out.print(symbol);
      }
      System.out.println();
    }
  }

  public void clearScreen() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else System.out.print("\033[H\033[2J");
    } catch (IOException | InterruptedException ignored) {
    }
  }
}
