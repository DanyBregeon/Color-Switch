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
		//Gdx.app.log("Collision", String.valueOf(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[0])));

		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[0])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[0]).getCouleursRectangles()[0])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[1])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[0]).getCouleursRectangles()[1])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[2])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[0]).getCouleursRectangles()[2])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[3])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[0]).getCouleursRectangles()[3])) {
				Gdx.app.log("Collision", "boom");
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[4])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[0]).getCouleursRectangles()[4])) {
				Gdx.app.log("Collision", "boom");
			}
		}
	}
}
