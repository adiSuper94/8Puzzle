import com.leapmotion.leap.*;

public class LeapLink
{
	/**
	 * Necessary Object declaration
	 */
	LeapListner listener;
	Controller controller;
	EightPuzzleLogic epl;

	
	/**
	 * Instantiates declared objects
	 * Adds  a listener to controller
	 * @param ep
	 */
	public LeapLink(EightPuzzleUI ep) {
		controller = new Controller(); //Creates a controller object which establishes
									   //connection between Application and Device
		listener = new LeapListner(ep);	
		
		
		controller.addListener(listener);
	}

}