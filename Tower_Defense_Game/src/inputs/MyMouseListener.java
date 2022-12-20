package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private Game game;
    public MyMouseListener(Game game){
        this.game = game;
    }
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
                    switch(GameStates.gameState){
                        case MENU:
                            game.getMenu().mouseMove(e.getX(), e.getY());
                            break;
                        case PLAYING:
                            game.getPlaying().mouseMove(e.getX(), e.getY());
                            break;
                        case GAMEOVER:
                            game.getGameOver().mouseMove(e.getX(), e.getY());
                            break;
                        case GAMEVICTORY:
                            game.getGameVictory().mouseMove(e.getX(), e.getY());
                            break;
                        default:
                            break;
                    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
                    switch(GameStates.gameState){
                        case MENU:
                            game.getMenu().mouseClicked(e.getX(), e.getY());
                            break;
                        case PLAYING:
                            game.getPlaying().mouseClicked(e.getX(), e.getY());
                            break;
                        case GAMEOVER:
                            game.getGameOver().mouseClicked(e.getX(), e.getY());
                            break;
                        case GAMEVICTORY:
                            game.getGameVictory().mouseClicked(e.getX(), e.getY());
                            break;
                        default:
                            break;
                    }
                }
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
                    switch(GameStates.gameState){
                        case MENU:
                            game.getMenu().mousePressed(e.getX(), e.getY());
                            break;
                        case PLAYING:
                            game.getPlaying().mousePressed(e.getX(), e.getY());
                            break;
                        case GAMEOVER:
                            game.getGameOver().mousePressed(e.getX(), e.getY());
                            break;
                        case GAMEVICTORY:
                            game.getGameVictory().mousePressed(e.getX(), e.getY());
                            break;
                        default:
                            break;
                    }
                }

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
                    switch(GameStates.gameState){
                        case MENU:
                            game.getMenu().mouseReleased(e.getX(), e.getY());
                            break;
                        case PLAYING:
                            game.getPlaying().mouseReleased(e.getX(), e.getY());
                            break;
                        case GAMEOVER:
                            game.getGameOver().mouseReleased(e.getX(), e.getY());
                            break;
                        case GAMEVICTORY:
                            game.getGameVictory().mouseReleased(e.getX(), e.getY());
                            break;
                        default:
                            break;
                    }
                }

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
