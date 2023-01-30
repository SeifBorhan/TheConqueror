package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import engine.Game;

@SuppressWarnings("serial")
public class GameView extends JFrame {
	Game game;
	MapView MapView;
	Entery Entery;
	CairoView cairo;
	RomeView rome;
	SpartaView sparta;
	Start start;
	GameOver GameOver;
	BattleView BattleView;
	PreBattleView PreBattleView;
	AutoResolveLose AutoResolveLose;
	AutoResolveWin AutoResolveWin;

	public GameView() {
		MapView = new MapView(this);
		this.add(MapView);
		Entery = new Entery(this);
		this.add(Entery);
		cairo = new CairoView(this);
		this.add(cairo);
		rome = new RomeView(this);
		this.add(rome);
		sparta = new SpartaView(this);
		this.add(sparta);
		start = new Start(this);
		GameOver = new GameOver(this);
		BattleView = new BattleView(this);
		this.add(BattleView);
		PreBattleView = new PreBattleView(this);
		this.add(PreBattleView);
		AutoResolveLose = new AutoResolveLose(this);
		this.add(AutoResolveLose);
		AutoResolveWin = new AutoResolveWin(this);
		this.add(AutoResolveWin);
		this.add(GameOver);
		this.add(start);
		this.setSize(1500, 900);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("The Conqueror");
		
		/*
		 * try { Clip clip = AudioSystem.getClip(); AudioInputStream ais =
		 * AudioSystem.getAudioInputStream(new File("song.mp3")); clip.open(ais);
		 * clip.loop(Clip.LOOP_CONTINUOUSLY); }catch(LineUnavailableException|
		 * UnsupportedAudioFileException| IOException ex) { ex.printStackTrace(); }
		 */

	}

	public static void main(String[] args) {
		new GameView();

	}

	public Game getGame() {
		return game;
	}

	public void startGame() {
		String s = this.getEntery().getInput().getText();
		String l = (String) this.getEntery().getBookList().getSelectedItem();
		this.getMapView().getPlayer().setText(s);
		this.getCairo().getPlayer().setText(s);
		this.getSparta().getPlayer().setText(s);
		this.getRome().getPlayer().setText(s);

		try {
			game = new Game(s, l);
			this.getGame().getPlayer().setFood(0.0);
			this.getGame().getPlayer().setTreasury(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateAll() {
		this.getMapView().updateFTT();
		this.getCairo().updateFTT();
		this.getRome().updateFTT();
		this.getSparta().updateFTT();
		this.BattleView.updateFTT();

	}

	public void gameov() {
		if (this.getGame().isGameOver()) {
			this.GameOver.setVisible(true);
			this.GameOver.WL();
			this.getMapView().setVisible(false);
			this.getCairo().setVisible(false);
			this.getRome().setVisible(false);
			this.getSparta().setVisible(false);
			this.AutoResolveWin.setVisible(false);
			this.AutoResolveLose.setVisible(false);
		}
	}

	public MapView getMapView() {
		return MapView;
	}

	public Entery getEntery() {
		return Entery;
	}

	public CairoView getCairo() {
		return cairo;
	}

	public RomeView getRome() {
		return rome;
	}

	public SpartaView getSparta() {
		return sparta;
	}

}
