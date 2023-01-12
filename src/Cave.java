import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cave {

	JFrame caveFrame = new JFrame();
	Timer timer = new Timer();
	End end;
	
	JLabel airBalloonBackground = new JLabel();
	ImageIcon balloon = new ImageIcon("cave_exit_background.jpg");
	
	
	JLabel lookoutBackground = new JLabel();
	ImageIcon lookout = new ImageIcon("cave_exit_lookout_background.jpg");
	
	
	JLabel campfireBackground = new JLabel();
	ImageIcon campfire = new ImageIcon("cave_campfire_background.jpg");
	
	updateStatistics update;
	
	public Cave(updateStatistics update) {
		this.update = update;
	}


	public void berryOption() {
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
	
	public void walkOption() {
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
	
	public void fightOption() {
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
	
	public void runOption() {
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
