package modele;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Arc {
	private Vector2 position;
	private float rayon;
	private int angleDepart;
	private int angle;
	private Color couleur;
	
	public Arc(float x, float y, float rayon, int angleDepart, int angle, Color couleur) {
		position = new Vector2(x,y);
		this.rayon = rayon;
		this.angleDepart = angleDepart;
		this.angle = angle;
		this.couleur = couleur;
	}

	public int getAngleDepart() {
		return angleDepart;
	}

	public void setAngleDepart(int angleDepart) {
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

	public int getAngle() {
		return angle;
	}
	
}
