package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import units.Army;
import units.Unit;
import view.GameView;

public class RomeView extends JPanel implements ActionListener {
	private JLabel Cairo;
	GameView GameView;
	JComboBox<String> Armunits, jcd;
	private JLabel Armyunits;
	private JButton Endt;
	JButton Farm = new JButton("Farm");
	JButton Market = new JButton("Market");
	JLabel view = new JLabel("");
	private ImageIcon J1 = new ImageIcon("city.jpg");
	private ImageIcon Map = new ImageIcon("MapV.png");
	JButton mapv = new JButton("");
	JButton build = new JButton("");
	private ImageIcon buil = new ImageIcon("build.png");
	JButton arch = new JButton("ArcheryRange");
	JButton cav = new JButton("Cavlary");
	JButton infan = new JButton("Infantry");
	JButton ArcheryRange = new JButton("Archery");
	JButton Barracks = new JButton("Barracks");
	JButton Stable = new JButton("Stable");
	String[] buildings;
	JComboBox<String> builds;
	JTextArea prompts;
	JLabel x, y, z, player, food, gold, turns, na, tu, foodl, goldl;
	private ImageIcon g = new ImageIcon("goldF.png");
	private ImageIcon f = new ImageIcon("foodF.png");
	private ImageIcon n = new ImageIcon("name-2.png");
	private ImageIcon t = new ImageIcon("turnsF.png");
	private ImageIcon AR = new ImageIcon("ArcheryRange1.png");
	private ImageIcon BA = new ImageIcon("Barracks1.png");
	private ImageIcon ST = new ImageIcon("Stable1.png");
	private ImageIcon FA = new ImageIcon("Farm.png");
	private ImageIcon MA = new ImageIcon("Market1.png");
	String[] choices;
	String[] choicesofunits;
	JComboBox<String> choose;
	String[] yesorno;
	JComboBox<String> yn;
	JComboBox<String> Armycombo;
	JLabel Arm = new JLabel("Army:");
	private ImageIcon Army = new ImageIcon("def-2.jpg");
	private JComboBox<String> defarmyunits, idlearmiesunits;
	// private JButton initiate, reloc;
	// String[] defarm;
	JLabel defendingarmyunits = new JLabel("Defending Army Units:");

