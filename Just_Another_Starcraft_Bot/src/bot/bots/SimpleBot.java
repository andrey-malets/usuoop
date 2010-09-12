package bot.bots;

import bot.general.Bot;
import bot.general.Game;

public class SimpleBot implements Bot {
  private Game game;
  
  public SimpleBot(Game game) {
    System.out.println("[From Bot] Created!");
    this.game = game;
  }

  @Override
  public void stop() {
    System.out.println("[From Bot] Stop!");
  }

  @Override
  public void run() {
    System.out.println("[From Bot] Run!");    
  }

}
