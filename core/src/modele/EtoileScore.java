package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.gdx.colorswitch.ColorSwitch;

public class EtoileScore {
	private Vector2 position;
	private float rayon;
	private Circle cercle;
	private boolean vivant;

	
	public EtoileScore(float x, float y) {
		position = new Vector2(x,y);
		rayon = 20*ColorSwitch.ratioTailleEcran;
		cercle = new Circle(position,rayon);
		vivant = true;
	}
	
	public void Move(float delta, float hauteur) {
		Vector2 v = new Vector2(position.x,position.y);
		v.add(new Vector2(0, -hauteur).scl(delta));
		position.y = v.y;
		cercle.y = position.y;
	}
		
	public Vector2 getPosition() {
		return position;
	}

	public float getRayon() {
		return rayon;
	}

	public Circle getCercle() {
		return cercle;
	}

	public void setPosition(float y) {
		this.position.y = y;
	}

	public boolean isVivant() {
		return vivant;
	}

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	
}
