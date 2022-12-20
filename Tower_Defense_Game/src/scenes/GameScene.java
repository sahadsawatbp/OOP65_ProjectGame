package scenes;

import main.Game;

public class GameScene {

	protected Game game;
        protected int tick;
        protected int animationIndex;
        protected int ANIMATION_SPEED = 20;
	public GameScene(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}
        protected void updateTick() {
        tick++;
        if(tick>=ANIMATION_SPEED){
            tick = 0;
            animationIndex++;
            if(animationIndex >= 4){
                animationIndex =0;
            }
        }
    }
}