	RomeView(GameView GameView) {
		Cairo = new JLabel("Rome");
		Cairo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Cairo.setVisible(true);
		Cairo.setBounds(1260, 540, 200, 100);
		view.add(Cairo);

		foodl = new JLabel("");
		goldl = new JLabel("");
		foodl.setBounds(55, 78, 100, 100);
		goldl.setBounds(55, 30, 100, 100);
		goldl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		foodl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		na = new JLabel("");
		na.setIcon(n);
		na.setVisible(true);
		na.setBounds(70, 10, 200, 50);

		tu = new JLabel("");
		tu.setIcon(t);
		tu.setVisible(true);
		tu.setBounds(10, 10, 200, 50);

		view.add(tu);
		player = new JLabel("");
		gold = new JLabel("");
		food = new JLabel("");
		turns = new JLabel("0");
		player.setFont(new Font("Times New Roman", Font.BOLD, 20));
		turns.setFont(new Font("Times New Roman", Font.BOLD, 15));
		player.setBounds(18, 2, 200, 50);
		gold.setBounds(10, 70, 32, 32);
		food.setBounds(10, 107, 32, 32);
		turns.setBounds(8, 2, 50, 50);
		gold.setIcon(g);
		food.setIcon(f);
		na.add(player);
		tu.add(turns);
		view.add(gold);
		view.add(food);
		view.add(na);

		this.setLayout(null);
		this.GameView = GameView;
		this.setSize(1500, 900);
		view.setSize(1500, 900);
		this.setVisible(false);
		view.setIcon(J1);
		this.add(view);
		mapv.setBounds(1200, 600, 199, 200);
		view.add(mapv);
		mapv.setVisible(true);
		mapv.addActionListener(this);
		mapv.setIcon(Map);
		mapv.setOpaque(false);
		mapv.setContentAreaFilled(false);
		mapv.setBorderPainted(false);
		build.setBounds(10, 590, 199, 210);
		build.addActionListener(this);
		build.setVisible(true);
		view.add(build);
		build.setIcon(buil);
		build.setOpaque(false);
		build.setContentAreaFilled(false);
		build.setBorderPainted(false);
		buildings = new String[] { "ArcheryRange", "Barracks", "Stable", "Farm", "Market" };
		builds = new JComboBox<>(buildings);
		prompts = new JTextArea();
		prompts.setBounds(1200, 400, 280, 200);
		prompts.setEditable(false);
		prompts.setForeground(Color.black);
		prompts.setOpaque(false);
		prompts.setText("");
		// prompts.setBackground(new Color(0,0,0,0));
		prompts.setVisible(true);
		view.add(prompts);
		view.add(foodl);
		view.add(goldl);
		Endt = new JButton("End Turn");
		Endt.setBounds(10, 150, 100, 50);
		view.add(Endt);

		ArcheryRange.setBounds(200, 300, 200, 165);
		view.add(ArcheryRange);
		ArcheryRange.setVisible(false);
		ArcheryRange.setIcon(AR);
		ArcheryRange.setOpaque(false);
		ArcheryRange.setContentAreaFilled(false);
		ArcheryRange.setBorderPainted(false);
		ArcheryRange.addActionListener(this);

		Barracks.setBounds(350, 200, 200, 166);
		view.add(Barracks);
		Barracks.setVisible(false);
		Barracks.setIcon(BA);
		Barracks.setOpaque(false);
		Barracks.setContentAreaFilled(false);
		Barracks.setBorderPainted(false);
		Barracks.addActionListener(this);

		Stable.setBounds(500, 300, 200, 157);
		view.add(Stable);
		Stable.setVisible(false);
		Stable.setIcon(ST);
		Stable.setOpaque(false);
		Stable.setContentAreaFilled(false);
		Stable.setBorderPainted(false);
		Stable.addActionListener(this);

		Market.setBounds(650, 200, 200, 161);
		view.add(Market);
		Market.setVisible(false);
		Market.setIcon(MA);
		Market.setOpaque(false);
		Market.setContentAreaFilled(false);
		Market.setBorderPainted(false);
		Market.addActionListener(this);

		Farm.setBounds(800, 300, 200, 182);
		view.add(Farm);
		Farm.setVisible(false);
		Farm.setIcon(FA);
		Farm.setOpaque(false);
		Farm.setContentAreaFilled(false);
		Farm.setBorderPainted(false);
		Farm.addActionListener(this);

		choices = new String[] { "Upgrade", "Recruit", "Cancel" };
		choose = new JComboBox<>(choices);

		yesorno = new String[] { "Another Army", "Defending Army", "Cancel" };
		yn = new JComboBox<>(yesorno);

		Endt.addActionListener(this);

		// defarm = new String[10];
		defarmyunits = new JComboBox();

		// view.add(defarmyunits);
		defendingarmyunits.setVisible(true);
		view.add(defendingarmyunits);
		defendingarmyunits.setBounds(810, 2, 200, 80);
		defendingarmyunits.setForeground(Color.black);
		defarmyunits.setVisible(true);
		defarmyunits.setBounds(950, 2, 150, 80);
		view.add(defarmyunits);
		String[] idlearm = new String[30];
		idlearmiesunits = new JComboBox(idlearm);

		view.add(idlearmiesunits);
		idlearmiesunits.setVisible(false);
		idlearmiesunits.setBounds(950, 25, 150, 80);
		Arm.setVisible(true);
		Arm.setBounds(1165, 2, 200, 80);
		view.add(Arm);
		Armycombo = new JComboBox();
		Armycombo.setVisible(true);
		Armycombo.setBounds(1200, 22, 150, 40);
		view.add(Armycombo);
		Armycombo.addActionListener(this);

		Armunits = new JComboBox();
		Armunits.setVisible(true);
		Armunits.setBounds(1200, 50, 150, 80);
		view.add(Armunits);
		Armunits.addActionListener(this);

		Armyunits = new JLabel("Army's Units:");
		Armyunits.setVisible(true);
		Armyunits.setBounds(1120, 50, 200, 80);
		view.add(Armyunits);

		/*
		 * initiate = new JButton("Initiate Army"); initiate.setVisible(true);
		 * initiate.setBounds(810, 70, 100, 20); view.add(initiate);
		 * 
		 * reloc = new JButton("Relocate Unit"); reloc.setVisible(true);
		 * reloc.setBounds(810, 50, 100, 20); view.add(reloc);
		 */

		/*
		 * String[] defarm = new String[10]; defarmyunits = new JComboBox(defarm);
		 * 
		 * view.add(defarmyunits); defarmyunits.setVisible(true);
		 * defarmyunits.setBounds(950, 25, 150, 80);
		 */

		defarmyunits.addActionListener(this);
		choicesofunits = new String[] { "Relocate Unit", "Initiate Army", "Cancel" };

		jcd = new JComboBox();

	}

