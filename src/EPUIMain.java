/**
 * This class contains the "public static void main(String[] args)"
 * The Goal of this puzzle game is to arrange the elements in the order
 * 1 2 3
 * 4 5 6
 * 7 8 0
 * 
 * The tile marked 0 can be swapped with any adjacent tile.
 * 
 * Input can be give as:
 * 	1.Mouse click
 *  2.Arrow keys
 *  3.Gestures (LeapMotion Device Required)
 *
 * @author Adi Subramanian
 *
 */
public class EPUIMain {
		
	public static void main(String[] args) 
	{
		EightPuzzleLogic ep = new EightPuzzleLogic();
		EightPuzzleUI epl = new EightPuzzleUI(ep);
		epl.setVisible(true);
		epl.setSize(400, 400);	

	}

}
