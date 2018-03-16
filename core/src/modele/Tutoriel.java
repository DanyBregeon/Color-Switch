package modele;

import com.badlogic.gdx.math.Vector2;

public class Tutoriel {
	private Vector2 position;
	
	public Tutoriel(float x, float y) {
		position = new Vector2(x,y);
	}
	
	public void Move(float delta, float hauteur) {
		Vector2 v = new Vector2(position.x,position.y);
		v.add(new Vector2(0, -hauteur).scl(delta));
		position.y = v.y;
	}

	public Vector2 getPosition() {
		return position;
	}
	
}
