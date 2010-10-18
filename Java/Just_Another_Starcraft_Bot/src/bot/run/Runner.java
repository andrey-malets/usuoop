package bot.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import bot.config.Config;
import bot.game.Unit;
import bot.general.Bot;
import bot.general.Game;

public class Runner {
  private Class botClass = null;
  private Bot bot = null;
  private ServerSocket serverSocket = null;
  public Runner(Class botClass) {
    this.botClass = botClass; 
  }
  public void start() {    
    try {
      serverSocket = new ServerSocket(Config.port);
    } catch (IOException e) {      
      e.printStackTrace(System.err);
    }
    if (serverSocket != null) {
      while (true) {
        try {          
          System.out.println("[!] Wait for connection.");
          Socket socket = serverSocket.accept();
          System.out.println("[+] Accept connection " + socket + "!");
          runGame(socket);
        } catch (Exception e) {
          e.printStackTrace(System.err);
        }
      }
    } else {
      stop();
    }
  }
  private void runGame(Socket socketGame) {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(socketGame.getInputStream()));
      String playerData = reader.readLine();
      
      socketGame.getOutputStream().write(Config.getConfigString().getBytes());
      
      String locationData = reader.readLine();        
      String mapData = reader.readLine();
      String chokesData = "Chokes:";
      String basesData = "Bases:";
      
      if (Config.terrainAnalysis) {
        chokesData = reader.readLine();         
        basesData = reader.readLine();          
      }
      
      Game game = new Game(playerData,locationData,mapData,chokesData,basesData);      
      
      
      try {
        Constructor constructor = botClass.getConstructor(Game.class);        
        bot = (Bot) constructor.newInstance(game);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
      new Thread(bot).start();
      
      
      while (true) {
        String update = reader.readLine();        
        game.update(update);        
        
        for (Unit unit : game.getBot().getPlayerUnit()) {
          System.out.println(unit.getUnitTypeId());        
        } 
               
        System.exit(0);
        socketGame.getOutputStream().write(game.getCommandQueue().getCommands().getBytes());
      }
      
    } catch (SocketException e) {      
      System.err.println("[-] Starcraft disconnected!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void stop() {    
    
  }
}
