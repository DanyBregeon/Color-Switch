package controleur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;

import modele.BarreHorizontale;
import modele.CercleObstacle;
import modele.ChangeColor;
import modele.GameWorld;

public class Collision {
	private GameWorld myWorld;
	
	public Collision(GameWorld gw) {
		myWorld = gw;
	}
	
	public void update(float delta) {
		//Gdx.app.log("Collision", String.valueOf(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[0]).getRectangles()[0])));

		for(int i=0; i<myWorld.getIdObstacle().length; i++) {
			collisionChangeColor(i);
    		switch (myWorld.getIdObstacle()[i]) {
			case 1: if(collisionBarreHorizontale(i)) {
				Gdx.app.exit();
			}
					break;
			
			case 2: if(collisionCercle(i)) {
				Gdx.app.exit();
			}
					break;
    		}
    	}
	}
	
	public boolean collisionChangeColor(int num) {
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), myWorld.getChangementCouleurs()[num].getCercle())){
			int random = (int)(Math.random() * GameWorld.couleurs.length);
			if(GameWorld.couleurs[random].equals(myWorld.getBille().getCouleur())) {
				if(random == GameWorld.couleurs.length-1) {
					myWorld.getBille().setCouleur(GameWorld.couleurs[0]);
				}else {
					myWorld.getBille().setCouleur(GameWorld.couleurs[random+1]);
				}
			}else {
				myWorld.getBille().setCouleur(GameWorld.couleurs[random]);
			}
			if(num != 0) {
				myWorld.getChangementCouleurs()[num].setPosition(myWorld.getChangementCouleurs()[num-1].getPosition().y-myWorld.getDistanceEntreObstacle());
			}else {
				myWorld.getChangementCouleurs()[num].setPosition(myWorld.getChangementCouleurs()[myWorld.getChangementCouleurs().length-1].getPosition().y-myWorld.getDistanceEntreObstacle());
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean collisionCercle(int num) {
		float posBille = myWorld.getBille().getPosition().y;
		float rayonBille = myWorld.getBille().getTaille();
		float posObs = ((CercleObstacle)myWorld.getObstacles()[num]).getPosition().y;
		float rayonObs = ((CercleObstacle)myWorld.getObstacles()[num]).getTaille()*100;
		if((posBille < posObs + rayonObs + rayonBille && posBille > posObs + rayonObs*0.87 - rayonBille)) {
			for(int i=0; i< ((CercleObstacle)myWorld.getObstacles()[num]).getArcs().length; i++){
				float angleDep = ((CercleObstacle)myWorld.getObstacles()[num]).getArcs()[i].getAngleDepart();
				//on ne sait pas pourquoi il faut mettr eun *5 pour avoir la bonne valeur d'angle
				float angleDepartCollision = (float)Math.atan((rayonObs/rayonBille))*5;
				if(angleDep > angleDepartCollision && angleDep <= 90-angleDepartCollision){
					if(!((CercleObstacle)myWorld.getObstacles()[num]).getArcs()[i].getCouleur().equals(myWorld.getBille().getCouleur())) {
						Gdx.app.log("Collision", "boom");
						return true;
					}
				}else if(angleDep > 90-angleDepartCollision && angleDep < 90+angleDepartCollision) {
					Gdx.app.log("Collision", "boom");
					return true;
				}
			}
		}
		else if (posBille > posObs - rayonObs - rayonBille && posBille < posObs - rayonObs*0.83 + rayonBille) {
			for(int i=0; i< ((CercleObstacle)myWorld.getObstacles()[num]).getArcs().length; i++){
				float angleDep = ((CercleObstacle)myWorld.getObstacles()[num]).getArcs()[i].getAngleDepart();
				float angleDepartCollision = (float)Math.atan((rayonObs/rayonBille))*5;
				if(angleDep > 180+angleDepartCollision && angleDep <= 270-angleDepartCollision){
					if(!((CercleObstacle)myWorld.getObstacles()[num]).getArcs()[i].getCouleur().equals(myWorld.getBille().getCouleur())) {
						Gdx.app.log("Collision", "boom");
						return true;
					}
				}else if(angleDep > 270-angleDepartCollision && angleDep < 270+angleDepartCollision) {
					Gdx.app.log("Collision", "boom");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean collisionBarreHorizontale(int num) {
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[num]).getRectangles()[0])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[num]).getCouleursRectangles()[0])) {
				Gdx.app.log("Collision", "boom");
				return true;
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[num]).getRectangles()[1])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[num]).getCouleursRectangles()[1])) {
				Gdx.app.log("Collision", "boom");
				return true;
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[num]).getRectangles()[2])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[num]).getCouleursRectangles()[2])) {
				Gdx.app.log("Collision", "boom");
				return true;
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[num]).getRectangles()[3])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[num]).getCouleursRectangles()[3])) {
				Gdx.app.log("Collision", "boom");
				return true;
			}
		}
		if(Intersector.overlaps(myWorld.getBille().getHitBox(), ((BarreHorizontale)myWorld.getObstacles()[num]).getRectangles()[4])){
			if(!myWorld.getBille().getCouleur().equals(((BarreHorizontale)myWorld.getObstacles()[num]).getCouleursRectangles()[4])) {
				Gdx.app.log("Collision", "boom");
				return true;
			}
		}
		return false;
	}
}
