import java.util.ArrayList;

/**
 * 
 */

/**
 * @author adurso0747
 *
 */
class HoverBoardModel 
{
	//Declare variables
	private double price;   
	private double maxRange;
	private double maxSpeed;
	ArrayList<String> setofColors;
	private boolean hasBurntUp;
	@Override
	public String toString() {
		return "HoverBoardModel [price=" + price + ", maxRange=" + maxRange
				+ ", maxSpeed=" + maxSpeed + ", setofColors=" + setofColors
				+ ", hasBurntUp=" + hasBurntUp + "]";
	}
	public HoverBoardModel() 
	{
		this.price = 0;
		this.maxRange = 0;
		this.maxSpeed = 0;
		this.hasBurntUp = false;
		setofColors = new ArrayList<String>();
		setofColors.add("Yellow");
		setofColors.add("Blue");
		setofColors.add("Green");
	}
	public HoverBoardModel(double price, double maxRange, double maxSpeed,
			ArrayList<String> setofColors, boolean hasBurntUp) {
		this.price = price;
		this.maxRange = maxRange;
		this.maxSpeed = maxSpeed;
		this.setofColors = setofColors;
		this.hasBurntUp = hasBurntUp;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public ArrayList<String> getSetofColors() {
		return setofColors;
	}
	public void setSetofColors(ArrayList<String> setofColors) {
		this.setofColors = setofColors;
	}
	public boolean isHasBurntUp() {
		return hasBurntUp;
	}
	public void setHasBurntUp(boolean hasBurntUp) {
		this.hasBurntUp = hasBurntUp;
	}
}