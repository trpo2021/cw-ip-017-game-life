package life;

public class Main {
  public static void main(String[] args) {
    ArgumentsParser parser = new ArgumentsParser(args);
    Settings settings = parser.parse();

    Life life = new Life(settings.width, settings.height, settings.alivePercent);
    LifePresenter presenter = new LifePresenter(life, settings.speed);

    presenter.run();
  }
}
