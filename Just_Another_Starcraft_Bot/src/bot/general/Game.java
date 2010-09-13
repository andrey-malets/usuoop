package bot.general;

import java.util.ArrayList;

import bot.command.CommandQueue;
import bot.game.Player;
import bot.game.StartLocation;

public class Game {
  private int botId;
  private Player bot;
  private CommandQueue commandQueue = null;
  private ArrayList<Player> players = null;
  private ArrayList<StartLocation> startLocations = null;
  
  private int gameMinerals;
  private int gameGas;
  private int gameSupplyUsed;
  private int gameSupplyTotal;
  private int[] gameResearcheStatus = new int[47];
  private int[] gameUpgradeStatus = new int[63];
  
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
  public void update(String updateData) {
    String[] updateDatas = updateData.split(":");
    String[] playerInfo = updateDatas[0].split(";");
    
    setGameMinerals(Integer.parseInt(playerInfo[1]));
    setGameGas(Integer.parseInt(playerInfo[2]));
    setGameSupplyUsed(Integer.parseInt(playerInfo[3]));
    setGameSupplyTotal(Integer.parseInt(playerInfo[4]));
    
    for (Player player : players) {
      player.update(updateData);
    }    
  }
  private void setBotId(int botId) {
    this.botId = botId;
  }
  public int getBotId() {
    return botId;
  }
  public Player getBot() {
    return bot;
  }
  public CommandQueue getCommandQueue() {
    return commandQueue;
  }
  private void setGameMinerals(int gameMinerals) {
    this.gameMinerals = gameMinerals;
  }
  public int getGameMinerals() {
    return gameMinerals;
  }
  private void setGameGas(int gameGas) {
    this.gameGas = gameGas;
  }
  public int getGameGas() {
    return gameGas;
  }
  private void setGameSupplyUsed(int gameSupplyUsed) {
    this.gameSupplyUsed = gameSupplyUsed;
  }
  public int getGameSupplyUsed() {
    return gameSupplyUsed;
  }
  private void setGameSupplyTotal(int gameSupplyTotal) {
    this.gameSupplyTotal = gameSupplyTotal;
  }
  public int getGameSupplyTotal() {
    return gameSupplyTotal;
  }  
}
