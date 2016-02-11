package problem.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import problem.asm.DesignParser;

@SuppressWarnings("serial")
public class RunPanel extends JPanel {

	public RunPanel(String[] args) {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel taskLabel = new JLabel();
		taskLabel.setText("FIXME: Will Change");
		JProgressBar loadingBar = new JProgressBar();
		
		JButton loadButton = new JButton("Load Config");
		JButton analyzeButton = new JButton("Analyze");
		loadButton.addActionListener(new load());
		analyzeButton.addActionListener(new analyze(args, loadingBar, taskLabel));
		
		c.gridx = 0; c.gridy = 0; c.insets = new Insets(0,0,30,20);
		this.add(loadButton, c);
		c.gridx = 1; c.gridy = 0;
		this.add(analyzeButton, c);
		c.gridx = 0; c.gridy = 1; c.gridwidth = 2; c.insets = new Insets(0,0,10,20);
		this.add(taskLabel, c);
		c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
		this.add(loadingBar, c);
	}
	
	private class load implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("load");
		}
	}
	
	private class analyze implements ActionListener{
		private String[] args;
		private JProgressBar loading;
		private JLabel task;
		
		public analyze(String[] args, JProgressBar load, JLabel task){
			this.args = args;
			this.loading = load;
			this.task = task;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					DesignParser parser = new DesignParser();
					try {
						System.out.println("Analyzing");
						parser.parse(args, loading, task);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			t.start();

		}
		
	}
	
	

}
