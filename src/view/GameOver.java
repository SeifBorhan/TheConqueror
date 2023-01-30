package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class GameOver extends JPanel {

	private GameView GameView;

	private JLabel Jameover, WL;
	private ImageIcon GO = new ImageIcon("GO-2.png");
	private ImageIcon YW = new ImageIcon("YW-2.png");
	private ImageIcon YL = new ImageIcon("YL-2.png");

	Icon imgIcon = new ImageIcon("cry.gif");
	JLabel label = new JLabel(imgIcon);

	Icon imgIcon1 = new ImageIcon("YW1.gif");
	JLabel label1 = new JLabel(imgIcon1);

	public GameOver(GameView GameView) {
		this.GameView = GameView;
		this.setVisible(false);
		this.setBounds(0, 0, 1500, 900);
		this.setLayout(null);
		this.setBackground(Color.WHITE);

		WL = new JLabel();
		Jameover = new JLabel("");
		Jameover.setIcon(GO);
		Jameover.setVisible(true);
		Jameover.setBounds(340, 100, 800, 400);
		this.add(Jameover);
		WL.setVisible(true);
		WL.setBounds(500, 300, 600, 400);
		this.add(WL);

		label.setBounds(1050, 400, 200, 200);
		label.setVisible(false);
		this.add(label);

		label1.setBounds(1050, 400, 400, 400);
		label1.setVisible(false);
		this.add(label1);
	}

	public void WL() {

		if (GameView.getGame().getAvailableCities().size() == GameView.getGame().getPlayer().getControlledCities()
				.size()) {
			WL.setIcon(YW);
			label1.setVisible(true);
			this.setBackground(Color.GREEN);
		} else {

			WL.setIcon(YL);
			label.setVisible(true);
			this.setBackground(Color.RED);
		}

	}
}
