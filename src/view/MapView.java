package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import engine.City;
import engine.Player;
import exceptions.FriendlyCityException;
import units.Army;
import units.Status;
import units.Unit;

@SuppressWarnings("serial")
public class MapView extends JPanel implements ActionListener {

	GameView GameView;

	private JButton Endt;
	private JComboBox CArmunits;
	JLabel l;
	private ImageIcon J = new ImageIcon("map2-1.jpg");
	JButton cairo;
	JButton rome;
	JButton sparta;
	JLabel x, y, z, player, food, gold, turns, na, tu, foodl, goldl;
	private ImageIcon g = new ImageIcon("goldF.png");
	private ImageIcon f = new ImageIcon("foodF.png");
	private ImageIcon n = new ImageIcon("name-2.png");
	private ImageIcon t = new ImageIcon("turnsF.png");
	JTextArea prompts;
	String[] cities = { "Cairo", "Rome", "Sparta", "Cancel" };
	private JLabel Controlledarmies = new JLabel("Controlled Armies"), units = new JLabel("Units");
	private JComboBox Controlledarmiesc;
	String[] yesorno = new String[] { "Yes", "No", "Cancel" };
	// private JButton Armies=new JButton("Armies");
	String[] attackorauto = new String[] { "Attack", "Auto-resolve", "Cancel" };

	City c = null;

	MapView(GameView GameView) {
		foodl = new JLabel("");
		goldl = new JLabel("");
		foodl.setBounds(55, 78, 100, 100);
		goldl.setBounds(55, 30, 100, 100);
		goldl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		foodl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.GameView = GameView;
		this.setLayout(null);
		na = new JLabel("");
		na.setIcon(n);
		na.setVisible(true);
		na.setBounds(70, 10, 200, 50);

		tu = new JLabel("");
		tu.setIcon(t);
		tu.setVisible(true);
		tu.setBounds(10, 10, 200, 50);

		cairo = new JButton("");
		rome = new JButton("");
		sparta = new JButton("");
		cairo.setBounds(280, 250, 150, 150);
		rome.setBounds(550, 50, 150, 150);
		sparta.setBounds(1100, 710, 150, 150);
		l = new JLabel("");
		l.setBounds(0, 0, 1500, 900);
		this.setSize(1500, 900);
		this.setVisible(false);
		l.setIcon(J);
		this.add(l);
		l.add(cairo);
		l.add(sparta);
		l.add(rome);
		cairo.setOpaque(false);
		cairo.setContentAreaFilled(false);
		cairo.setBorderPainted(false);
		cairo.addActionListener(this);
		rome.addActionListener(this);
		sparta.addActionListener(this);
		rome.setOpaque(false);
		rome.setContentAreaFilled(false);
		rome.setBorderPainted(false);
		sparta.setOpaque(false);
		sparta.setContentAreaFilled(false);
		sparta.setBorderPainted(false);
		x = new JLabel("CAIRO");
		y = new JLabel("ROME");
		z = new JLabel("SPARTA");
		x.setBounds(350, 250, 100, 100);
		y.setBounds(610, 10, 100, 100);
		z.setBounds(1110, 510, 400, 400);
		l.add(x);
		l.add(y);
		l.add(z);
		x.setFont(new Font("Arial", Font.BOLD, 25));
		y.setFont(new Font("Arial", Font.BOLD, 25));
		z.setFont(new Font("Arial", Font.BOLD, 25));
		x.setVisible(true);
		player = new JLabel("");
		gold = new JLabel("");
		food = new JLabel("");
		turns = new JLabel("");
		player.setBounds(18, 2, 200, 50);
		gold.setBounds(10, 70, 32, 32);
		food.setBounds(10, 107, 32, 32);
		turns.setBounds(8, 2, 100, 50);
		gold.setIcon(g);
		food.setIcon(f);
		na.add(player);
		tu.add(turns);
		l.add(gold);
		l.add(food);
		player.setFont(new Font("Times New Roman", Font.BOLD, 20));
		turns.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l.add(na);
		l.add(tu);
		l.add(foodl);
		l.add(goldl);
		foodl.setVisible(true);
		goldl.setVisible(true);
		Endt = new JButton("End Turn");
		Endt.setBounds(10, 150, 100, 50);
		l.add(Endt);
		Endt.addActionListener(this);
		prompts = new JTextArea();
		prompts.setBounds(1200, 450, 280, 200);
		prompts.setEditable(false);
		prompts.setForeground(Color.black);
		prompts.setOpaque(false);
		prompts.setText("");
		prompts.setVisible(true);
		l.add(prompts);

		Controlledarmiesc = new JComboBox();
		Controlledarmiesc.setBounds(1030, 10, 150, 80);
		Controlledarmiesc.setVisible(true);
		l.add(Controlledarmiesc);
		Controlledarmiesc.addActionListener(this);

		Controlledarmies.setBounds(920, 10, 200, 80);
		Controlledarmies.setVisible(true);
		l.add(Controlledarmies);

		CArmunits = new JComboBox();
		CArmunits.setVisible(true);
		CArmunits.setBounds(1210, 10, 150, 80);
		l.add(CArmunits);
		CArmunits.addActionListener(this);

		units.setVisible(true);
		units.setBounds(1180, 10, 100, 80);
		l.add(units);
	}

