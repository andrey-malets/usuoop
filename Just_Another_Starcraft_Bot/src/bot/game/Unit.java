package bot.game;

public class Unit {
  
  private int unitId;
  private int unitPlayerId;
  private int unitTypeId;
  private int unitTileX;
  private int unitTileY;
  private int unitHealth;
  private int unitShields;  
  private int unitEnergy;
  private int unitRemainingBuildTime;
  private int unitRemainingTrainTime;
  private int unitRemainingResearchTime;
  private int unitRemainingUpgradeTime;
  private int unitOrderTimer;
  private int unitOrderId;
  private int unitResources;
  private int unitAddOnID;
  private int unitMineCount;
  
  public Unit(String[] unitInfo) {   
    setUnitId(Integer.parseInt(unitInfo[0]));
    setUnitPlayerId(Integer.parseInt(unitInfo[1]));
    setUnitTypeId(Integer.parseInt(unitInfo[2]));
    setUnitTileX(Integer.parseInt(unitInfo[3]));
    setUnitTileY(Integer.parseInt(unitInfo[4]));
    setUnitHealth(Integer.parseInt(unitInfo[5]));
    setUnitShields(Integer.parseInt(unitInfo[6]));  
    setUnitEnergy(Integer.parseInt(unitInfo[7]));
    setUnitRemainingBuildTime(Integer.parseInt(unitInfo[8]));
    setUnitRemainingTrainTime(Integer.parseInt(unitInfo[9]));
    setUnitRemainingResearchTime(Integer.parseInt(unitInfo[10]));
    setUnitRemainingUpgradeTime(Integer.parseInt(unitInfo[11]));
    setUnitOrderTimer(Integer.parseInt(unitInfo[12]));
    setUnitOrderId(Integer.parseInt(unitInfo[13]));
    setUnitResources(Integer.parseInt(unitInfo[14]));
    setUnitAddOnID(Integer.parseInt(unitInfo[15]));
    setUnitMineCount(Integer.parseInt(unitInfo[16]));    
  }

  private void setUnitId(int unitId) {
    this.unitId = unitId;
  }

  public int getUnitId() {
    return unitId;
  }

  private void setUnitPlayerId(int unitPlayerId) {
    this.unitPlayerId = unitPlayerId;
  }

  public int getUnitPlayerId() {
    return unitPlayerId;
  }

  private void setUnitTypeId(int unitTypeId) {
    this.unitTypeId = unitTypeId;
  }

  public int getUnitTypeId() {
    return unitTypeId;
  }

  private void setUnitTileX(int unitTileX) {
    this.unitTileX = unitTileX;
  }

  public int getUnitTileX() {
    return unitTileX;
  }

  private void setUnitTileY(int unitTileY) {
    this.unitTileY = unitTileY;
  }

  public int getUnitTileY() {
    return unitTileY;
  }

  private void setUnitHealth(int unitHealth) {
    this.unitHealth = unitHealth;
  }

  public int getUnitHealth() {
    return unitHealth;
  }

  private void setUnitShields(int unitShields) {
    this.unitShields = unitShields;
  }

  public int getUnitShields() {
    return unitShields;
  }

  private void setUnitEnergy(int unitEnergy) {
    this.unitEnergy = unitEnergy;
  }

  public int getUnitEnergy() {
    return unitEnergy;
  }

  private void setUnitRemainingBuildTime(int unitRemainingBuildTime) {
    this.unitRemainingBuildTime = unitRemainingBuildTime;
  }

  public int getUnitRemainingBuildTime() {
    return unitRemainingBuildTime;
  }

  private void setUnitRemainingTrainTime(int unitRemainingTrainTime) {
    this.unitRemainingTrainTime = unitRemainingTrainTime;
  }

  public int getUnitRemainingTrainTime() {
    return unitRemainingTrainTime;
  }

  private void setUnitRemainingResearchTime(int unitRemainingResearchTime) {
    this.unitRemainingResearchTime = unitRemainingResearchTime;
  }

  public int getUnitRemainingResearchTime() {
    return unitRemainingResearchTime;
  }

  private void setUnitRemainingUpgradeTime(int unitRemainingUpgradeTime) {
    this.unitRemainingUpgradeTime = unitRemainingUpgradeTime;
  }

  public int getUnitRemainingUpgradeTime() {
    return unitRemainingUpgradeTime;
  }

  private void setUnitOrderTimer(int unitOrderTimer) {
    this.unitOrderTimer = unitOrderTimer;
  }

  public int getUnitOrderTimer() {
    return unitOrderTimer;
  }

  private void setUnitOrderId(int unitOrderId) {
    this.unitOrderId = unitOrderId;
  }

  public int getUnitOrderId() {
    return unitOrderId;
  }

  private void setUnitResources(int unitResources) {
    this.unitResources = unitResources;
  }

  public int getUnitResources() {
    return unitResources;
  }

  private void setUnitAddOnID(int unitAddOnID) {
    this.unitAddOnID = unitAddOnID;
  }

  public int getUnitAddOnID() {
    return unitAddOnID;
  }

  private void setUnitMineCount(int unitMineCount) {
    this.unitMineCount = unitMineCount;
  }

  public int getUnitMineCount() {
    return unitMineCount;
  }
  
}
