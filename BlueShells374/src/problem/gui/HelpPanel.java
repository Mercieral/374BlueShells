package problem.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{

	private static final long serialVersionUID = 2L;
	private JFrame mainMenuFrame;
	private String[] args;
	
	public HelpPanel(JFrame mainMenuFrame, String[] args){
		this.mainMenuFrame = mainMenuFrame;
		this.args = args;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20, 20, 20, 20);
		c.gridy = 0;
		this.backButton(c);
		c.gridy = 1;
		this.UMLHelpButton(c);
		c.gridy = 2;
		this.SDHelpButton(c);
		c.gridy = 3; 
		this.ConfigHelpButton(c);
		c.gridy = 4;
		this.patternAdditionHelpButton(c);
	}
	
	private void backButton(GridBagConstraints c){
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new BackAction());
		this.add(backButton, c);
	}
	
	private void UMLHelpButton(GridBagConstraints c){
		JButton UMLHelpButton = new JButton("UML Instructions");
		UMLHelpButton.addActionListener(new UMLAction());
		this.add(UMLHelpButton, c);
	}
	
	private void SDHelpButton(GridBagConstraints c){
		JButton SDHelpButton = new JButton("SD Instructions");
		SDHelpButton.addActionListener(new SDAction());
		this.add(SDHelpButton, c);
	}
	
	private void ConfigHelpButton(GridBagConstraints c){
		JButton ConfigHelpButton = new JButton("Config Instructions");
		ConfigHelpButton.addActionListener(new ConfigAction());
		this.add(ConfigHelpButton, c);
	}
	
	private void patternAdditionHelpButton(GridBagConstraints c){
		JButton patternHelpButton = new JButton("Adding Patterns Instructions");
		patternHelpButton.addActionListener(new PatternAction());
		this.add(patternHelpButton, c);
		
	}
	private class BackAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel mainMenu = new MainMenuPanel(HelpPanel.this.mainMenuFrame, HelpPanel.this.args);
			HelpPanel.this.mainMenuFrame.setContentPane(mainMenu);
			HelpPanel.this.mainMenuFrame.pack();
			HelpPanel.this.mainMenuFrame.repaint();
			HelpPanel.this.mainMenuFrame.revalidate();
		}
	}
	
	private class UMLAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("UML Instructions");
		}
	}
	
	private class SDAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("SD Instructions");
		}
	}
	
	private class ConfigAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Config Instructions");
		}
	}
	
	private class PatternAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Pattern addition instructions");
		}
		
	}
}
