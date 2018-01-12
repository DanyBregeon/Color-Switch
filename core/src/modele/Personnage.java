package modele;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Personnage {
	private Vector2 position;
	private Color couleur;
	private float hauteurSaut;
	private float poids;
	private float taille;
	private float vitesseSaut;
	private float tempsRestantSaut;
	
	public Personnage(float x, float y, float hauteurSaut, float poids, float taille, float vitesseSaut) {
		position = new Vector2(x,y);
		this.hauteurSaut = hauteurSaut;
		this.poids = poids;
		this.taille = taille;
		this.vitesseSaut = vitesseSaut;
		couleur = new Color(0 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
		tempsRestantSaut = 0;
	}
	
	public void update(float delta) {
		if(tempsRestantSaut>0) {
			tempsRestantSaut--;
			position.add(new Vector2(0, -hauteurSaut*vitesseSaut).scl(delta));
		}
		position.add(new Vector2(0, poids).scl(delta));
	}
	
	public void onClick() {
		tempsRestantSaut = 60*(1/vitesseSaut);
		//position.add(new Vector2(0, -hauteurSaut));
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
