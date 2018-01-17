package modele;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Arc {
	private Vector2 position;
	private float rayon;
	private float angleDepart;
	private float angle;
	private Color couleur;
	
	public Arc(float x, float y, float rayon, float angleDepart, float angle, Color couleur) {
		position = new Vector2(x,y);
		this.rayon = rayon;
		this.angleDepart = angleDepart;
		this.angle = angle;
		this.couleur = couleur;
	}

	public float getAngleDepart() {
		return angleDepart;
	}

	public void setAngleDepart(float angleDepart) {
		this.angleDepart = angleDepart;
	}

	public Color getCouleur() {
		return couleur;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getRayon() {
		return rayon;
	}

	public float getAngle() {
		return angle;
	}
	
}
