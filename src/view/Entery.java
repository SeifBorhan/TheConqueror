package view;


import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Entery extends JPanel implements ActionListener{
	
	GameView GameView;
	
	private JLabel name;
	private JTextField input;
	private String[] bookTitles = new String[] {"Select a City","Cairo", "Sparta","Rome"};
	private JComboBox<String> bookList = new JComboBox<>(bookTitles);	
	private ImageIcon J1 = new ImageIcon("con.jpg");
	private JLabel back;
	private JLabel title;
	private ImageIcon J = new ImageIcon("SEIF BLACK.png");
	private ImageIcon J2 = new ImageIcon("start-2.png");

	private JButton s;




	
	Entery(GameView GameView){
		this.setLayout(null);
		this.GameView=GameView;
		title =new JLabel("");
		s = new JButton();
		s.setVisible(true);
		s.setIcon(J2);
		s.setBounds(550, 480, 350, 100);
		input = new JTextField("Enter Name Here!");
		input.setBounds(680, 315, 150, 30);
		title.setBounds(275, 30, 900, 300);
		input.setVisible(true);
		this.setSize(1500,900);
		back = new JLabel("");
		back.setBounds(0, 0, 1500, 900);
		back.setIcon(J1);
		name = new JLabel("Username:");
		name.setBounds(550, 300, 150, 60);
		name.setFont(new Font("Arial", Font.BOLD,25));
		bookList.setBounds(550, 350, 350, 100);
		back.add(bookList);
		name.setVisible(true);
		this.setVisible(false);
		this.add(back);
		back.add(input);
		back.setVisible(true);
		back.add(s);
		back.add(title);
		title.setIcon(J);
		title.setVisible(true);
		back.add(name);
		s.setOpaque(false);
		s.setContentAreaFilled(false);
		s.setBorderPainted(false);
		s.addActionListener(this);
		input.addActionListener(this);



		
		
	}
	
	


	
	public JTextField getInput() {
		return input;
	}

	public JComboBox<String> getBookList() {
		return bookList;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==s) {
			
		String st = (String) bookList.getSelectedItem();
		String n= (String) input.getText();
		if(st.equalsIgnoreCase("Select a City"))
			JOptionPane.showMessageDialog(this, "PLEASE SELECT A CITY!!",
                    "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
		else if (n.equals("Enter Name Here!") || n.equals(""))
			JOptionPane.showMessageDialog(this, "PLEASE ENTER A NAME!!",
                    "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
		else {
			GameView.startGame();
			GameView.getMapView().updateName();
			GameView.updateAll();
			GameView.getMapView().setVisible(true);
			this.setVisible(false);
		}
		
			
	}
	
	
	}
}
	


