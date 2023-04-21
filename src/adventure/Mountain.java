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

public class Mountain implements ActionListener {
	private updateStatistics update;

	private Timer timer = new Timer();
	private TimerTask timerTask;

	private JFrame mountainFrame = new JFrame();

	private JButton berryCaveButton;
	private JButton walkCaveButton;
	private JButton fightCaveButton;
	private JButton runCaveButton;


	public Mountain(updateStatistics update) {
		this.update = update;
	}

	private void makeFrame() {
		JLabel hikerLabel = new JLabel();
		ImageIcon hiker = new ImageIcon(getClass().getResource("/images/hiker.png"));
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(475, 80, 119, 200);
		
		JLabel mountainBackground = new JLabel();
		ImageIcon mountain = new ImageIcon(getClass().getResource("/images/mountain_background.jpg"));
		mountainBackground.setIcon(mountain);
		
		JPanel blackPanel = new JPanel();
		blackPanel.setBounds(0, 25, 500, 85);
		blackPanel.setBackground(Color.black);
		
		mountainFrame.add(hikerLabel);
		mountainFrame.add(blackPanel);
		mountainFrame.add(mountainBackground);
		
		mountainFrame.setTitle("Mountain");
		mountainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mountainFrame.setResizable(false);
		mountainFrame.setVisible(true);
		mountainFrame.pack();
		mountainFrame.setLocationRelativeTo(null);
	}

	private void nextLevel(String choice) {
		mountainFrame.dispose();
		update.statistics();
		update.stageOverview();
		
		timerTask = new TimerTask() {

			@Override
			public void run() {
				if (update.updateHealth > 0 && update.updateComfort > 0) {
					Cave cave = new Cave(update);

					switch (choice) {
					case "Berry":
						update.overviewFrame.dispose();
						cave.berryOption();
						break;

					case "Walk":
						update.overviewFrame.dispose();
						cave.walkOption();
						break;

					case "Fight":
						update.overviewFrame.dispose();
						cave.fightOption();
						break;

					case "Run":
						update.overviewFrame.dispose();
						cave.runOption();
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

	protected void berryOption() {
		berryCaveButton = new JButton("Enter Cave");

		berryCaveButton.setFocusable(false);
		berryCaveButton.setBounds(175, 50, 125, 35);
		berryCaveButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		berryCaveButton.addActionListener(this);

		mountainFrame.add(berryCaveButton);

		makeFrame();
	}

	protected void walkOption() {
		walkCaveButton = new JButton("Enter Cave");

		walkCaveButton.setFocusable(false);
		walkCaveButton.setBounds(175, 50, 125, 35);
		walkCaveButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		walkCaveButton.addActionListener(this);

		mountainFrame.add(walkCaveButton);
		makeFrame();
	}

	protected void fightOption() {
		fightCaveButton = new JButton("Enter Cave");

		fightCaveButton.setFocusable(false);
		fightCaveButton.setBounds(175, 50, 125, 35);
		fightCaveButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		fightCaveButton.addActionListener(this);

		mountainFrame.add(fightCaveButton);
		makeFrame();
	}

	protected void runOption() {
		runCaveButton = new JButton("Enter Cave");

		runCaveButton.setFocusable(false);
		runCaveButton.setBounds(175, 50, 125, 35);
		runCaveButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		runCaveButton.addActionListener(this);

		mountainFrame.add(runCaveButton);
		makeFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == fightCaveButton) {
			nextLevel("Fight");
		}

		if (e.getSource() == runCaveButton) {
			nextLevel("Run");
		}

		if (e.getSource() == berryCaveButton) {
			nextLevel("Berry");
		}

		if (e.getSource() == walkCaveButton) {
			nextLevel("Walk");
		}

	}

}
