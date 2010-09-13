package bot.game;

import java.util.ArrayList;

public class Player {
  private int playerId;
  private String playerRace;
  private String playerName;
  private int playerType;
  private int playerAlly;  
  private ArrayList<Unit> playerUnit = null;
  
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

  public void update(String updateData) {
    playerUnit = new ArrayList<Unit>();
    String[] updateDatas = updateData.split(":");    
    for (String string : updateDatas) {
      String[] unitInfo = string.split(";");
      if (unitInfo[0].equals("s"))
        continue;
      if (getPlayerId() == Integer.parseInt(unitInfo[1])) 
        playerUnit.add(new Unit(unitInfo));      
    }    
    
  }
  public ArrayList<Unit> getPlayerUnit() {
    return playerUnit;
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

