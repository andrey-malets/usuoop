package bot.config;

public class Config {
  public static final int port = 12345;
  /** allow the user to control units */
  public static boolean allowUserControl = true;
  
  /** turn on complete information */
  public static boolean completeInformation = true;

  /** display agent commands in SC? */
  public static boolean logCommands = true;

  /** display agent commands in SC? */
  public static boolean terrainAnalysis = true;
  public static String getConfigString() {    
    return  (allowUserControl ? "1" : "0") + 
            (completeInformation ? "1" : "0") +
            (logCommands ? "1" : "0") +
            (terrainAnalysis ? "1" : "0");    
  }
}
