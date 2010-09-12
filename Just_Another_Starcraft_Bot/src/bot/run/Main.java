package bot.run;

import bot.general.SimpleBot;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new Runner(new SimpleBot()).start();
  }

}
