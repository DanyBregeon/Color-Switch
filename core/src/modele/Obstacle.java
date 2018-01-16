package modele;

import com.badlogic.gdx.math.Vector2;

public abstract class Obstacle {
	protected Vector2 position;
	protected float taille;
	protected float vitesse;
	protected int difficulte;
	
	public Obstacle(float x, float y, float taille, float vitesse, int difficulte) {
		this.position = new Vector2(x,y);
		this.taille = taille;
		this.vitesse = vitesse;
		this.difficulte = difficulte;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public float getTaille() {
		return taille;
	}

	public float getVitesse() {
		return vitesse;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public abstract void Move(float delta, float hauteur);
}
