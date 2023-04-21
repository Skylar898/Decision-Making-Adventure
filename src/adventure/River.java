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

public class River implements ActionListener {
	private updateStatistics update;

	private Timer timer = new Timer();
	private TimerTask timerTask;

	private JFrame riverFrame;

	private JButton goAroundButton = new JButton("Go Around");
	private JButton crossRiverButton = new JButton("Cross River");

	public River(updateStatistics update) {
		this.update = update;
	}

	private void nextLevel(String choice) {
		riverFrame.dispose();
		update.statistics();
		update.stageOverview();

		timerTask = new TimerTask() {

			@Override
			public void run() {
				if (update.updateHealth > 0 && update.updateComfort > 0) {
					Forest forest = new Forest(update);

					switch (choice) {
					case "Around":
						update.overviewFrame.dispose();
						forest.goAroundOption();
						break;

					case "Cross":
						update.overviewFrame.dispose();
						forest.crossRiverOption();
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

	protected void riverClass() {
		riverFrame = new JFrame();

		JLabel hikerLabel = new JLabel();
		ImageIcon hiker = new ImageIcon(getClass().getResource("/images/hiker.png"));
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(100, 200, 119, 200);

		JLabel riverBackground = new JLabel();
		ImageIcon river = new ImageIcon(getClass().getResource("/images/river_background.jpg"));
		riverBackground.setIcon(river);

		goAroundButton.setBounds(200, 100, 100, 35);
		goAroundButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		goAroundButton.setFocusable(false);
		goAroundButton.addActionListener(this);

		crossRiverButton.setBounds(500, 100, 100, 35);
		crossRiverButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		crossRiverButton.setFocusable(false);
		crossRiverButton.addActionListener(this);

		JPanel blackPanel = new JPanel();
		blackPanel.setBounds(0, 75, 800, 85);
		blackPanel.setBackground(Color.black);

		riverFrame.add(hikerLabel);
		riverFrame.add(goAroundButton);
		riverFrame.add(crossRiverButton);
		riverFrame.add(blackPanel);
		riverFrame.add(riverBackground);

		riverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		riverFrame.setTitle("River");
		riverFrame.setVisible(true);
		riverFrame.setResizable(false);
		riverFrame.pack();
		riverFrame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == goAroundButton) {
			nextLevel("Around");
		}

		else if (e.getSource() == crossRiverButton) {
			nextLevel("Cross");
		}
	}
}