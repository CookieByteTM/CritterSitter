public class Critter
{
    private String name, colour, geneticDisease, disease;
    private int carbCount, fruitVegCount, dairyCount, proteinCount, waterCount, sugarCount, growthStage, hungerLevel;
    private boolean isHealthy = true;
    
    public Critter (String name, String colour, String geneticDisease)
    {
	this.name = name;
	this.colour = colour;
	this.geneticDisease = geneticDisease;
    }
    
    private void calculateHungerLevel()
    {
    /*use foodgroupCounts to calculate hungerLevel*/
    }
    
    public String getName()
    {
    return name;
    }
    
    public int getCarbCount()
    {
    return carbCount;//repeat this method for most other variables
    }
    
    public void setCarbCount(int carbCount)
    {
    this.carbCount=carbCount;//repeat this method for most other variables
    }
    
   
    
}
