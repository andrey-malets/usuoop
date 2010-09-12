package bot.general;

import java.util.ArrayList;

import bot.command.CommandQueue;
import bot.util.Player;
import bot.util.StartLocation;

public class Game {
  private int botId;
  private Player bot;
  private CommandQueue commandQueue = null;
  private ArrayList<Player> players = null;
  private ArrayList<StartLocation> startLocations = null;
  
  public Game(String playerData,String locationData,String mapData,String chokesData,String basesData) {
    players = Player.getPlayers(playerData);
    startLocations = StartLocation.getStartLocation(locationData);    
    commandQueue = new CommandQueue();
    setBotId(Integer.parseInt(playerData.split(":")[0].split(";")[1]));
    for (Player player : players) 
      if (player.getPlayerId() == getBotId())
        bot = player;   
    
/*  System.out.println(mapData);
    System.out.println(chokesData);
    System.out.println(basesData); */
  }
  public void update(String update) {
    
  }
  private void setBotId(int botId) {
    this.botId = botId;
  }
  public int getBotId() {
    return botId;
  }
  
  public CommandQueue getCommandQueue() {
    return commandQueue;
  }
}
