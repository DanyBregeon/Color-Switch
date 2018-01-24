package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Sol {
	private Rectangle rectangle;
	
	
	public Sol(float x, float y) {
		rectangle = new Rectangle(x,y,Gdx.graphics.getWidth()/5,3);
	}
	
	public void Move(float delta, float hauteur) {
		Vector2 v = new Vector2(rectangle.x,rectangle.y);
		v.add(new Vector2(0, -hauteur).scl(delta));
		rectangle.y = v.y;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
	
}