	public JLabel getPlayer() {
		return player;
	}

	public void setPlayer(JLabel player) {
		this.player = player;
	}

	public void updateName() {
		String s = (String) GameView.getGame().getPlayer().getName();
		player.setText(s);

	}

	public void underAttack(String nameCity) {
		for (int i = 0; i < GameView.getGame().getAvailableCities().size(); i++) {
			if (GameView.getGame().getAvailableCities().get(i).getName().equals(nameCity)) {
				this.c = GameView.getGame().getAvailableCities().get(i);
				return;
			}
		}

	}

	public void updateFTT() {
		String f = (String) ("" + GameView.getGame().getPlayer().getFood());
		String t = (String) ("" + GameView.getGame().getPlayer().getTreasury());
		String turn = (String) ("" + GameView.getGame().getCurrentTurnCount()) + "/50";
		foodl.setText(f);
		goldl.setText(t);
		turns.setText(turn);

	}

	public void setarmyunitprompt(int ind1, int ind2) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}

		arm = defarm[ind1];

		Unit a = arm.getUnits().get(ind2);
		prompts.setText("Unit Type:" + a.getType() + "\n" + "Level:" + a.getLevel() + "\n" + "Soldiers:"
				+ a.getCurrentSoldierCount() + "\n" + "Maximum amount of soldiers:" + a.getMaxSoldierCount());

	}

	public void setarmyunit(int ind1) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];

		String[] arr = new String[10];
		for (int i = 0; i < arm.getUnits().size(); i++) {
			if (arm.getUnits().get(i) != null) {
				arr[i] = (i + 1) + "-" + " " + arm.getUnits().get(i).getClass().getName().substring(6) + " " + "Lvl:"
						+ arm.getUnits().get(i).getLevel();
				;
			}
		}
		CArmunits.setModel(new DefaultComboBoxModel(arr));

	}

	public void setarmyprompt(int ind) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind];
		
		if (arm.getCurrentStatus().equals(Status.IDLE))
			prompts.setText("Army Number:" + (ind + 1) + "" + "\n" + "Currently:" + arm.getCurrentStatus() + "\n");
		if (arm.getCurrentStatus().equals(Status.MARCHING))
			prompts.setText("Army Number:" + (ind + 1) + "" + "\n" + "Currently:" + arm.getCurrentStatus() + "\n"
					+ "Heading to:" + arm.getTarget() + "\n" + "Distance to target:" + arm.getDistancetoTarget());
		if (arm.getCurrentStatus().equals(Status.BESIEGING))
			prompts.setText("Army Number:" + (ind + 1) + "" + "\n" + "Currently:" + arm.getCurrentStatus() + "\n"
					+ "Besieging:" + arm.getTarget() + "\n" + "Sieging turns:" + c.getTurnsUnderSiege());

	}

	public void setcontrolledarmiescombo() {
		String[] arr = new String[450];
		Player p = GameView.getGame().getPlayer();
		for (int i = 0; i < p.getControlledArmies().size(); i++) {
			arr[i] = (i + 1) + "-" + "Army" + " " + "(" + p.getControlledArmies().get(i).getCurrentStatus() + ")";
		}
		Controlledarmiesc.setModel(new DefaultComboBoxModel(arr));

	}

	public void targetcityg(int ind1, String target) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];
		try {
			GameView.getGame().targetCity(arm, target);
		} catch (FriendlyCityException e) {
			JOptionPane.showMessageDialog(null, "You cannot target a city you control!!");

			e.printStackTrace();
		}
		setcontrolledarmiescombo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cairo) {
			for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
				if (GameView.getGame().getPlayer().getControlledCities().get(i).getName()
						.equalsIgnoreCase(x.getText())) {
					GameView.getCairo().setVisible(true);
					GameView.getMapView().setVisible(false);
					return;
				}
			}
			for (int i = 0; i < GameView.getGame().getAvailableCities().size(); i++) {
				if (c.isUnderSiege() && c.getName().equalsIgnoreCase("Cairo") && c.getTurnsUnderSiege() != 3
						&& !GameView.getGame().getPlayer().getControlledCities().contains(c)
						&& GameView.PreBattleView.returnAttackingArmy().getUnits().size() != 0) {
					GameView.PreBattleView.lay.setVisible(false);
					GameView.getMapView().setVisible(false);
					GameView.PreBattleView.setVisible(true);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Sorry,You don't control this city!!");

		} else if (e.getSource() == sparta) {
			for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
				if (GameView.getGame().getPlayer().getControlledCities().get(i).getName()
						.equalsIgnoreCase(z.getText())) {
					GameView.getSparta().setVisible(true);
					GameView.getMapView().setVisible(false);
					return;
				}
			}
			if (c.isUnderSiege() && c.getName().equalsIgnoreCase("Sparta") && c.getTurnsUnderSiege() != 3
					&& !GameView.getGame().getPlayer().getControlledCities().contains(c)
					&& GameView.PreBattleView.returnAttackingArmy().getUnits().size() != 0) {
				GameView.PreBattleView.lay.setVisible(false);
				GameView.getMapView().setVisible(false);
				GameView.PreBattleView.setVisible(true);
				return;
			}

			JOptionPane.showMessageDialog(null, "Sorry,You don't control this city!!");

		} else if (e.getSource() == rome) {
			for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
				if (GameView.getGame().getPlayer().getControlledCities().get(i).getName()
						.equalsIgnoreCase(y.getText())) {
					GameView.getRome().setVisible(true);
					GameView.getMapView().setVisible(false);
					return;
				}
			}
			for (int i = 0; i < GameView.getGame().getAvailableCities().size(); i++) {
				if (c.isUnderSiege() && c.getName().equalsIgnoreCase("Rome") && c.getTurnsUnderSiege() != 3
						&& !GameView.getGame().getPlayer().getControlledCities().contains(c)
						&& GameView.PreBattleView.returnAttackingArmy().getUnits().size() != 0) {
					GameView.PreBattleView.lay.setVisible(false);
					GameView.getMapView().setVisible(false);
					GameView.PreBattleView.setVisible(true);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Sorry,You don't control this city!!");
		}

		if (e.getSource() == Endt) {
			GameView.gameov();
			GameView.getGame().endTurn();
			GameView.updateAll();
			setcontrolledarmiescombo();
			// setarmyprompt(Controlledarmiesc.getSelectedIndex());
			GameView.getCairo().updateCairoArmies();
			GameView.getRome().updateCairoArmies();
			GameView.getSparta().updateCairoArmies();

			for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
				if (GameView.getGame().getPlayer().getControlledArmies().get(i).getDistancetoTarget() == 0
						&& c.getTurnsUnderSiege() == -1 && GameView.getGame().getPlayer().getControlledArmies().get(i)
								.getCurrentLocation().equalsIgnoreCase(c.getName())) {
					GameView.PreBattleView.setVisible(true);
					GameView.MapView.setVisible(false);
					GameView.PreBattleView.lay.setVisible(true);

				}
			}

			if (c.getTurnsUnderSiege() == 3 && c.isUnderSiege()
					&& !GameView.getGame().getPlayer().getControlledCities().contains(c)
					&& GameView.PreBattleView.returnAttackingArmy().getUnits().size() != 0) {
				GameView.PreBattleView.setVisible(true);
				GameView.MapView.setVisible(false);
				GameView.PreBattleView.lay.setVisible(false);
			}
		}
