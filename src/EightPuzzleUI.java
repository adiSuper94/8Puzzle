import java.awt.*;
import java.awt.event.*;

public class EightPuzzleUI extends Frame implements ActionListener,KeyListener

{
	/**
	 * Necessary Variable and Object Declaration
	 */
	private static final long serialVersionUID = 1L;
	String s;

	int n=1;
	EightPuzzleLogic epl;

	Button b11,b22,b33,b12,b13,b21,b23,b31,b32;
	Label l;
	LeapLink leap;
	
	/**
	 * 
	 * @param ep
	 * UI Design
	 * Instantiation of LeapLink
	 *
	 */
	public EightPuzzleUI(EightPuzzleLogic ep)
	{
		super("8-Puzzle");
		epl = ep;

		b11 =new Button(""+epl.m[1][1]);
		b12 =new Button(""+epl.m[1][2]);
		b13 =new Button(""+epl.m[1][3]);
		b21 =new Button(""+epl.m[2][1]);
		b22 =new Button(""+epl.m[2][2]);
		b23 =new Button(""+epl.m[2][3]);
		b31 =new Button(""+epl.m[3][1]);
		b32 =new Button(""+epl.m[3][2]);
		b33 =new Button(""+epl.m[3][3]);
		l   =new Label("");

		b11.setEnabled(true);
		b12.setEnabled(true);
		b13.setEnabled(true);
		b21.setEnabled(true);
		b22.setEnabled(true);
		b23.setEnabled(true);
		b31.setEnabled(true);
		b32.setEnabled(true);
		b33.setEnabled(true);

		b11.setActionCommand("11");
		b12.setActionCommand("12");
		b13.setActionCommand("13");
		b21.setActionCommand("21");
		b22.setActionCommand("22");
		b23.setActionCommand("23");
		b31.setActionCommand("31");
		b32.setActionCommand("32");
		b33.setActionCommand("33");



		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b31.addActionListener(this);
		b32.addActionListener(this);
		b33.addActionListener(this);


		b11.addKeyListener(this);
		b12.addKeyListener(this);
		b13.addKeyListener(this);
		b21.addKeyListener(this);
		b22.addKeyListener(this);
		b23.addKeyListener(this);
		b31.addKeyListener(this);
		b32.addKeyListener(this);
		b33.addKeyListener(this);



		setLayout(new GridLayout(4,3));

		add(b11);
		add(b12);
		add(b13);
		add(b21);
		add(b22);
		add(b23);
		add(b31);
		add(b32);
		add(b33);
		add(l);
		
		leap = new LeapLink(this);

	}


	/**
	 * Sync between matrix m in EightPuzzleLogic and UI  
	 */
	public void refresh()
	{
		b11.setLabel(""+epl.m[1][1]);
		b12.setLabel(""+epl.m[1][2]);
		b13.setLabel(""+epl.m[1][3]);
		b21.setLabel(""+epl.m[2][1]);
		b22.setLabel(""+epl.m[2][2]);
		b23.setLabel(""+epl.m[2][3]);
		b31.setLabel(""+epl.m[3][1]);
		b32.setLabel(""+epl.m[3][2]);
		b33.setLabel(""+epl.m[3][3]);

	}

	
	/**
	 * Handling mouse click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

		this.repaint();
		if(s=="11")
		{
			//l.setText(s);
			epl=epl.move(1,1);
			this.refresh();
			this.repaint();
		}

		else if(s=="12")
		{
			//l.setText(s);
			epl=epl.move(1,2);
			this.refresh();
			this.repaint();
		}

		else if(s=="13")
		{
			//l.setText(s);
			epl=epl.move(1,3);
			this.refresh();
			this.repaint();
		}

		else if(s=="21")
		{
			//l.setText(s);
			epl=epl.move(2,1);
			this.refresh();
			this.repaint();
		}

		else if(s=="22")
		{
			//l.setText(s);
			epl=epl.move(2,2);
			this.refresh();
			this.repaint();
		}

		else if(s=="23")
		{
			//l.setText(s);
			epl=epl.move(2,3);
			this.refresh();
			this.repaint();
		}

		else if(s=="31")
		{
			//l.setText(s);
			epl=epl.move(3,1);
			this.refresh();
			this.repaint();
		}

		else if(s=="32")
		{
			//l.setText(s);
			epl=epl.move(3,2);
			this.refresh();
			this.repaint();
		}

		else if(s=="33")
		{
			//l.setText(s);
			epl=epl.move(3,3);
			this.refresh();
			this.repaint();
		}

		epl.winCheck();

		if(epl.isGameWon)
		{
			l.setText("You Win");
			repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			System.exit(0);
		}

	}

	/**
	 * Handling KeyEvents:UP,DOWN,LEFT and RIGHT
	 *
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int i,j;
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_UP:
			if((epl.bi>=1)&&(epl.bi<=2)&&(epl.bj<=3)&&(epl.bj>=1))
			{
				i=epl.bi;
				i=i+1;
				epl=epl.move(i,epl.bj);
				this.refresh();
				this.repaint();
			}
			break;
		case KeyEvent.VK_DOWN:
			if((epl.bi>=2)&&(epl.bi<=3)&&(epl.bj<=3)&&(epl.bj>=1))
			{
				i=epl.bi;
				i=i-1;
				epl=epl.move(i,epl.bj);
				this.refresh();
				this.repaint();
			}
			break;
		case KeyEvent.VK_LEFT:
			if((epl.bi>=1)&&(epl.bi<=3)&&(epl.bj<=2)&&(epl.bj>=1))
			{
				j=epl.bj;
				j=j+1;
				epl=epl.move(epl.bi,j);
				this.refresh();
				this.repaint();
			}
			break;
		case KeyEvent.VK_RIGHT :
			if((epl.bi>=1)&&(epl.bi<=3)&&(epl.bj<=3)&&(epl.bj>=2))
			{
				j=epl.bj;
				j=j-1;
				epl=epl.move(epl.bi,j);
				this.refresh();
				this.repaint();
			}
			break;
		}
		
		if(epl.isGameWon)
		{
			l.setText("You Win");
			repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			System.exit(0);
		}

	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}