package adventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class End implements ActionListener {
	private updateStatistics update;

	private JFrame endFrame = new JFrame();

	private JButton restartButton = new JButton("Restart");
	private JButton exitButton = new JButton("Exit");

	public End(updateStatistics update) {
		this.update = update;
	}

	private void makeFrame() {
		restartButton.setFocusable(false);
		exitButton.setFocusable(false);
		
		endFrame.setLayout(null);
		endFrame.setResizable(false);
		endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endFrame.setVisible(true);
		endFrame.setLocationRelativeTo(null);
		endFrame.setBackground(Color.white);

		endFrame.add(restartButton);
		endFrame.add(exitButton);
	}

	protected void berryEnd() {
		JLabel berryEndLabel = new JLabel();

		berryEndLabel.setText("<html>Congratulations! You have successfully made it through the <br/>"
				+ "Decision Making Adventure, by Skylar Phanenhour. <br/><br/>"

				+ "You almost got lost in the cave, but managed to find a way out. <br/>"
				+ "There happened to be an air balloon from a previous adventurer <br/>"
				+ "that you decide to take for a new journey home. <br/><br/>"

				+ "You have found 1 of 3 endings, the air balloon ending! <br/>"
				+ "There are some other endings that you can find with different choices! <br/><br/>"

				+ "The statistics that you finished with are the following: <br/>" + "Health: " + update.updateHealth
				+ "<br/>" + "Comfort: " + update.updateComfort + "<br/><br/>"

				+ "I hope that you enjoyed this project, that may have seemed short. <br/>"
				+ "(but took lots of planning, research and work!) <br/><br/>"

				+ "Would you like to play again? <html>");

		berryEndLabel.setBounds(20, -50, 550, 625);
		berryEndLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		restartButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		restartButton.setBounds(100, 525, 120, 35);
		restartButton.addActionListener(this);

		exitButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		exitButton.setBounds(300, 525, 120, 35);
		exitButton.addActionListener(this);

		endFrame.setTitle("'Air Balloon' Ending");
		endFrame.setSize(575, 650);
		makeFrame();

		endFrame.add(berryEndLabel);
	}

	protected void walkEnd() {
		JLabel lostEndLabel = new JLabel();

		lostEndLabel.setText("<html>Congratulations! You have successfully made it through the <br/>"
				+ "Decision Making Adventure, by Skylar Phanenhour. <br/><br/>"

				+ "You went into the cave, there were so many different paths to go through. <br/>"
				+ "You kept walking through the cave mindlessly, without remembering where to go. <br/>"
				+ "You managed to get lost and only found a cliff opening...<br/><br/>"

				+ "You have found 1 of 3 endings, the lost ending! <br/>"
				+ "There are some other endings that you can find with different choices! <br/><br/>"

				+ "The statistics that you finished with are the following: <br/>" + "Health: " + update.updateHealth
				+ "<br/>" + "Comfort: " + update.updateComfort + "<br/><br/>"

				+ "I hope that you enjoyed this project, that may have seemed short. <br/>"
				+ "(but took lots of planning, research and work!) <br/><br/>"

				+ "Would you like to play again? <html>");

		lostEndLabel.setBounds(20, -90, 650, 625);
		lostEndLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		restartButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		restartButton.setBounds(150, 470, 120, 35);
		restartButton.addActionListener(this);

		exitButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		exitButton.setBounds(400, 470, 120, 35);
		exitButton.addActionListener(this);

		endFrame.setTitle("'Lost' Ending");
		endFrame.setSize(700, 575);
		makeFrame();

		endFrame.add(lostEndLabel);
	}

	protected void fightEnd() {
		JLabel fightEndLabel = new JLabel();

		fightEndLabel.setText("<html>Congratulations! You have successfully made it through the <br/>"
				+ "Decision Making Adventure, by Skylar Phanenhour. <br/><br/>"

				+ "You didn't go far into the cave, your wounds from the wolf were worsening.<br/>"
				+ "You decided to set up a campsite inside the cave to rest.<br/>"
				+ "You were starting to get hungry so your last decision was to cook the wolf meat.<br/><br/>"

				+ "You have found 1 of 3 endings, the lost ending! <br/>"
				+ "There are some other endings that you can find with different choices! <br/><br/>"

				+ "The statistics that you finished with are the following: <br/>" + "Health: " + update.updateHealth
				+ "<br/>" + "Comfort: " + update.updateComfort + "<br/><br/>"

				+ "I hope that you enjoyed this project, that may have seemed short. <br/>"
				+ "(but took lots of planning, research and work!) <br/><br/>"

				+ "Would you like to play again? <html>");

		fightEndLabel.setBounds(20, -90, 650, 625);
		fightEndLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		restartButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		restartButton.setBounds(150, 470, 120, 35);
		restartButton.addActionListener(this);

		exitButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		exitButton.setBounds(400, 470, 120, 35);
		exitButton.addActionListener(this);

		endFrame.setTitle("'Campfire' Ending");
		endFrame.setSize(700, 575);
		makeFrame();

		endFrame.add(fightEndLabel);
	}

	protected void runEnd() {
		JLabel lostEndLabel = new JLabel();

		lostEndLabel.setText("<html>Congratulations! You have successfully made it through the <br/>"
				+ "Decision Making Adventure, by Skylar Phanenhour. <br/><br/>"

				+ "You went into the cave, there were so many different paths to go through. <br/>"
				+ "You kept walking through the cave mindlessly, without remembering where to go. <br/>"
				+ "You managed to get lost and only found a cliff opening...<br/><br/>"

				+ "You have found 1 of 3 endings, the lost ending! <br/>"
				+ "There are some other endings that you can find with different choices! <br/><br/>"

				+ "The statistics that you finished with are the following: <br/>" + "Health: " + update.updateHealth
				+ "<br/>" + "Comfort: " + update.updateComfort + "<br/><br/>"

				+ "I hope that you enjoyed this project, that may have seemed short. <br/>"
				+ "(but took lots of planning, research and work!) <br/><br/>"

				+ "Would you like to play again? <html>");

		lostEndLabel.setBounds(20, -90, 650, 625);
		lostEndLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		restartButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		restartButton.setBounds(150, 470, 120, 35);
		restartButton.addActionListener(this);

		exitButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		exitButton.setBounds(400, 470, 120, 35);
		exitButton.addActionListener(this);

		endFrame.setTitle("'Lost' Ending");
		endFrame.setSize(700, 575);
		makeFrame();

		endFrame.add(lostEndLabel);
	}

	protected void gameOver() {
		update.overviewFrame.dispose();
		JLabel gameOverLabel = new JLabel();
		JLabel titleLabel = new JLabel();

		titleLabel.setText("Game Over!");
		titleLabel.setBounds(135, 10, 300, 100);
		titleLabel.setFont(new Font("Calibri Regular", Font.BOLD, 36));

		gameOverLabel.setText("<html>Unfortunately you were not able to successfully make it<br/>"
				+ "to the end of the game... <br/><br/>"

				+ "Better luck next time!<br/><br/>"

				+ "Would you like to play again? <html>");

		gameOverLabel.setBounds(20, -100, 650, 625);
		gameOverLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		restartButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		restartButton.setBounds(85, 325, 120, 35);
		restartButton.addActionListener(this);

		exitButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		exitButton.setBounds(275, 325, 120, 35);
		exitButton.addActionListener(this);

		endFrame.setTitle("Game Over!");
		endFrame.setSize(500, 450);
		makeFrame();

		endFrame.add(titleLabel);
		endFrame.add(gameOverLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restartButton) {
			endFrame.dispose();
			DecisionMakingAdventure.main(null);
		}

		else if (e.getSource() == exitButton) {
			endFrame.dispose();
			System.exit(0);
		}
	}

}
