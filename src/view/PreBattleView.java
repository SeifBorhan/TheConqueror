package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.City;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.TargetNotReachedException;
import units.Army;

public class PreBattleView extends JPanel implements ActionListener {

	JButton auto = new JButton("Auto-Resolve");
	JButton manual = new JButton("Manual Attack");
	private ImageIcon back1 = new ImageIcon("pre-2.png");
	JButton lay = new JButton("Layseige");
	JLabel back = new JLabel("");
	GameView GameView;

	PreBattleView(GameView GameView) {
		this.GameView = GameView;
		this.setLayout(null);
		this.setBounds(0, 0, 1500, 900);
		this.setVisible(false);

		back.setVisible(true);
		back.setBounds(0, 0, 1500, 900);
		this.add(back);
		back.setIcon(back1);

		auto.setVisible(true);
		auto.setBounds(200, 100, 300, 100);
		auto.setOpaque(false);
		auto.setForeground(Color.white);
		auto.setContentAreaFilled(false);
		auto.setBorderPainted(false);
		auto.setFont(new Font("Times New Roman", Font.BOLD, 25));
		back.add(auto);
		auto.addActionListener(this);

		manual.setVisible(true);
		manual.setOpaque(false);
		manual.setForeground(Color.black);
		manual.setContentAreaFilled(false);
		manual.setBorderPainted(false);
		manual.setFont(new Font("Times New Roman", Font.BOLD, 25));
		manual.setBounds(550, 300, 350, 100);
		back.add(manual);
		manual.addActionListener(this);

		lay.setVisible(true);
		lay.setOpaque(false);
		lay.setForeground(Color.DARK_GRAY);
		lay.setContentAreaFilled(false);
		lay.setBorderPainted(false);
		lay.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lay.setBounds(1000, 500, 200, 100);
		back.add(lay);
		lay.addActionListener(this);

	}

	public Army returnDefendingArmy() {
		Army arm = returnAttackingArmy();
		String name = arm.getCurrentLocation();
		for (int i = 0; i < GameView.getGame().getAvailableCities().size(); i++) {
			if (GameView.getGame().getAvailableCities().get(i).getName().equalsIgnoreCase(name)) {
				return GameView.getGame().getAvailableCities().get(i).getDefendingArmy();
			}
		}
		return null;

	}

	public Army returnAttackingArmy() {
		Army arm = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getDistancetoTarget() == 0
					&& GameView.getGame().getPlayer().getControlledArmies().get(i).getUnits().size() != 0
					&& GameView.getMapView().c.getName().equalsIgnoreCase(
							GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
				break;
			}
		}

		return arm;

	}

	public City returnSeigedCity() {
		Army a = returnAttackingArmy();
		String name = a.getCurrentLocation();
		for (int i = 0; i < GameView.getGame().getAvailableCities().size(); i++) {
			if (GameView.getGame().getAvailableCities().get(i).getName().equalsIgnoreCase(name)) {
				return GameView.getGame().getAvailableCities().get(i);
			}
		}
		return null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == auto) {
			Army a = GameView.BattleView.getMyArmy();
			Army b = GameView.getMapView().c.getDefendingArmy();
			try {
				GameView.getGame().autoResolve(a, b);
				if (a.getUnits().isEmpty()) {
					this.setVisible(false);
					GameView.AutoResolveLose.setVisible(true);
				}
				if (b.getUnits().isEmpty()
						|| GameView.getGame().getPlayer().getControlledCities().contains(GameView.getMapView().c)) {
					this.setVisible(false);
					GameView.AutoResolveWin.setVisible(true);
				}

			} catch (FriendlyFireException e1) {
				JOptionPane.showMessageDialog(null, "Friendly fire will not be tolerated!!");
				e1.printStackTrace();
			}

		}
		if (e.getSource() == manual) {
			GameView.BattleView.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == lay) {
			this.setVisible(false);

			try {
				GameView.getGame().getPlayer().laySiege(returnAttackingArmy(), returnSeigedCity());
			} catch (TargetNotReachedException e1) {
				JOptionPane.showMessageDialog(null, "Army did not reach its target!!");

				e1.printStackTrace();
			} catch (FriendlyCityException e1) {
				JOptionPane.showMessageDialog(null, "Cannot layseige on a city that you control!!");
				e1.printStackTrace();

			}
			GameView.getMapView().setVisible(true);

		}
		GameView.updateAll();
		GameView.getCairo().updateCairoArmies();
		GameView.getRome().updateCairoArmies();
		GameView.getSparta().updateCairoArmies();
		GameView.getCairo().updatedefRec();
		GameView.getRome().updatedefRec();
		GameView.getSparta().updatedefRec();
		GameView.getMapView().setcontrolledarmiescombo();

	}

}
