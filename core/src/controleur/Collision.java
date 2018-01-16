package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;

import modele.BarreHorizontale;
import modele.GameWorld;

public class Collision {
	private GameWorld myWorld;
	
	public Collision(GameWorld gw) {
		myWorld = gw;
	}
	
	public void update(float delta) {
		//Gdx.app.log("Collision", String.valueOf(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[0])));

		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[0])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObs()).getCouleursRectangles()[0])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[1])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObs()).getCouleursRectangles()[1])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[2])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObs()).getCouleursRectangles()[2])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[3])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObs()).getCouleursRectangles()[3])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObs()).getRectangles()[4])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObs()).getCouleursRectangles()[4])) {
				Gdx.app.log("Collision", "boom");
			}
		}
	}
}
