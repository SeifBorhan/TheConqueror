package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import engine.City;
import exceptions.FriendlyFireException;
import units.Army;
import units.Unit;

@SuppressWarnings("serial")
public class BattleView extends JPanel implements ActionListener {

	JLabel batt = new JLabel();

	private JButton info;

	JLabel x, y, z, player, food, gold, turns, na, tu, foodl, goldl;
	private ImageIcon n = new ImageIcon("name-2.png");
	private ImageIcon t = new ImageIcon("turnsF.png");
	private ImageIcon g = new ImageIcon("goldF.png");
	private ImageIcon f = new ImageIcon("foodF.png");
	GameView GameView;

	private JComboBox<String> MyArmy, DefendingArmy, jcd;

	String[] MyArmyUnits, DefendingArmyUnits;

	private ImageIcon battle = new ImageIcon("battle-2-2.jpg");

	private JButton myarmy, myarmy2, myarmy3, myarmy4, myarmy5, myarmy6, myarmy7, hisarmy, hisarmy2, hisarmy3;

	JTextArea prompts;

	BattleView(GameView GameView) {
		this.setLayout(null);
		this.GameView = GameView;
		this.setBounds(0, 0, 1500, 900);
		this.setVisible(false);

		batt.setBounds(0, 0, 1500, 900);
		batt.setIcon(battle);
		batt.setVisible(true);
		this.add(batt);
		info = new JButton("Info");
		info.setVisible(true);
		info.setBounds(150, 700, 50, 50);
		batt.add(info);
		info.addActionListener(this);
		player = new JLabel("");
		gold = new JLabel("");
		food = new JLabel("");
		food.setIcon(f);
		gold.setIcon(g);
		turns = new JLabel("");
		player.setBounds(18, 2, 200, 50);
		gold.setBounds(10, 70, 32, 32);
		food.setBounds(10, 107, 32, 32);
		turns.setBounds(8, 2, 100, 50);
		foodl = new JLabel("");
		goldl = new JLabel("");
		foodl.setBounds(55, 78, 100, 100);
		goldl.setBounds(55, 30, 100, 100);
		player.setFont(new Font("Times New Roman", Font.BOLD, 20));
		turns.setFont(new Font("Times New Roman", Font.BOLD, 15));
		goldl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		foodl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.GameView = GameView;
		this.setLayout(null);
		na = new JLabel("");
		na.setIcon(n);
		na.setBounds(70, 10, 200, 50);
		tu = new JLabel("");
		tu.setIcon(t);
		tu.setBounds(10, 10, 200, 50);

		foodl.setVisible(false);
		tu.setVisible(false);
		na.setVisible(false);
		food.setVisible(false);
		gold.setVisible(false);
		goldl.setVisible(false);
		player.setVisible(false);
		turns.setVisible(false);

		batt.add(foodl);
		batt.add(tu);
		batt.add(na);
		batt.add(food);
		batt.add(gold);
		batt.add(goldl);
		na.add(player);
		tu.add(turns);

		myarmy = new JButton("");
		myarmy.setVisible(true);
		myarmy.setBounds(0, 300, 100, 400);
		batt.add(myarmy);
		myarmy.addActionListener(this);

		myarmy2 = new JButton("");
		myarmy2.setVisible(true);
		myarmy2.setBounds(100, 200, 100, 400);
		batt.add(myarmy2);
		myarmy2.addActionListener(this);

		myarmy3 = new JButton("");
		myarmy3.setVisible(true);
		myarmy3.setBounds(200, 100, 100, 400);
		batt.add(myarmy3);
		myarmy3.addActionListener(this);

		myarmy4 = new JButton("");
		myarmy4.setVisible(true);
		myarmy4.setBounds(300, 50, 100, 400);
		batt.add(myarmy4);
		myarmy4.addActionListener(this);

		myarmy5 = new JButton("");
		myarmy5.setVisible(true);
		myarmy5.setBounds(400, 30, 100, 300);
		batt.add(myarmy5);
		myarmy5.addActionListener(this);

		myarmy6 = new JButton("");
		myarmy6.setVisible(true);
		myarmy6.setBounds(500, 20, 100, 200);
		batt.add(myarmy6);
		myarmy6.addActionListener(this);

		myarmy7 = new JButton("");
		myarmy7.setVisible(true);
		myarmy7.setBounds(600, 10, 200, 100);
		batt.add(myarmy7);
		myarmy7.addActionListener(this);

		hisarmy = new JButton("");
		hisarmy.setVisible(true);
		hisarmy.setBounds(770, 400, 700, 450);
		batt.add(hisarmy);
		hisarmy.addActionListener(this);

		hisarmy2 = new JButton("");
		hisarmy2.setVisible(true);
		hisarmy2.setBounds(1050, 0, 600, 450);
		batt.add(hisarmy2);
		hisarmy2.addActionListener(this);

		hisarmy3 = new JButton("");
		hisarmy3.setVisible(true);
		hisarmy3.setBounds(900, 200, 600, 450);
		batt.add(hisarmy3);
		hisarmy3.addActionListener(this);

		prompts = new JTextArea();
		prompts.setBounds(250, 700, 400, 100);
		prompts.setEditable(false);
		prompts.setForeground(Color.LIGHT_GRAY);
		prompts.setText("Battle has started!");
		prompts.setFont(new Font("Times New Roman", Font.BOLD, 15));
		prompts.setOpaque(false);
		prompts.setVisible(true);
		batt.add(prompts);

		MyArmy = new JComboBox<String>();
		MyArmy.setVisible(true);
		MyArmy.setBounds(50, 10, 200, 80);
		batt.add(MyArmy);
		MyArmy.addActionListener(this);

		DefendingArmy = new JComboBox<String>();
		DefendingArmy.setVisible(true);
		DefendingArmy.setBounds(820, 10, 200, 80);
		batt.add(DefendingArmy);
		DefendingArmy.addActionListener(this);

		jcd = new JComboBox<String>();

		myarmy.setOpaque(false);
		myarmy.setContentAreaFilled(false);
		myarmy.setBorderPainted(false);
		myarmy.addActionListener(this);

		myarmy2.setOpaque(false);
		myarmy2.setContentAreaFilled(false);
		myarmy2.setBorderPainted(false);
		myarmy2.addActionListener(this);

		myarmy3.setOpaque(false);
		myarmy3.setContentAreaFilled(false);
		myarmy3.setBorderPainted(false);
		myarmy3.addActionListener(this);

		myarmy4.setOpaque(false);
		myarmy4.setContentAreaFilled(false);
		myarmy4.setBorderPainted(false);
		myarmy4.addActionListener(this);

		myarmy5.setOpaque(false);
		myarmy5.setContentAreaFilled(false);
		myarmy5.setBorderPainted(false);
		myarmy5.addActionListener(this);

		myarmy6.setOpaque(false);
		myarmy6.setContentAreaFilled(false);
		myarmy6.setBorderPainted(false);
		myarmy6.addActionListener(this);

		myarmy7.setOpaque(false);
		myarmy7.setContentAreaFilled(false);
		myarmy7.setBorderPainted(false);
		myarmy7.addActionListener(this);

		hisarmy.setOpaque(false);
		hisarmy.setContentAreaFilled(false);
		hisarmy.setBorderPainted(false);
		hisarmy.addActionListener(this);

		hisarmy2.setOpaque(false);
		hisarmy2.setContentAreaFilled(false);
		hisarmy2.setBorderPainted(false);
		hisarmy2.addActionListener(this);

		hisarmy3.setOpaque(false);
		hisarmy3.setContentAreaFilled(false);
		hisarmy3.setBorderPainted(false);
		hisarmy3.addActionListener(this);

	}

//	public static void main(String[] args) {
//		GameView g = new GameView();
//		BattleView b = new BattleView(g);
//
//		g.start.setVisible(false);
//		g.add(b);
//
//	}
	public void setDefArmyUnit() {
		Army arm = null;
		arm = GameView.getMapView().c.getDefendingArmy();

		String[] arr = new String[arm.getUnits().size()];
		for (int i = 0; i < arm.getUnits().size(); i++) {

			arr[i] = (i + 1) + "-" + " " + arm.getUnits().get(i).getClass().getName().substring(6) + " " + "Lvl:"
					+ arm.getUnits().get(i).getLevel();

		}
		DefendingArmy.setModel(new DefaultComboBoxModel(arr));

	}

