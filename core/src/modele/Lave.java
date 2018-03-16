package modele;

import com.badlogic.gdx.math.Vector2;
import com.gdx.colorswitch.ColorSwitch;

public class Lave {
	private Vector2 position;
	private float vitesse;
	private int distanceMaxPersonnage;
	private int hauteurMaxLave;
	
	public Lave(int x, int y, float vitesse, int distanceMaxPersonnage) {
		position = new Vector2(x,y);
		this.vitesse = vitesse;
		this.distanceMaxPersonnage = distanceMaxPersonnage;
		hauteurMaxLave = (int) (495*ColorSwitch.ratioTailleEcran);
	}
	
	public void Move(float delta, float hauteur) {
		Vector2 v = new Vector2(position.x,position.y);
		Vector2 v2 = new Vector2(0, -hauteur).scl(delta);
		v.add(v2);
		position.y = v.y-vitesse;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(int y) {
		position = new Vector2(position.x, y);
	}

	public float getVitesse() {
		return vitesse;
	}

	public int getDistanceMaxPersonnage() {
		return distanceMaxPersonnage;
	}

	public int getHauteurMaxLave() {
		return hauteurMaxLave;
	}	
	
}
