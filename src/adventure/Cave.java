package adventure;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cave {
	private updateStatistics update;

	private JFrame caveFrame = new JFrame();

	private Timer timer = new Timer();
	private TimerTask timerTask;

	private JLabel airBalloonBackground = new JLabel();
	private JLabel campfireBackground = new JLabel();
	private JLabel lookoutBackground = new JLabel();

	private ImageIcon lookout = new ImageIcon(getClass().getResource("/images/cave_exit_lookout_background.jpg"));

	public Cave(updateStatistics update) {
		this.update = update;
	}

	protected void makeFrame() {
		caveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caveFrame.setResizable(false);
		caveFrame.setTitle("Cave");
		caveFrame.setVisible(true);
		caveFrame.pack();
		caveFrame.setLocationRelativeTo(null);
	}

	protected void nextLevel(String choice) {
		End end = new End(update);

		timerTask = new TimerTask() {

			@Override
			public void run() {
				caveFrame.dispose();

				switch (choice) {
				case "Berry":
					end.berryEnd();
					break;

				case "Walk":
					end.walkEnd();
					break;

				case "Fight":
					end.fightEnd();
					break;

				case "Run":
					end.runEnd();
					break;

				default:
					break;
				}
			}
		};

		timer.schedule(timerTask, 2000);
	}

	protected void berryOption() {
		ImageIcon balloon = new ImageIcon(getClass().getResource("/images/cave_exit_background.jpg"));
		airBalloonBackground.setIcon(balloon);

		caveFrame.add(airBalloonBackground);
		makeFrame();
		nextLevel("Berry");
	}

	protected void walkOption() {
		lookoutBackground.setIcon(lookout);

		caveFrame.add(lookoutBackground);
		makeFrame();
		nextLevel("Walk");
	}

	protected void fightOption() {
		ImageIcon campfire = new ImageIcon(getClass().getResource("/images/cave_campfire_background.jpg"));
		campfireBackground.setIcon(campfire);

		caveFrame.add(campfireBackground);
		makeFrame();
		nextLevel("Fight");
	}

	protected void runOption() {
		lookoutBackground.setIcon(lookout);

		caveFrame.add(lookoutBackground);
		makeFrame();
		nextLevel("Run");
	}
}
