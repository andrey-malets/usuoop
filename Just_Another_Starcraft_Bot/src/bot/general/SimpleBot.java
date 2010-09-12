package bot.general;

public class SimpleBot implements Bot {

  @Override
  public void start(Game game) {
    System.out.println("Start");    
  }

  @Override
  public void stop() {
    System.out.println("Stop");
  }

}
