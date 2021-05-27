package life;

public class LifePresenter {
  private final Life life;

  public LifePresenter(Life life) {
    this.life = life;
  }

  public void showField() {
    System.out.println("Generation # " + 1);
    System.out.println("AliveCount # " + life.getAliveCount());

    for (int i = 0; i < life.getHeight(); i++) {
      for (int j = 0; j < life.getWidth(); j++) {
        char symbol = life.isAlive(i, j) ? '*' : ' ';
        System.out.print(symbol);
      }
      System.out.println();
    }
  }
}
