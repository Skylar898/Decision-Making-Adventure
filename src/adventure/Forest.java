package adventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Forest implements ActionListener {
	private updateStatistics update;

	private Timer timer = new Timer();
	private TimerTask timerTask;
	
	private JFrame forestFrame = new JFrame();

	private JButton fightButton;
	private JButton runAwayButton;
	private JButton berryButton;
	private JButton walkButton;

	public Forest(updateStatistics update) {
		this.update = update;
	}

	private void makeFrame() {
		JLabel hikerLabel = new JLabel();
		ImageIcon hiker = new ImageIcon(getClass().getResource("/images/hiker.png"));
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(225, 225, 119, 200);

		JLabel forestBackground = new JLabel();
		ImageIcon forest = new ImageIcon(getClass().getResource("/images/mountain_background.jpg"));
		forestBackground.setIcon(forest);

		JPanel blackPanel = new JPanel();
		blackPanel.setBounds(0, 75, 800, 85);
		blackPanel.setBackground(Color.black);

		forestFrame.add(hikerLabel);
		forestFrame.add(blackPanel);
		forestFrame.add(forestBackground);

		forestFrame.setTitle("Forest");
		forestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forestFrame.setResizable(false);
		forestFrame.setVisible(true);
		forestFrame.pack();
		forestFrame.setLocationRelativeTo(null);
	}

	private void nextLevel(String choice) {
		forestFrame.dispose();
		update.statistics();
		update.stageOverview();

		timerTask = new TimerTask() {

			@Override
			public void run() {
				if (update.updateHealth > 0 && update.updateComfort > 0) {
					Mountain mountain = new Mountain(update);

					switch (choice) {
					case "Berry":
						update.overviewFrame.dispose();
						mountain.berryOption();
						break;

					case "Walk":
						update.overviewFrame.dispose();
						mountain.walkOption();
						break;

					case "Fight":
						update.overviewFrame.dispose();
						mountain.fightOption();
						break;

					case "Run":
						update.overviewFrame.dispose();
						mountain.runOption();
						break;

					default:
						break;
					}

				} else if (update.updateHealth <= 0 || update.updateComfort <= 0) {
					End end = new End(update);
					end.gameOver();
				}
			}
		};

		timer.schedule(timerTask, 2000);
	}

	protected void goAroundOption() {
		fightButton = new JButton("Fight Wolf");
		runAwayButton = new JButton("Run Away");

		JLabel wolfLabel = new JLabel();
		ImageIcon wolf = new ImageIcon(getClass().getResource("/images/wolf.png"));
		wolfLabel.setIcon(wolf);
		wolfLabel.setBounds(550, 250, 101, 113);

		fightButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		fightButton.setBounds(200, 100, 100, 35);
		fightButton.addActionListener(this);

		runAwayButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		runAwayButton.addActionListener(this);
		runAwayButton.setBounds(500, 100, 100, 35);

		forestFrame.add(wolfLabel);
		forestFrame.add(fightButton);
		forestFrame.add(runAwayButton);
		makeFrame();
	}

	protected void crossRiverOption() {
		berryButton = new JButton("Eat Berries");
		walkButton = new JButton("Keep Walking");

		JLabel berryLabel = new JLabel();
		ImageIcon berryBush = new ImageIcon(getClass().getResource("/images/berry_bush.png"));
		berryLabel.setIcon(berryBush);
		berryLabel.setBounds(450, 290, 100, 60);

		berryButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		berryButton.setBounds(200, 100, 125, 35);
		berryButton.addActionListener(this);

		walkButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		walkButton.addActionListener(this);
		walkButton.setBounds(500, 100, 125, 35);

		forestFrame.add(berryLabel);
		forestFrame.add(berryButton);
		forestFrame.add(walkButton);
		makeFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == fightButton) {
			nextLevel("Fight");
		}

		else if (e.getSource() == runAwayButton) {
			nextLevel("Run");
		}

		else if (e.getSource() == berryButton) {
			nextLevel("Berry");
		}

		else if (e.getSource() == walkButton) {
			nextLevel("Walk");
		}

	}

}