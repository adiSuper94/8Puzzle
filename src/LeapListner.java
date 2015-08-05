import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;


public class LeapListner extends Listener {

	EightPuzzleUI eplm;
	/**
	 * Creates a new reference of an already existing object of type EightPuzzleUI.
	 * @param ep
	 */
	public LeapListner(EightPuzzleUI ep)
	{
		eplm =ep;
	}


	/**
	 *Specifies instructions to be executed when connection is established  .
	 *
	 */
	public void onConnect(Controller controller)
	{
		eplm.l.setText("Device Connected");
		eplm.repaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Specifies instructions to be executed when connection is severed.
	 */
	
	public void onDisconnect(Controller controller)
	{
		eplm.l.setText("Device Disconnected");
		eplm.repaint();		
	}
	/**
	 * Called once, when this Listener object is newly added to a Controller.
	 * Specifies instructions to be executed on Initialization of Device.
	 */

	public void onInit(Controller controller)
	{
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.config().setFloat("Gesture.Swipe.MinLength", 125.0f);
		controller.config().setFloat("Gesture.Swipe.MinVelocity", 750.0f);
		controller.config().save();
	}


	/**
	 * Called when a new frame of hand and finger tracking data is available.
	 * Specifies instructions to be executed when frame is available.
	 */
	public void onFrame(Controller controller)
	{
		int i,j;

		Frame frame = controller.frame();
		if(frame.fingers().count()==0)
		{
			eplm.l.setText("Finger not detected");
			eplm.repaint();
		}

		else
		{
			eplm.l.setText("Finger detected");
			eplm.repaint();

		}


		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		for (Gesture gesture : frame.gestures())
		{

			if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
				SwipeGesture swipeGesture = new SwipeGesture(gesture);

				Vector swipeVector  = swipeGesture.direction();
				//System.out.println("swipeVector : " + swipeVector);

				float swipeDirectionX = swipeVector.getX();
				//System.out.println(swipeDirectionX);

				float swipeDirectionY = swipeVector.getY();
				//System.out.println(swipeDirectionY);

				if(swipeDirectionX>0.75)
				{
					if((eplm.epl.bi>=1)&&(eplm.epl.bi<=3)&&(eplm.epl.bj<=3)&&(eplm.epl.bj>=2))
					{
						j=eplm.epl.bj;
						j=j-1;
						eplm.epl=eplm.epl.move(eplm.epl.bi,j);
						eplm.refresh();
						if(eplm.epl.isGameWon)
						{
							eplm.l.setText("You Win");
							eplm.repaint();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							eplm.dispose();
							System.exit(0);
						}

					}


				}

				if(swipeDirectionX<-0.75)
				{
					if((eplm.epl.bi>=1)&&(eplm.epl.bi<=3)&&(eplm.epl.bj<=2)&&(eplm.epl.bj>=1))
					{
						j=eplm.epl.bj;
						j=j+1;
						eplm.epl=eplm.epl.move(eplm.epl.bi,j);
						eplm.refresh();
						if(eplm.epl.isGameWon)
						{
							eplm.l.setText("You Win");
							eplm.repaint();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							eplm.dispose();
							System.exit(0);
						}

					}

				}

				if(swipeDirectionY>0.75)
				{
					//System.out.println("up");
					if((eplm.epl.bi>=1)&&(eplm.epl.bi<=2)&&(eplm.epl.bj<=3)&&(eplm.epl.bj>=1))
					{
						i=eplm.epl.bi;
						i=i+1;
						eplm.epl=eplm.epl.move(i,eplm.epl.bj);
						eplm.refresh();
						if(eplm.epl.isGameWon)
						{
							eplm.l.setText("You Win");
							eplm.repaint();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							eplm.dispose();
							System.exit(0);
						}						


					}
				}

				if(swipeDirectionY<-0.75)
				{
					if((eplm.epl.bi>=2)&&(eplm.epl.bi<=3)&&(eplm.epl.bj<=3)&&(eplm.epl.bj>=1))
					{
						i=eplm.epl.bi;
						i=i-1;
						eplm.epl=eplm.epl.move(i,eplm.epl.bj);
						eplm.refresh();
						if(eplm.epl.isGameWon)
						{
							eplm.l.setText("You Win");
							eplm.repaint();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							eplm.dispose();
							System.exit(0);
						}

					}
				}
			}
		}
	}

}
