package main;

import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import managers.DecorationManager;
import managers.TileManager;
import scenes.GameOver;
import scenes.GameVictory;
import scenes.Menu;
import scenes.Playing;
import ui.Music;


public class Game extends JFrame implements Runnable {

	private GameScreen gameScreen;
	private Thread gameThread;
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	

	// Classes
	private Render render;
	private Menu menu;
	private Playing playing;
	private GameOver gameOver;
        private TileManager tileManager;
        private DecorationManager decorationManager;
        private Music music;
        private GameVictory gameVictory;
	public Game() {
		initClasses();
                this.setTitle("Tower Defense Beginner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		add(gameScreen);
		pack();
		setVisible(true);
	}

	private void initClasses() {
            tileManager = new TileManager();
            decorationManager = new DecorationManager();
            render = new Render(this);
            gameScreen = new GameScreen(this);
            menu = new Menu(this);
            playing = new Playing(this);
            gameOver = new GameOver(this);
            gameVictory = new GameVictory(this);
            music = new Music();
            this.playSound(0);
            this.volumeDown(30);
	}

	

	private void start() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void updateGame() {
            switch(GameStates.gameState){
                case MENU:
                    break;
                case PLAYING:
                    playing.update();
                    break;
                case GAMEOVER:
                    break;
                case GAMEVICTORY:
                    break;
                default:
                    break;
            }
	}

	public static void main(String[] args) {
		Game game = new Game();
                game.gameScreen.initInputs();
		game.start();
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		long now;
		while (true) {

			now = System.nanoTime();
			// Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}

			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}

			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}

		}

	}
        public void playSound(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopSound(){
        music.stop();
    }
    public void playSE(int i){
        music.setFile(i);
        music.play();
    }
    public void volumeUp(){
        music.volumeUp();
    }
    public void volumeDown(){
        music.volumeDown();
    }
    public void volumeUp(int i){
        music.volumeUp(i);
    }
    public void volumeDown(int i){
        music.volumeDown(i);
    }
// Getters and setters
    public Render getRender() {		
        return render;
    }
    public Menu getMenu() {
        return menu;
    }
    public Playing getPlaying() {
        return playing;
    }
    public GameOver getGameOver() {
        return gameOver;
    }

    public GameVictory getGameVictory() {
        return gameVictory;
    }
    
    public TileManager getTileManager(){
        return tileManager;
    }
    public DecorationManager getDecorationManager() {
        return decorationManager;
    }

    public Music getMusic() {
        return music;
    }
    
    
        
}