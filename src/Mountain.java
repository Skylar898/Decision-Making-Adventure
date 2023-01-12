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
	
	JFrame mountainFrame = new JFrame();
	JLabel mountainBackground = new JLabel();
	ImageIcon mountain = new ImageIcon("mountain_background.jpg");
	JPanel blackPanel = new JPanel();
	
	JLabel hikerLabel = new JLabel();
	ImageIcon hiker = new ImageIcon("hiker.png");
	
	JButton berryCaveButton;
	JButton walkCaveButton;
	JButton fightCaveButton;
	JButton runCaveButton;
	
	updateStatistics update;
	
	public Mountain(updateStatistics update) {
		this.update = update;
	}
	
	public void berryOption() {
		berryCaveButton = new JButton("Enter Cave");
		
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(475, 80, 119, 200);
		
		berryCaveButton.setFocusable(false);
		berryCaveButton.setBounds(175, 50, 125, 35);
		berryCaveButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		berryCaveButton.addActionListener(this);
		
		
		blackPanel.setBounds(0, 25, 500, 85);
		blackPanel.setBackground(Color.black);
		
		mountainBackground.setIcon(mountain);
		
		mountainFrame.add(hikerLabel);
		mountainFrame.add(berryCaveButton);
		mountainFrame.add(blackPanel);
		mountainFrame.add(mountainBackground);
		mountainFrame.setTitle("Mountain");
		mountainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mountainFrame.setResizable(false);
		mountainFrame.setVisible(true);
		mountainFrame.pack();
		mountainFrame.setLocationRelativeTo(null);
	}
	
	public void walkOption() {
		walkCaveButton = new JButton("Enter Cave");
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(475, 80, 119, 200);
		
		walkCaveButton.setFocusable(false);
		walkCaveButton.setBounds(175, 50, 125, 35);
		walkCaveButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		walkCaveButton.addActionListener(this);
		
		blackPanel.setBounds(0, 25, 500, 85);
		blackPanel.setBackground(Color.black);
		
		mountainBackground.setIcon(mountain);

		mountainFrame.add(hikerLabel);
		mountainFrame.add(walkCaveButton);
		mountainFrame.add(blackPanel);
		mountainFrame.add(mountainBackground);
		mountainFrame.setTitle("Mountain");
		mountainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mountainFrame.setResizable(false);
		mountainFrame.setVisible(true);
		mountainFrame.pack();
		mountainFrame.setLocationRelativeTo(null);
	}
	
	public void fightOption() {		
		fightCaveButton = new JButton("Enter Cave");
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(475, 80, 119, 200);
		
		fightCaveButton.setFocusable(false);
		fightCaveButton.setBounds(175, 50, 125, 35);
		fightCaveButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		fightCaveButton.addActionListener(this);
		
		blackPanel.setBounds(0, 25, 500, 85);
		blackPanel.setBackground(Color.black);
		
		mountainBackground.setIcon(mountain);
		
		mountainFrame.add(hikerLabel);
		mountainFrame.add(fightCaveButton);
		mountainFrame.add(blackPanel);
		mountainFrame.add(mountainBackground);
		mountainFrame.setTitle("Mountain");
		mountainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mountainFrame.setResizable(false);
		mountainFrame.setVisible(true);
		mountainFrame.pack();
		mountainFrame.setLocationRelativeTo(null);
	}
	
	public void runOption() {
		runCaveButton = new JButton("Enter Cave");
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(475, 80, 119, 200);
		
		runCaveButton.setFocusable(false);
		runCaveButton.setBounds(175, 50, 125, 35);
		runCaveButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		runCaveButton.addActionListener(this);
		
		blackPanel.setBounds(0, 25, 500, 85);
		blackPanel.setBackground(Color.black);
		
		mountainBackground.setIcon(mountain);
		
		mountainFrame.add(hikerLabel);
		mountainFrame.add(runCaveButton);
		mountainFrame.add(blackPanel);
		mountainFrame.add(mountainBackground);
		mountainFrame.setTitle("Mountain");
		mountainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mountainFrame.setResizable(false);
		mountainFrame.setVisible(true);
		mountainFrame.pack();
		mountainFrame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Timer timer = new Timer();
		TimerTask timerTask ;
		Cave cave = new Cave(update);
		
		if(e.getSource()==fightCaveButton) {
			mountainFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						cave.fightOption();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
			else if (update.updateHealth <= 0 || update.updateComfort <= 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						End end = new End(update);
						end.gameOver();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
		}	
		
		
		if(e.getSource()==runCaveButton) {
			mountainFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						cave.runOption();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
			else if (update.updateHealth <= 0 || update.updateComfort <= 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						End end = new End(update);
						end.gameOver();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
		}
		
		
		
		if(e.getSource()==berryCaveButton) {
			mountainFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						cave.berryOption();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
			else if (update.updateHealth <= 0 || update.updateComfort <= 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						End end = new End(update);
						end.gameOver();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
		}
		
		if(e.getSource()==walkCaveButton) {
			mountainFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						cave.walkOption();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
			else if (update.updateHealth <= 0 || update.updateComfort <= 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						End end = new End(update);
						end.gameOver();
					}
					
				};
				
				timer.schedule(timerTask, 2000);
			}
		}
		
	}


}
