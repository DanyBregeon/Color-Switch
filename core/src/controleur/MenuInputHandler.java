package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.gdx.colorswitch.ColorSwitch;

import modele.MenuWorld;
import modele.Personnage;

public class MenuInputHandler implements InputProcessor{

	private MenuWorld myWorld;
	private ColorSwitch main;
	
	public MenuInputHandler(ColorSwitch cs, MenuWorld world) {
		myWorld = world;
		main = cs;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		 //(float) Math.sqrt(Math.pow((posBille.x-posObs.x),2) + Math.pow((posBille.y-posObs.y),2));
		if(Math.sqrt(Math.pow((Gdx.input.getX()-myWorld.getBoutons()[0].getPosition().x),2) + Math.pow((Gdx.input.getY()-myWorld.getBoutons()[0].getPosition().y),2)) < myWorld.getBoutons()[0].getTaille()){
			Gdx.app.log("inputMenu", "collision");
			main.setScreen(new GameScreen(main,0));
		}
		else if(Math.sqrt(Math.pow((Gdx.input.getX()-myWorld.getBoutons()[1].getPosition().x),2) + Math.pow((Gdx.input.getY()-myWorld.getBoutons()[1].getPosition().y),2)) < myWorld.getBoutons()[1].getTaille()){
			Gdx.app.log("inputMenu", "collision");
			Gdx.app.exit();
		}
		else if(Math.sqrt(Math.pow((Gdx.input.getX()-myWorld.getBoutons()[2].getPosition().x),2) + Math.pow((Gdx.input.getY()-myWorld.getBoutons()[2].getPosition().y),2)) < myWorld.getBoutons()[2].getTaille()){
			Gdx.app.log("inputMenu", "collision");
			main.setScreen(new GameScreen(main,1));
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
