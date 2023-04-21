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

public class Forest implements ActionListener{
	private JPanel blackPanel = new JPanel();
	private JFrame forestFrame = new JFrame();
	private JLabel forestBackground = new JLabel();
	private ImageIcon forest = new ImageIcon("forest_background.jpg");
	
	private JLabel hikerLabel = new JLabel();
	private ImageIcon hiker = new ImageIcon("hiker.png");
	
	//Go around option
	private JButton fightButton;
	private JButton runAwayButton;
	
	//Cross river option
	private JButton berryButton;
	private JButton walkButton;
	
	updateStatistics update;
	
	public Forest(updateStatistics update) {
		this.update = update;
	}
	
	protected void goAroundOption() {
		fightButton = new JButton("Fight Wolf");
		runAwayButton = new JButton("Run Away");
		
		JLabel wolfLabel = new JLabel();
		ImageIcon wolf = new ImageIcon("wolf.png");
		wolfLabel.setIcon(wolf);
		wolfLabel.setBounds(550, 250, 101, 113);
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(225, 225, 119, 200);
		
		fightButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		fightButton.setBounds(200, 100, 100, 35);
		fightButton.setFocusable(false);
		fightButton.addActionListener(this);
		
		
		runAwayButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		runAwayButton.setFocusable(false);
		runAwayButton.addActionListener(this);
		runAwayButton.setBounds(500, 100, 100, 35);
		
		
		blackPanel.setBounds(0, 75, 800, 85);
		blackPanel.setBackground(Color.black);
		
		forestBackground.setIcon(forest);

		forestFrame.add(wolfLabel);
		forestFrame.add(hikerLabel);
		forestFrame.add(fightButton);
		forestFrame.add(runAwayButton);
		forestFrame.add(blackPanel);
		forestFrame.add(forestBackground);
		forestFrame.setTitle("Forest");
		forestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forestFrame.setResizable(false);
		forestFrame.setVisible(true);
		forestFrame.pack();
		forestFrame.setLocationRelativeTo(null);
		
	}
	

	protected void crossRiverOption() {
		berryButton = new JButton("Eat Berries");
		walkButton = new JButton("Keep Walking");
		JLabel berryLabel = new JLabel();
		ImageIcon berryBush = new ImageIcon("berry_bush.png");
		berryLabel.setIcon(berryBush);
		berryLabel.setBounds(450, 290, 100, 60);
		
		
		hikerLabel.setIcon(hiker);
		hikerLabel.setBounds(225, 225, 119, 200);
		
		berryButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		berryButton.setBounds(200, 100, 125, 35);
		berryButton.setFocusable(false);
		berryButton.addActionListener(this);
		
		
		walkButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		walkButton.setFocusable(false);
		walkButton.addActionListener(this);
		walkButton.setBounds(500, 100, 125, 35);
		
		
		blackPanel.setBounds(0, 75, 800, 85);
		blackPanel.setBackground(Color.black);
		
		forestBackground.setIcon(forest);

		
		forestFrame.add(berryLabel);
		forestFrame.add(hikerLabel);
		forestFrame.add(berryButton);
		forestFrame.add(walkButton);
		forestFrame.add(blackPanel);
		forestFrame.add(forestBackground);
		forestFrame.setTitle("Forest");
		forestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forestFrame.setResizable(false);
		forestFrame.setVisible(true);
		forestFrame.pack();
		forestFrame.setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Timer timer = new Timer();
		TimerTask timerTask ;
		Mountain mountain = new Mountain(update);
		
		if(e.getSource()==fightButton) {
			forestFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						mountain.fightOption();
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
		
		
		if(e.getSource()==runAwayButton) {
			forestFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						mountain.runOption();
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
		
		
		
		if(e.getSource()==berryButton) {
			forestFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						mountain.berryOption();
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
		
		if(e.getSource()==walkButton) {
			forestFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						mountain.walkOption();
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