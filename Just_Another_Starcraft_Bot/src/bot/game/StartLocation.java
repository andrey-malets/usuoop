package bot.game;

import java.util.ArrayList;

public class StartLocation {
  public int x;
  public int y;
  public static ArrayList<StartLocation> getStartLocation(String locationData) {
    ArrayList<StartLocation> startLocations = new ArrayList<StartLocation>();
    String[] locationDatas = locationData.split(":");
    for (String string : locationDatas) {
      if (string.equals("Locations")) 
        continue;
     String[] locationAttr = string.split(";");
     StartLocation startLocation = new StartLocation();
     startLocation.x = Integer.parseInt(locationAttr[0]);
     startLocation.y = Integer.parseInt(locationAttr[1]);
     startLocations.add(startLocation);
    }
    return startLocations;    
  }
}