//			GameView.gameov();

		if (e.getSource() == Controlledarmiesc) {
			setarmyunit(Controlledarmiesc.getSelectedIndex());
			// setarmyunitprompt(Controlledarmiesc.getSelectedIndex(),
			// CArmunits.getSelectedIndex());
			setarmyprompt(Controlledarmiesc.getSelectedIndex());
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"Would you like to target a city?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					yesorno, // the titles of buttons
					yesorno[2]);// default button title
			switch (n) {
			case 0:
				// cit.setModel(new DefaultComboBoxModel(returnArmies()));
				int s = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
						"Which city would you like to target?", "", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
						cities, // the titles of buttons
						cities[3]);// default button title
				if (s == 0) {
					targetcityg(Controlledarmiesc.getSelectedIndex(), "Cairo");
					underAttack("Cairo");
					setcontrolledarmiescombo();
					break;

				} else if (s == 1) {
					targetcityg(Controlledarmiesc.getSelectedIndex(), "Rome");
					underAttack("Rome");
					setcontrolledarmiescombo();
					break;

				} else if (s == 2) {
					targetcityg(Controlledarmiesc.getSelectedIndex(), "Sparta");
					underAttack("Sparta");
					setcontrolledarmiescombo();
					break;

				} else
					break;
				// Yes option
			case 1:
				break;
			case 2:
				break;
			}
			setarmyunit(Controlledarmiesc.getSelectedIndex());
			setarmyunitprompt(Controlledarmiesc.getSelectedIndex(), CArmunits.getSelectedIndex());
			setarmyprompt(Controlledarmiesc.getSelectedIndex());
			GameView.getCairo().updateCairoArmies();
			GameView.getRome().updateCairoArmies();
			GameView.getSparta().updateCairoArmies();
//			GameView.getCairo().setarmyunit(GameView.getCairo().Armunits.getSelectedIndex());
//			GameView.getRome().setarmyunit(GameView.getRome().Armunits.getSelectedIndex());
//			GameView.getSparta().setarmyunit(GameView.getSparta().Armunits.getSelectedIndex());
		}
		if (e.getSource() == CArmunits) {
			setarmyunitprompt(Controlledarmiesc.getSelectedIndex(), CArmunits.getSelectedIndex());
		}
	}

}
