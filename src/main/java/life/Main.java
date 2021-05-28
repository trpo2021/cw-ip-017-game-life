package life;

public class Main {
  public static void main(String[] args) {
    Life life = new Life(6, 10, 0.10);
    LifePresenter presenter = new LifePresenter(life);

    presenter.showField();
    life.nextGeneration();
    presenter.showField();
  }
}
