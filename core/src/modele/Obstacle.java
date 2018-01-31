package modele;

import com.badlogic.gdx.math.Vector2;

public abstract class Obstacle {
	protected Vector2 position;
	protected float taille;
	protected float vitesse;
	protected int difficulte;
	protected EtoileScore etoile;
	protected float hauteurPlusDistance;
	
	public Obstacle(float x, float y, float taille, float vitesse, int difficulte) {
		this.position = new Vector2(x,y);
		this.taille = taille;
		this.vitesse = vitesse;
		this.difficulte = difficulte;
		this.hauteurPlusDistance = 0;
		etoile = new EtoileScore(x,y);
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
	
	public EtoileScore getEtoile() {
		return etoile;
	}

	public float getHauteurPlusDistance() {
		return hauteurPlusDistance;
	}

	public void Move(float delta, float hauteur) {
		Vector2 v = new Vector2(position.x,position.y);
		Vector2 v2 = new Vector2(0, -hauteur).scl(delta);
		v.add(v2);
		position.y = v.y;
		etoile.Move(delta, hauteur);
	}
}
