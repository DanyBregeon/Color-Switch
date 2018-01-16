package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Personnage {
	private Vector2 position;
	private Color couleur;
	private float hauteurSaut;
	private float poids;
	private float taille;
	private float acceleration;
	private Circle hitBox;
	
	public Personnage(float x, float y, float hauteurSaut, float poids, float taille) {
		position = new Vector2(x,y);
		this.hauteurSaut = hauteurSaut;
		this.poids = poids;
		this.taille = taille;
		couleur = new Color(0, 1, 1, 1);
		acceleration = 0;
		hitBox = new Circle(position, taille);
	}
	
	public float update(float delta) {
		//Gdx.app.log("Personnage", String.valueOf(position.y));
		acceleration += poids;
		if(acceleration>1200) {
			acceleration = 1200;
		}
		//position.add(new Vector2(0, acceleration).scl(delta));
		//hitBox.setPosition(position);
		float diff=0;
		//Gdx.app.log("Personnage",String.valueOf(position.y) + "   " + String.valueOf(acceleration) + "   " + String.valueOf(position.y + acceleration));
		if(position.y + (acceleration/60)<368) {
			position.y = 368;
			diff = position.y + acceleration - 368;
		}else {
			position.add(new Vector2(0, acceleration).scl(delta));
			//position.y+=acceleration;
		}
		hitBox.setPosition(position);
		//Gdx.app.log("Personnage", String.valueOf(diff));
		return diff;
	}
	
	public void onClick() {
		acceleration = -hauteurSaut;
    }

	public Vector2 getPosition() {
		return position;
	}

	public Color getCouleur() {
		return couleur;
	}

	public float getHauteurSaut() {
		return hauteurSaut;
	}

	public float getPoids() {
		return poids;
	}

	public float getTaille() {
		return taille;
	}

	public Circle getHitBox() {
		return hitBox;
	}

}
