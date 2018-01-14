package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Personnage {
	private Vector2 position;
	private Color couleur;
	private float hauteurSaut;
	private float poids;
	private float taille;
	private float acceleration;
	
	public Personnage(float x, float y, float hauteurSaut, float poids, float taille) {
		position = new Vector2(x,y);
		this.hauteurSaut = hauteurSaut;
		this.poids = poids;
		this.taille = taille;
		couleur = new Color(0 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
		acceleration = 0;
	}
	
	public void update(float delta) {
		Gdx.app.log("Personnage", String.valueOf(acceleration));
		acceleration += poids;
		if(acceleration>1200) {
			acceleration = 1200;
		}
		position.add(new Vector2(0, acceleration).scl(delta));
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

}
