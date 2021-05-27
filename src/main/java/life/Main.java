package life;

public class Main {
  public static void main(String[] args) {
    Life life = new Life(100, 10, 0.15);
    LifePresenter presenter = new LifePresenter(life);

    presenter.showField();
  }
}
