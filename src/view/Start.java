package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start extends JPanel implements ActionListener{

	GameView GameView;
	
	private ImageIcon J = new ImageIcon("SEIF BLACK.png");
	private ImageIcon J1 = new ImageIcon("con.jpg");
	private ImageIcon J2 = new ImageIcon("Lgame-3.png");
	private ImageIcon J3 = new ImageIcon("Exit-3.png");
	
	private JLabel title,back;
	private JButton exit,login;
	
	
	
	Start(GameView GameView){
		this.setLayout(null);
		this.GameView = GameView;
		this.setVisible(true);
		this.setSize(1500, 900);
		back = new JLabel("");
		title =new JLabel("");
		login =new JButton("");
		exit = new JButton("");
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		login.setBounds(550, 400, 350, 100);
		exit.setBounds(550, 500, 350, 100);
		title.setBounds(275, 30, 900, 300);
		back.setBounds(0,0,1500,900);
		back.setIcon(J1);
		login.setBackground(Color.yellow);
		exit.setBackground(Color.CYAN);
		exit.setForeground(Color.black);
		exit.addActionListener(this);
		back.setVisible(true);
		back.add(login);
		back.add(exit);
		back.add(title);
		this.add(back);
		login.setIcon(J2);
		login.setVisible(true);
		title.setVisible(true);
		title.setIcon(J);
		exit.setVisible(true);
		login.addActionListener(this);
		exit.setIcon(J3);
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			GameView.getEntery().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(null, "khalsana");
			GameView.dispose();
		}		
	}

}
