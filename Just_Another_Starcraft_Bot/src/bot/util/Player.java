package bot.util;

import java.util.ArrayList;

public class Player {
  private int playerId;
  private String playerRace;
  private String playerName;
  private int playerType;
  private int playerAlly;
  
  public static ArrayList<Player> getPlayers(String playerData) {
    ArrayList<Player> players = new ArrayList<Player>();
    String playerDatas[] = playerData.split(":");    
    for (String string : playerDatas) {      
      String playerAttr[] = string.split(";");      
      
      if (playerAttr[0].equals("NewGame")) {
        continue;
      }
      
      Player player = new Player();
      player.setPlayerId(Integer.parseInt(playerAttr[0]));
      player.setPlayerRace(playerAttr[1]);
      player.setPlayerName(playerAttr[2]);
      player.setPlayerType(Integer.parseInt(playerAttr[3]));
      player.setPlayerAlly(Integer.parseInt(playerAttr[4]));
      players.add(player);
    }    
    return players;    
  }

  private void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public int getPlayerId() {
    return playerId;
  }

  private void setPlayerRace(String playerRace) {
    this.playerRace = playerRace;
  }

  public String getPlayerRace() {
    return playerRace;
  }

  private void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerName() {
    return playerName;
  }

  private void setPlayerType(int playerType) {
    this.playerType = playerType;
  }

  public int getPlayerType() {
    return playerType;
  }

  private void setPlayerAlly(int playerAlly) {
    this.playerAlly = playerAlly;
  }

  public int getPlayerAlly() {
    return playerAlly;
  }
}

