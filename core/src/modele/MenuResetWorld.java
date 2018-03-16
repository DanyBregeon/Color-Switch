package modele;

import com.badlogic.gdx.Gdx;
import com.gdx.colorswitch.ColorSwitch;

public class MenuResetWorld {
	private Bouton[] boutons;
	private int nbBoutons = 2;
	private int score;
	
	public MenuResetWorld(int score) {
		boutons = new Bouton[nbBoutons];
		boutons[0] = new Bouton(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()*(3f/4f),86*ColorSwitch.ratioTailleEcran);
		boutons[1] = new Bouton(Gdx.graphics.getWidth()/6,Gdx.graphics.getHeight()/9,42*ColorSwitch.ratioTailleEcran);
		this.score = score;
	}
	
	public void update(float delta){
		
	}
	
	public Bouton[] getBoutons() {
		return boutons;
	}

	public int getScore() {
		return score;
	}

}
