package life;

public class Main {
  public static void main(String[] args) {
    Life life = new Life(100, 10, 0.10);
    LifePresenter presenter = new LifePresenter(life, 500L);

    presenter.run();
  }
}
