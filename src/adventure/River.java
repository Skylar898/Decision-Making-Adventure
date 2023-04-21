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

public class River implements ActionListener{
	
	private JFrame riverFrame;
	private JButton goAroundButton;
	private JButton crossRiverButton;
	
	private updateStatistics update;
	
	private JLabel hikerLabel = new JLabel();
	private ImageIcon hiker = new ImageIcon(getClass().getResource("/images/hiker.png"));

	
	public River(updateStatistics update) {
		this.update = update;
	}
	
	protected void riverClass() {
		riverFrame = new JFrame();
		JLabel riverBackground = new JLabel();
		goAroundButton = new JButton("Go Around");
		crossRiverButton = new JButton("Cross River");
		JPanel blackPanel = new JPanel();
		hikerLabel.setIcon(hiker);
		
		hikerLabel.setBounds(100, 200, 119, 200);
		
		ImageIcon river = new ImageIcon(getClass().getResource("/images/river_background.jpg"));
		riverBackground.setIcon(river);
		
		goAroundButton.setFocusable(false);
		goAroundButton.setBounds(200, 100, 100, 35);
		goAroundButton.setFont(new Font("Calibri Regular",Font.BOLD,12)); 
		goAroundButton.addActionListener(this);
		
		
		crossRiverButton.setFocusable(false);
		crossRiverButton.setBounds(500, 100, 100, 35);
		crossRiverButton.setFont(new Font("Calibri Regular",Font.BOLD,12));
		crossRiverButton.addActionListener(this);
		
		
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
		Timer timer = new Timer();
		TimerTask timerTask ;
		Forest forest = new Forest(update);
		
		if(e.getSource()==goAroundButton) {
			riverFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						forest.goAroundOption();
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
		
		
		if(e.getSource()==crossRiverButton) {
			riverFrame.dispose();
			update.statistics();
			update.stageOverview();
			
			if(update.updateHealth > 0 && update.updateComfort > 0) {
				timerTask = new TimerTask() {
					@Override
					public void run() {
						update.overviewFrame.dispose();
						forest.crossRiverOption();
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