	public void updateFTT() {
		String f = (String) ("" + GameView.getGame().getPlayer().getFood());
		String t = (String) ("" + GameView.getGame().getPlayer().getTreasury());
		String turn = (String) ("" + GameView.getGame().getCurrentTurnCount()) + "/50";
		foodl.setText(f);
		goldl.setText(t);
		turns.setText(turn);
		player.setText((String) GameView.getGame().getPlayer().getName());

	}

	public void setMyArmyUnit() {
		Army arm = null;

		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())
					&& GameView.getGame().getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
				break;
			}
		}

		String[] arr = new String[10];
		for (int i = 0; i < arm.getUnits().size(); i++) {
			//if (arm.getUnits().get(i) != null) {
				arr[i] = (i + 1) + "-" + " " + arm.getUnits().get(i).getClass().getName().substring(6) + " " + "Lvl:"
						+ arm.getUnits().get(i).getLevel();
				;
			//}
		}
		MyArmy.setModel(new DefaultComboBoxModel(arr));

	}

	public void setMyArmyUnitPrompt(int ind2) {
		Army arm = null;

		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
			}
		}

		Unit a = arm.getUnits().get(ind2);
		prompts.setText("Unit Type:" + a.getType() + "\n" + "Level:" + a.getLevel() + "\n" + "Soldiers:"
				+ a.getCurrentSoldierCount() + "\n" + "Maximum amount of soldiers:" + a.getMaxSoldierCount());

	}

	public void setDefArmyUnitPrompt(int ind2) {
		Army arm = null;

		arm = GameView.getMapView().c.getDefendingArmy();

		Unit a = arm.getUnits().get(ind2);
		prompts.setText("Unit Type:" + a.getType() + "\n" + "Level:" + a.getLevel() + "\n" + "Soldiers:"
				+ a.getCurrentSoldierCount() + "\n" + "Maximum amount of soldiers:" + a.getMaxSoldierCount());

	}

	public void attack1(int ind1, int ind2) {
		Army arm = null;
		Army arm1 = null;

		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
			}
		}

		Unit a = arm.getUnits().get(ind1);

		arm1 = GameView.getMapView().c.getDefendingArmy();

		Unit a1 = arm1.getUnits().get(ind2);

		try {
			a.attack(a1);
		} catch (FriendlyFireException e) {
			JOptionPane.showMessageDialog(this, "Friendly Fire won't be tolerated!!", "ERROR!!!!!",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
//		setDefArmyUnit();

	}

	public void attack2() {
		Army arm = null;
		Army arm1 = null;

		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
			}
		}

		Unit a = arm.getUnits().get((int) (Math.random() * arm.getUnits().size()));

		arm1 = GameView.getMapView().c.getDefendingArmy();

		Unit a1 = arm1.getUnits().get((int) (Math.random() * arm1.getUnits().size()));

		try {
			a1.attack(a);
		} catch (FriendlyFireException e) {
			JOptionPane.showMessageDialog(this, "Friendly Fire won't be tolerated!!", "ERROR!!!!!",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
//		setMyArmyUnit();
	}

	public Unit getRandomMyUnit() {
		Army arm = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
			}
		}

		Unit a = arm.getUnits().get((int) (Math.random() * arm.getUnits().size()));

		return a;

	}

	public Unit getRandomDefUnit() {
		Army arm1 = GameView.getMapView().c.getDefendingArmy();
		Unit a1 = arm1.getUnits().get((int) (Math.random() * arm1.getUnits().size()));
		return a1;

	}

	public Army getMyArmy() {
		Army arm = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase(GameView.getMapView().c.getName())) {
				arm = GameView.getGame().getPlayer().getControlledArmies().get(i);
			}
		}
		return arm;
	}

	public String[] retUnits() {
		String[] defarm = new String[GameView.getMapView().c.getDefendingArmy().getUnits().size()];
		for (int i = 0; i < GameView.getMapView().c.getDefendingArmy().getUnits().size(); i++) {
			defarm[i] = (i + 1) + "-" + " "
					+ GameView.getMapView().c.getDefendingArmy().getUnits().get(i).getClass().getName().substring(6)
					+ " " + "Lvl:" + GameView.getMapView().c.getDefendingArmy().getUnits().get(i).getLevel();
		}
		return defarm;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hisarmy || e.getSource() == hisarmy2 || e.getSource() == hisarmy3) {
			setDefArmyUnit();

		}

		if (e.getSource() == myarmy || e.getSource() == myarmy2 || e.getSource() == myarmy3 || e.getSource() == myarmy4
				|| e.getSource() == myarmy5 || e.getSource() == myarmy6 || e.getSource() == myarmy7) {
			setMyArmyUnit();
			if (GameView.getMapView().c.getDefendingArmy().getUnits().size() == 0) {
				this.setVisible(false);
				GameView.AutoResolveWin.setVisible(true);
			}
			if (getMyArmy().getUnits().size() == 0) {
				this.setVisible(false);
				GameView.AutoResolveLose.setVisible(true);
			}

		}

		if (e.getSource() == MyArmy) {
			setMyArmyUnitPrompt(MyArmy.getSelectedIndex());
			jcd.setModel(new DefaultComboBoxModel(retUnits()));

			JOptionPane.showMessageDialog(null, jcd, "which unit would you like to attack?",
					JOptionPane.QUESTION_MESSAGE);
			if (jcd.getSelectedIndex() == JOptionPane.CLOSED_OPTION) {
				return;
			} else {
//				if(GameView.getMapView().c.getDefendingArmy().getUnits().size()==0) {
//					this.setVisible(false);
//					GameView.AR.add(GameView.AR.YW);
//					GameView.AR.setVisible(true);
//				}
//				if(getMyArmy().getUnits().size()==0) {
//					this.setVisible(false);
//					GameView.AR.add(GameView.AR.YL);
//					GameView.AR.setVisible(true);
//				}
				int n = GameView.getMapView().c.getDefendingArmy().getUnits().get(jcd.getSelectedIndex())
						.getCurrentSoldierCount();
				attack1(MyArmy.getSelectedIndex(), jcd.getSelectedIndex());
				Unit a = getRandomDefUnit();
				// int z=a.getCurrentSoldierCount();
				Unit b = getRandomMyUnit();
				int y = b.getCurrentSoldierCount();
				try {
					a.attack(b);
					if (GameView.getMapView().c.getDefendingArmy().getUnits().size() == 0) {
						this.setVisible(false);
						GameView.AutoResolveWin.setVisible(true);
						GameView.getGame().occupy(getMyArmy(), GameView.getMapView().c.getName());
					}
					if (getMyArmy().getUnits().size() == 0) {
						this.setVisible(false);
						GameView.AutoResolveLose.setVisible(true);
					}
				} catch (FriendlyFireException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setMyArmyUnitPrompt(MyArmy.getSelectedIndex());
				setMyArmyUnit();
				setDefArmyUnit();
				int n1 = GameView.getMapView().c.getDefendingArmy().getUnits().get(jcd.getSelectedIndex())
						.getCurrentSoldierCount();
				int z = y - b.getCurrentSoldierCount();
				prompts.setText("You attacked" + " " + (String) jcd.getSelectedItem().toString().substring(3) + " "
						+ "with" + " " + (String) MyArmy.getSelectedItem().toString().substring(3) + "\n"
						+ (String) jcd.getSelectedItem().toString().substring(3) + " " + "lost" + " " + (n - n1) + " "
						+ "soldiers" + "\n" + "Your" + " " + b.getClass().getName().substring(6) + " " + "Lvl:"
						+ b.getLevel() + " " + "was attacked by" + " " + a.getClass().getName().substring(6) + " "
						+ "Lvl:" + a.getLevel() + "\n" + "Your" + " " + b.getClass().getName().substring(6) + " "
						+ "lost" + " " + z + " " + "soldiers");
			}
//			if(GameView.getMapView().c.getDefendingArmy().getUnits().size()==0) {
//				this.setVisible(false);
//				GameView.AR.add(GameView.AR.YW);
//				GameView.AR.setVisible(true);
//			}
//			if(getMyArmy().getUnits().size()==0) {
//				this.setVisible(false);
//				GameView.AR.add(GameView.AR.YL);
//				GameView.AR.setVisible(true);
//			}
		}
		if (e.getSource() == DefendingArmy) {
			setDefArmyUnitPrompt(DefendingArmy.getSelectedIndex());

		}
		if (e.getSource() == info) {
			if (foodl.isVisible()) {
				foodl.setVisible(false);
				tu.setVisible(false);
				na.setVisible(false);
				food.setVisible(false);
				gold.setVisible(false);
				goldl.setVisible(false);
				player.setVisible(false);
				turns.setVisible(false);

			} else {
				foodl.setVisible(true);
				tu.setVisible(true);
				na.setVisible(true);
				food.setVisible(true);
				gold.setVisible(true);
				goldl.setVisible(true);
				player.setVisible(true);
				turns.setVisible(true);

			}

		}

	}

}
