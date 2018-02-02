package modele;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class Bouton{
	//private Sprite sprite;
	private Vector2 position;
	private Button bouton;
	private Circle hitBox;
	private float taille;
	
	public Bouton(float x, float y, float taille) {
		bouton = new Button();
		position = new Vector2(x,y);
		this.taille = taille;
		hitBox = new Circle(position, taille);
	}

	public Vector2 getPosition() {
		return position;
	}

	public Button getBouton() {
		return bouton;
	}

	public Circle getHitBox() {
		return hitBox;
	}
	
	public float getTaille() {
		return taille;
	}
}
