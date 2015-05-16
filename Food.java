public class Food
{
    private String name, foodGroup, icon;
    private int price, nutrientValue;

    public Food (String name, int price, String foodGroup, int nutrientValue, String icon)
    {
	this.name = name;
	this.price = price;
	this.foodGroup = foodGroup;
	this.nutrientValue = nutrientValue;
	this.icon = icon; //the name or location of the picture of the food e.g. chickenLeg.jpg
    }


    public String getName ()
    {
	return name;
    }


    public int getPrice ()
    {
	return price;
    }


    public String getFoodGroup ()
    {
	return foodGroup;
    }


    public int getNutrientValue ()
    {
	return nutrientValue;
    }


    public String getIcon ()
    {
	return icon;
    }
}