	public JLabel getPlayer() {
		return player;
	}

	public JLabel getFood() {
		return food;
	}

	public void ishantate(int ind) {
		City c = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}

		}
		Unit a = c.getDefendingArmy().getUnits().get(ind);
		GameView.getGame().getPlayer().initiateArmy(c, a);

	}

	public void reloca(int ind1, int ind2) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];
		City c = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}
		}

		try {
			c.getDefendingArmy().relocateUnit(arm.getUnits().get(ind2));
		} catch (MaxCapacityException e) {
			JOptionPane.showMessageDialog(this, "ARMY MAXED OUT!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void setunitprompt(int ind) {
		City c = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}

		}
		Unit a = c.getDefendingArmy().getUnits().get(ind);
		prompts.setText("Unit Type:" + a.getType() + "\n" + "Level:" + a.getLevel() + "\n" + "Soldiers:"
				+ a.getCurrentSoldierCount() + "\n" + "Maximum amount of soldiers:" + a.getMaxSoldierCount());

	}

	public void setarmyunitprompt(int ind1, int ind2) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
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
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];

		String[] arr = new String[10];
		for (int i = 0; i < arm.getUnits().size(); i++) {
			if (arm.getUnits().get(i) != null) {
				arr[i] = (i + 1) + "-" + " " + arm.getUnits().get(i).getClass().getName().substring(6) + " " + "Lvl:"
						+ arm.getUnits().get(i).getLevel();
				
			}
		}
		Armunits.setModel(new DefaultComboBoxModel(arr));

	}

	public void updateCairoArmies() {

		String[] defarm = new String[10];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = (i + 1) + "-" + " " + "Army";
		}
		Armycombo.setModel(new DefaultComboBoxModel(defarm));

	}

	public void updatedefRec() {
		City c = null;
		// String[] defarm=null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}

		}
		if (c==null)
			return;
		// if (c.getDefendingArmy().getUnits().size() ==
		// c.getDefendingArmy().getMaxToHold())
		// JOptionPane.showMessageDialog(this, "CANNOT RECRUIT ANYMORE!!", "ERROR!!!!!",
		// JOptionPane.ERROR_MESSAGE);

		String[] defarm = new String[450];
		for (int i = 0; i < c.getDefendingArmy().getUnits().size(); i++) {
			defarm[i] = (i + 1) + "-" + " " + c.getDefendingArmy().getUnits().get(i).getClass().getName().substring(6)
					+ " " + "Lvl:" + c.getDefendingArmy().getUnits().get(i).getLevel();
		}
		// view.add(defarmyunits);
		defarmyunits.setModel(new DefaultComboBoxModel(defarm));

	}
	// view.add(defarmyunits);
	// defarmyunits.setModel(new DefaultComboBoxModel(defarm));

	public void updateFTT() {
		String f = (String) ("" + GameView.getGame().getPlayer().getFood());
		String t = (String) ("" + GameView.getGame().getPlayer().getTreasury());
		String turn = (String) ("" + GameView.getGame().getCurrentTurnCount()) + "/50";
		foodl.setText(f);
		goldl.setText(t);
		turns.setText(turn);

	}

	public void relocateEngieDef(int ind1, int ind2) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];
		City c = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}

		}
		Unit a = c.getDefendingArmy().getUnits().get(ind2);

		try {
			arm.relocateUnit(a);
		} catch (MaxCapacityException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "ARMY MAXED OUT!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void relocateEngieArm(int ind1, int ind2, int ind3) {
		Army arm = null;
		Army[] defarm = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm = defarm[ind1];

		Army arm1 = null;
		Army[] defarm1 = new Army[450];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm1[i] = GameView.getGame().getPlayer().getControlledArmies().get(i);
		}
		arm1 = defarm1[ind3];
		try {
			arm.relocateUnit(arm1.getUnits().get(ind2));
		} catch (MaxCapacityException e) {
			JOptionPane.showMessageDialog(this, "ARMY MAXED OUT!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void setprompt(String buildingname) {
		City c = new City("");
		Building b = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}
		}
		if (buildingname.equalsIgnoreCase("Farm")) {
			for (int i = 0; i < c.getEconomicalBuildings().size(); i++) {
				if (c.getEconomicalBuildings().get(i) instanceof Farm) {
					b = (EconomicBuilding) c.getEconomicalBuildings().get(i);
					break;
				}

			}
		}
		if (buildingname.equalsIgnoreCase("Market")) {
			for (int i = 0; i < c.getEconomicalBuildings().size(); i++) {
				if (c.getEconomicalBuildings().get(i) instanceof Market) {
					b = (EconomicBuilding) c.getEconomicalBuildings().get(i);
					break;
				}
			}
		}
		if (buildingname.equalsIgnoreCase("Barracks")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof Barracks) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}
		if (buildingname.equalsIgnoreCase("Stable")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof Stable) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}

		if (buildingname.equalsIgnoreCase("ArcheryRange")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}
		if (b instanceof EconomicBuilding) {
			prompts.setText("Building Type:" + "Economical" + "\n" + "Building Name:" + buildingname + "\n"
					+ "Building Level:" + b.getLevel() + "\n" + "Upgrade Cost:" + b.getUpgradeCost() + "\n"
					+ (b.isCoolDown() ? "Cooling down" : "Ready for upgrading!"));
		}
		if (b instanceof MilitaryBuilding) {
			MilitaryBuilding m = (MilitaryBuilding) b;
			prompts.setText("Building Type:" + "Military" + "\n" + "Building Name:" + buildingname + "\n"
					+ "Building Level:" + b.getLevel() + "" + "\n" + "Upgrade Cost:" + b.getUpgradeCost() + "\n"
					+ "Recruitment Cost:" + m.getRecruitmentCost() + "\n" + "No. of Recruited Units:"
					+ m.getCurrentRecruit() + "\n"
					+ (m.isCoolDown() ? "Cooling down" : "Ready for upgrading/recruiting!"));
		}

	}

	public JLabel getGold() {
		return gold;
	}

	public void relocateGUI() {

	}

	public void upgradebuildings(String buildingname) {
		City c = new City("");
		Building b = null;
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledCities().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("rome")) {
				c = GameView.getGame().getPlayer().getControlledCities().get(i);
				break;
			}
		}
		if (buildingname.equalsIgnoreCase("Farm")) {
			for (int i = 0; i < c.getEconomicalBuildings().size(); i++) {
				if (c.getEconomicalBuildings().get(i) instanceof Farm) {
					b = (EconomicBuilding) c.getEconomicalBuildings().get(i);
					break;
				}

			}
		}
		if (buildingname.equalsIgnoreCase("Market")) {
			for (int i = 0; i < c.getEconomicalBuildings().size(); i++) {
				if (c.getEconomicalBuildings().get(i) instanceof Market) {
					b = (EconomicBuilding) c.getEconomicalBuildings().get(i);
					break;
				}
			}
		}
		if (buildingname.equalsIgnoreCase("Barracks")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof Barracks) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}
		if (buildingname.equalsIgnoreCase("Stable")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof Stable) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}

		if (buildingname.equalsIgnoreCase("ArcheryRange")) {
			for (int i = 0; i < c.getMilitaryBuildings().size(); i++) {
				if (c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
					b = (MilitaryBuilding) c.getMilitaryBuildings().get(i);
					break;
				}
			}
		}
		
			try {
				GameView.getGame().getPlayer().upgradeBuilding(b);
			} catch (NotEnoughGoldException e) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		catch (BuildingInCoolDownException e) {
			JOptionPane.showMessageDialog(this, "BUILDING IS IN COOLDOWN!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (MaxLevelException e) {
			JOptionPane.showMessageDialog(this, "BUILDING MAXED OUT!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		this.setprompt(buildingname);
		GameView.updateAll();
	}

	public String[] returnArmies() {
		String[] defarm = new String[10];
		for (int i = 0; i < GameView.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (GameView.getGame().getPlayer().getControlledArmies().get(i).getCurrentLocation()
					.equalsIgnoreCase("Rome"))
				defarm[i] = (i + 1) + "-" + " " + "Army";
		}
		return defarm;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mapv) {
			GameView.getMapView().setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == build) {
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"What would you like to build?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					buildings, // the titles of buttons
					"Cancel");// default button title

			if (n == 0) {
				if (ArcheryRange.isVisible())
					JOptionPane.showMessageDialog(this, "YOU HAVE ALREADY BUILT ONE!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				try {
					GameView.getGame().getPlayer().build("ArcheryRange", "Rome");
				} catch (NotEnoughGoldException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				GameView.updateAll();
				ArcheryRange.setVisible(true);
			}
			if (n == 4) {
				if (Market.isVisible())
					JOptionPane.showMessageDialog(this, "YOU HAVE ALREADY BUILT ONE!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				try {
					GameView.getGame().getPlayer().build("Market", "Rome");
				} catch (NotEnoughGoldException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				GameView.updateAll();
				Market.setVisible(true);
			}
			if (n == 2) {
				if (Stable.isVisible())
					JOptionPane.showMessageDialog(this, "YOU HAVE ALREADY BUILT ONE!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				try {
					GameView.getGame().getPlayer().build("Stable", "Rome");
				} catch (NotEnoughGoldException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				GameView.updateAll();
				Stable.setVisible(true);
			}
			if (n == 1) {
				if (Barracks.isVisible())
					JOptionPane.showMessageDialog(this, "YOU HAVE ALREADY BUILT ONE!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				try {
					GameView.getGame().getPlayer().build("Barracks", "Rome");
				} catch (NotEnoughGoldException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				GameView.updateAll();
				Barracks.setVisible(true);
			}
			if (n == 3) {
				if (Farm.isVisible())
					JOptionPane.showMessageDialog(this, "YOU HAVE ALREADY BUILT ONE!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				try {
					GameView.getGame().getPlayer().build("Farm", "Rome");
				} catch (NotEnoughGoldException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				GameView.updateAll();
				Farm.setVisible(true);
			}
		}
		if (e.getSource() == Farm) {
			this.setprompt("Farm");
			int n = JOptionPane.showConfirmDialog(null, "Would you like to upgrade?", "",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (n) {
			case 0:
				this.upgradebuildings("Farm");
				GameView.updateAll();
				break; // Yes option
			case 1:
				break; // No option
			case 2:
				break;
			case -1:
				break;// Cancel option
			}
		}
		if (e.getSource() == Market) {
			this.setprompt("Market");
			int n = JOptionPane.showConfirmDialog(null, "Would you like to upgrade?", "",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (n) {
			case 0:
				this.upgradebuildings("Market");
				GameView.updateAll();
				break; // Yes option
			case 1:
				break; // No option
			case 2:
				break;
			case -1:
				break;// Cancel option
			}

		}
		if (e.getSource() == ArcheryRange) {
			this.setprompt("ArcheryRange");

			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"What would you like to do?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					choices, // the titles of buttons
					choices[2]);// default button title
			switch (n) {
			case 0:
				this.upgradebuildings("ArcheryRange");
				GameView.updateAll();
				break; // Yes option
			case 1:
				try {
					GameView.getGame().getPlayer().recruitUnit("Archer", "Rome");
					updatedefRec();
					GameView.updateAll();
					setprompt("ArcheryRange");
				} catch (BuildingInCoolDownException e1) {
					JOptionPane.showMessageDialog(this, "BUILDING IS IN COOLDOWN!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (MaxRecruitedException e1) {
					JOptionPane.showMessageDialog(this, "MAX RECRUITS REACHED!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);

				} catch (NotEnoughGoldException e1) {
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);

				}

				break; // Recruit
			case 2:
				break;
			case -1:
				break;// Cancel option
			}
		}
		if (e.getSource() == Barracks) {
			this.setprompt("Barracks");
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"What would you like to do?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					choices, // the titles of buttons
					choices[2]);// default button title
			switch (n) {
			case 0:
				this.upgradebuildings("Barracks");
				GameView.updateAll();
				break; // Yes option
			case 1:
				try {

					GameView.getGame().getPlayer().recruitUnit("Infantry", "Rome");
					updatedefRec();
					GameView.updateAll();
					setprompt("Barracks");
				} catch (BuildingInCoolDownException e1) {
					JOptionPane.showMessageDialog(this, "BUILDING IS IN COOLDOWN!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (MaxRecruitedException e1) {
					JOptionPane.showMessageDialog(this, "MAX RECRUITS REACHED!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);

				} catch (NotEnoughGoldException e1) {
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);

				}

				break; // Recruit
			case 2:
				break;
			case -1:
				break;// Cancel option
			}
		}
		if (e.getSource() == Stable) {
			this.setprompt("Stable");
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"What would you like to do?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					choices, // the titles of buttons
					choices[2]);// default button title
			switch (n) {
			case 0:
				this.upgradebuildings("Stable");
				GameView.updateAll();
				break; // Yes option
			case 1:
				try {

					GameView.getGame().getPlayer().recruitUnit("Cavalry", "Rome");
					updatedefRec();
					GameView.updateAll();
					setprompt("Stable");
				} catch (BuildingInCoolDownException e1) {
					JOptionPane.showMessageDialog(this, "BUILDING IS IN COOLDOWN!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (MaxRecruitedException e1) {
					JOptionPane.showMessageDialog(this, "MAX RECRUITS REACHED!!", "ERROR!!!!!",
							JOptionPane.ERROR_MESSAGE);

				} catch (NotEnoughGoldException e1) {
					JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD!!", "ERROR!!!!!", JOptionPane.ERROR_MESSAGE);

				}

				break; // Recruit
			case 2:
				break;
			case -1:
				break;// Cancel option
			}
		}

		if (e.getSource() == Endt) {
			GameView.getGame().endTurn();
			this.setprompt("Farm");
			this.setprompt("Barracks");
			this.setprompt("Market");
			this.setprompt("Stable");
			this.setprompt("ArcheryRange");
			GameView.updateAll();
			GameView.gameov();

		}

		if (e.getSource() == defarmyunits) {
			this.setunitprompt(defarmyunits.getSelectedIndex());
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"What would you like to do?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					choicesofunits, // the titles of buttons
					choicesofunits[2]);// default button title
			switch (n) {
			case 0:
				jcd.setModel(new DefaultComboBoxModel(returnArmies()));
				JOptionPane.showMessageDialog(null, jcd, "To which army?", JOptionPane.QUESTION_MESSAGE);
				if (jcd.getSelectedIndex() == JOptionPane.CLOSED_OPTION)
					break;
				else {
					relocateEngieDef(jcd.getSelectedIndex(), defarmyunits.getSelectedIndex());
					updatedefRec();
					updateCairoArmies();
				}

				break; // Yes option
			case 1:
				ishantate(defarmyunits.getSelectedIndex());
				updatedefRec();
				updateCairoArmies();
				break;
			case -1:
				break;
			}
			GameView.getMapView().setcontrolledarmiescombo();

		}
		if (e.getSource() == Armunits) {
			setarmyunitprompt(Armycombo.getSelectedIndex(), Armunits.getSelectedIndex());
			int n = JOptionPane.showOptionDialog(this, // parent container of JOptionPane
					"Where would you like to relocate?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, // do not use a custom Icon
					yesorno, // the titles of buttons
					yesorno[2]);// default button title
			switch (n) {
			case 0:
				jcd.setModel(new DefaultComboBoxModel(returnArmies()));
				JOptionPane.showMessageDialog(null, jcd, "To which army?", JOptionPane.QUESTION_MESSAGE);
				if (jcd.getSelectedIndex() == JOptionPane.CLOSED_OPTION)
					break;
				else {
					relocateEngieArm(jcd.getSelectedIndex(), Armunits.getSelectedIndex(), Armycombo.getSelectedIndex());
					setarmyunit(Armycombo.getSelectedIndex());
					updateCairoArmies();
				}
				break; // Yes option
			case 1:
				reloca(Armycombo.getSelectedIndex(), Armunits.getSelectedIndex());
				updateCairoArmies();
				updatedefRec();
				setarmyunit(Armycombo.getSelectedIndex());
				break;
			case 2:
				break;
			}
			GameView.getMapView().setcontrolledarmiescombo();

		}
		if (e.getSource() == Armycombo) {
			setarmyunit(Armycombo.getSelectedIndex());
			// setarmyunitprompt(Armycombo.getSelectedIndex(), Armunits.getSelectedIndex());

		}
	}
}
