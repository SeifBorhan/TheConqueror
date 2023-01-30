package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AutoResolveLose extends JPanel implements ActionListener {

	JButton return2;
	JLabel YL;
	GameView GameView;
	
	private ImageIcon n = new ImageIcon("DefeatFinal.jpg");


	public AutoResolveLose(GameView GameView) {
		this.GameView = GameView;
		this.setLayout(null);
		this.setBounds(0, 0, 1500, 900);
		this.setVisible(false);

		YL = new JLabel("");
		YL.setBounds(0, 0, 1500, 900);
		YL.setVisible(true);
		YL.setIcon(n);

		return2 = new JButton("");
		return2.setVisible(true);
		return2.setBounds(1150, 710, 144, 75);
		return2.setOpaque(false);
		return2.setContentAreaFilled(false);
		return2.setBorderPainted(false);
		return2.addActionListener(this);
		YL.add(return2);
		this.add(YL);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == return2) {
			this.setVisible(false);
			GameView.getMapView().setVisible(true);
		}

	}

}
