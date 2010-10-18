package bot.run;

import bot.bots.SimpleBot;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new Runner(SimpleBot.class).start();
  }

}
