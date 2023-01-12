import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class updateStatistics implements Statistics {
	
	JFrame overviewFrame;
	JLabel overviewLabel;

	int statUpdate;
	int updateHealth = Statistics.HEALTH;
	int updateComfort = Statistics.COMFORT;

	public updateStatistics() {

	}
	
	public updateStatistics(int updateComfort, int updateHealth) {
		this.updateComfort = updateComfort;
		this.updateHealth = updateHealth;
	}

	public void statistics() {
		Random randomNum = new Random();
		overviewLabel = new JLabel();


		int choice = randomNum.nextInt(2)+1;

		if (choice == 1) {
			statUpdate = randomNum.nextInt(3)+1;
			
			switch (statUpdate) {
				case 1:
					statUpdate = statUpdate + 2;
					updateHealth = updateHealth - statUpdate;

					overviewLabel.setText("You don't feel so good... you lost 3 health");
					break;
					
				case 2:
					statUpdate = statUpdate + 2;
					updateHealth = updateHealth - statUpdate;

					overviewLabel.setText("You tripped on a rock along the way and lost 4 health...");
					break;
					
				case 3:
					statUpdate = statUpdate + 2;
					updateHealth = updateHealth - statUpdate;

					overviewLabel.setText("An animal bit you and ran away and lost 5 health... Ouch!");
					break;
					
				default:
					break;
			}
		}
		
		else if (choice == 2) {
			statUpdate = randomNum.nextInt(3)+1;

			switch (statUpdate) {
					case 1:
						statUpdate = statUpdate + 2;
						updateComfort = updateComfort - statUpdate;

						overviewLabel.setText("You are starting to feel home sick... -3 comfort");
						break;
						
					case 2:
						statUpdate = statUpdate + 2;
						updateComfort = updateComfort - statUpdate;

						overviewLabel.setText("You start to feel like something is watching you... -4 comfort");
						break;
						
					case 3:
						statUpdate = statUpdate + 2;
						updateComfort = updateComfort - statUpdate;

						overviewLabel.setText("The weather is getting to you... -5 comfort");
						break;
						
					default:
						break;
				}
		}
				
	}
	
	public void stageOverview() {		
		JLabel healthOutput = new JLabel();
		JLabel comfortOutput = new JLabel();
		overviewFrame = new JFrame();
		
		
		
		overviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		overviewLabel.setVerticalAlignment(SwingConstants.CENTER);
		overviewLabel.setFont(new Font("Calibri Regular",Font.PLAIN,18));
		overviewLabel.setForeground(Color.white);
			
		healthOutput.setText("Health: " +  updateHealth);
		healthOutput.setFont(new Font("Calibri Regular",Font.PLAIN,18));
		healthOutput.setForeground(Color.white);
		healthOutput.setBounds(200, 250, 100, 50);
		
		
		comfortOutput.setText("comfort: " +  updateComfort);
		comfortOutput.setFont(new Font("Calibri Regular",Font.PLAIN,18));
		comfortOutput.setForeground(Color.white);
		comfortOutput.setBounds(500, 250, 100, 50);
		
		overviewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overviewFrame.setTitle("Stage Overview");
		overviewFrame.setVisible(true);
		overviewFrame.setResizable(false);
		overviewFrame.setSize(800,400);
		overviewFrame.getContentPane().setBackground(Color.black);
		overviewFrame.add(healthOutput);
		overviewFrame.add(comfortOutput);
		overviewFrame.add(overviewLabel);
		overviewFrame.setLocationRelativeTo(null);
	}
	

	
}