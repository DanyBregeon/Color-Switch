package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import modele.GameWorld;
import modele.Personnage;

public class InputHandler implements InputProcessor{
	
	private Personnage maBille;
	
	public InputHandler(Personnage bille) {
		maBille = bille;
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(GameWorld.modeDeJeu==2) {
			if(keycode == Input.Keys.SPACE) {
				if(maBille.getCouleur()==GameWorld.couleurs[0]) {
					maBille.setCouleur(GameWorld.couleurs[1]);
				}
				else if(maBille.getCouleur()==GameWorld.couleurs[1]) {
					maBille.setCouleur(GameWorld.couleurs[2]);
				}
				else if(maBille.getCouleur()==GameWorld.couleurs[2]) {
					maBille.setCouleur(GameWorld.couleurs[3]);
				}
				else if(maBille.getCouleur()==GameWorld.couleurs[3]) {
					maBille.setCouleur(GameWorld.couleurs[0]);
				}	
			}
			else if(keycode == Input.Keys.NUM_1) {
				maBille.setCouleur(GameWorld.couleurs[0]);
			}
			else if(keycode == Input.Keys.NUM_2) {
				maBille.setCouleur(GameWorld.couleurs[1]);
			}
			else if(keycode == Input.Keys.NUM_3) {
				maBille.setCouleur(GameWorld.couleurs[2]);
			}
			else if(keycode == Input.Keys.NUM_4) {
				maBille.setCouleur(GameWorld.couleurs[3]);
			}
		}
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
		maBille.onClick();
		if(GameWorld.son) {
			maBille.getSound().play();
		}
		return true;
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
