package life;

public class ArgumentsParser {
  public static final String widthType = "--width";
  private static final String heightType = "--height";
  private static final String speedType = "--speed";
  private static final String alivePercentType = "--alivePercent";

  private String[] args;

  public ArgumentsParser(String[] args) {
    this.args = args;
  }

  public Settings parse() {
    Settings settings = new Settings();

    for (int i = 0; i < args.length; i++) {
      switch (args[i].trim()) {
        case widthType:
          int width = getIntFromArgs(i + 1, widthType);
          checkFieldSizeCorrect(width);
          settings.width = width;
          break;
        case heightType:
          int height = getIntFromArgs(i + 1, heightType);
          checkFieldSizeCorrect(height);
          settings.height = height;
          break;
        case speedType:
          int speed = getIntFromArgs(i + 1, speedType);

          if (speed < 100 || speed > 5000) {
            throw new IllegalArgumentException("speed must be in range from 100 to 5000 ms");
          }

          settings.speed = speed;

          break;
        case alivePercentType:
          double alivePercent = getDoubleFromArgs(i + 1, alivePercentType);

          if (alivePercent < 0 || alivePercent > 100) {
            throw new IllegalArgumentException(
                "percent of alive cells must be in range from 0 to 100%");
          }

          settings.alivePercent = alivePercent / 100;
          break;
      }
    }

    return settings;
  }

  private int getIntFromArgs(int index, String type) {
    if (index >= args.length) {
      throw new IllegalArgumentException("No Value");
    }

    try {
      return Integer.parseInt(args[index]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("for " + type + " arguments must be integer");
    }
  }

  private double getDoubleFromArgs(int index, String type) {
    if (index >= args.length) {
      throw new IllegalArgumentException("No Value");
    }

    try {
      return Double.parseDouble(args[index]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("for " + type + " arguments must be double");
    }
  }

  private void checkFieldSizeCorrect(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Width and height must be more that zero");
    }
  }
}
