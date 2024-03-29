package adventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start implements ActionListener {
	private updateStatistics update;

	private JFrame startFrame;
	private JFrame instructionsFrame;

	private JButton instructionsButton;
	private JButton startButton;
	private JButton backButton;

	public Start(updateStatistics update) {
		this.update = update;
	}

	protected void startClass() {
		startFrame = new JFrame();
		JLabel startBackground = new JLabel();
		instructionsButton = new JButton("Instructions");
		startButton = new JButton("Start");

		ImageIcon signpost = new ImageIcon(getClass().getResource("/images/signpost.png"));
		startBackground.setIcon(signpost);

		instructionsButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		instructionsButton.setFocusable(false);
		instructionsButton.setBounds(250, 225, 120, 35);
		instructionsButton.addActionListener(this);

		startButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		startButton.setFocusable(false);
		startButton.setBounds(450, 225, 120, 35);
		startButton.addActionListener(this);

		startFrame.add(startButton);
		startFrame.add(instructionsButton);
		startFrame.add(startBackground);

		startFrame.setTitle("Decision Making Adventure");
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setResizable(false);
		startFrame.setSize(830, 375);
		startFrame.setVisible(true);
		startFrame.setLocationRelativeTo(null);
		startFrame.setBackground(Color.white);

	}

	protected void Instructions(String printInstructions) {
		JLabel instructionsLabel = new JLabel();
		backButton = new JButton("Back");
		instructionsFrame = new JFrame();

		instructionsLabel.setText(printInstructions);
		instructionsLabel.setBounds(20, -90, 500, 500);
		instructionsLabel.setFont(new Font("Calibri Regular", Font.PLAIN, 18));

		backButton.setFont(new Font("Calibri Regular", Font.BOLD, 12));
		backButton.setFocusable(false);
		backButton.setBounds(230, 375, 75, 35);
		backButton.addActionListener(this);

		instructionsFrame.setTitle("Instructions");
		instructionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instructionsFrame.setResizable(false);
		instructionsFrame.setSize(560, 500);
		instructionsFrame.setLayout(null);
		instructionsFrame.setVisible(true);
		instructionsFrame.setLocationRelativeTo(null);
		instructionsFrame.setBackground(Color.white);

		instructionsFrame.add(instructionsLabel);
		instructionsFrame.add(backButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == instructionsButton) {
			startFrame.dispose();
			Instructions instructions = new Instructions();
			instructions.printInstructions(this);
		}

		else if (e.getSource() == backButton) {
			instructionsFrame.dispose();
			startClass();
		}

		else if (e.getSource() == startButton) {
			startFrame.dispose();
			River river = new River(update);
			river.riverClass();
		}

	}

}
