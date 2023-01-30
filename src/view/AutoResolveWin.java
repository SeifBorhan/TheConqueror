package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AutoResolveWin extends JPanel implements ActionListener {

	JButton return1;
	JLabel YW;
	GameView GameView;

	public AutoResolveWin(GameView GameView) {
		this.GameView = GameView;
		this.setLayout(null);
		this.setBounds(0, 0, 1500, 900);
		this.setVisible(false);

		YW = new JLabel("");
		YW.setBounds(0, 0, 1500, 900);
		YW.setVisible(true);
		YW.setIcon(new ImageIcon("VictoryFinal.png"));

		return1 = new JButton("");
		return1.setVisible(true);
		return1.setBounds(1150, 710, 144, 75);
		return1.setOpaque(false);
		return1.setContentAreaFilled(false);
		return1.setBorderPainted(false);
		return1.addActionListener(this);
		YW.add(return1);
		this.add(YW);


	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == return1) {
			this.setVisible(false);
			GameView.getMapView().setVisible(true);
		}

	}

}
