import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cave {

	private JFrame caveFrame = new JFrame();
	private Timer timer = new Timer();
	private End end;
	
	private JLabel airBalloonBackground = new JLabel();
	private ImageIcon balloon = new ImageIcon("cave_exit_background.jpg");
	
	
	private JLabel lookoutBackground = new JLabel();
	private ImageIcon lookout = new ImageIcon("cave_exit_lookout_background.jpg");
	
	
	private JLabel campfireBackground = new JLabel();
	private ImageIcon campfire = new ImageIcon("cave_campfire_background.jpg");
	
	private updateStatistics update;
	
	public Cave(updateStatistics update) {
		this.update = update;
	}


	protected void berryOption() {
		end = new End(update);
		airBalloonBackground.setIcon(balloon);
		
		caveFrame.add(airBalloonBackground);
		caveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caveFrame.setResizable(false);
		caveFrame.setTitle("Cave");
		caveFrame.setVisible(true);
		caveFrame.pack();
		caveFrame.setLocationRelativeTo(null);

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				caveFrame.dispose();
				end.berryEnd();
			}
			
		};

		timer.schedule(timerTask, 2000);
	}
	
	protected void walkOption() {
		end = new End(update);
		lookoutBackground.setIcon(lookout);
		
		caveFrame.add(lookoutBackground);
		caveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caveFrame.setResizable(false);
		caveFrame.setTitle("Cave");
		caveFrame.setVisible(true);
		caveFrame.pack();
		caveFrame.setLocationRelativeTo(null);

		
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				caveFrame.dispose();
				end.walkEnd();
			}
			
		};

		timer.schedule(timerTask, 2000);
	}
	
	protected void fightOption() {
		end = new End(update);
		campfireBackground.setIcon(campfire);
		
		caveFrame.add(campfireBackground);
		caveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caveFrame.setResizable(false);
		caveFrame.setTitle("Cave");
		caveFrame.setVisible(true);
		caveFrame.pack();
		caveFrame.setLocationRelativeTo(null);

		
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				caveFrame.dispose();
				end.fightEnd();
			}
			
		};

		timer.schedule(timerTask, 2000);
	}
	
	protected void runOption() {
		end = new End(update);
		lookoutBackground.setIcon(lookout);
		
		caveFrame.add(lookoutBackground);
		caveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caveFrame.setResizable(false);
		caveFrame.setTitle("Cave");
		caveFrame.setVisible(true);
		caveFrame.pack();
		caveFrame.setLocationRelativeTo(null);

		
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				caveFrame.dispose();
				end.runEnd();
			}
			
		};

		timer.schedule(timerTask, 2000);
	}
}
