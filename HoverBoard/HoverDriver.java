import java.util.ArrayList;
/

/**
 * @author David Luzeski
 *
 */
public class HoverDriver {

	public static void main(String[] args) {
		HoverBoardModel ixo = new HoverBoardModel();
		ArrayList<String> modelColors = new ArrayList<String>();
		ArrayList<String> test;
		double x;
		boolean y;
		
		x = ixo.getMaxRange();
		x = ixo.getMaxSpeed();
		x = ixo.getPrice();
		
		ixo.setMaxRange(650);
		ixo.setMaxSpeed(75);
		ixo.setPrice(500);
		
		y = ixo.isHasBurntUp();
		ixo.setHasBurntUp(false);
		
		modelColors = ixo.getSetofColors();
		modelColors.add("Turquoise");
		modelColors.add("Eggshell");
		modelColors.add("Aquamarine");
		
		ixo.setSetofColors(modelColors);
		test = ixo.getSetofColors();
      
      String toString = ixo.toString();
	}

}