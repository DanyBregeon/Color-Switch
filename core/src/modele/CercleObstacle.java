package modele;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class CercleObstacle extends Obstacle{

	private Arc[] arcs;
	
	public CercleObstacle(float x, float y, float taille, float vitesse, int difficulte) {
		super(x, y, taille, vitesse, difficulte);
		id = 2;
		arcs = new Arc[4];
		arcs[0] = new Arc(x,y,taille*100,0,90, GameWorld.couleurs[0]);
		arcs[1] = new Arc(x,y,taille*100,90,90, GameWorld.couleurs[1]);
		arcs[2] = new Arc(x,y,taille*100,180,90, GameWorld.couleurs[2]);
		arcs[3] = new Arc(x,y,taille*100,270,90, GameWorld.couleurs[3]);
	}

	public void Move(float delta, float hauteur) {
		for(int i=0; i<arcs.length; i++) {
			Vector2 v = new Vector2(arcs[i].getPosition().x,arcs[i].getPosition().y);
			//rectangles[i].y -= hauteur;
			v.add(new Vector2(0, -hauteur).scl(delta));
			position.y = v.y;
			arcs[i].getPosition().y = v.y;
			arcs[i].setAngleDepart((int)(arcs[i].getAngleDepart()+1*vitesse));
		}
	}

	public Arc[] getArcs() {
		return arcs;
	}

}
