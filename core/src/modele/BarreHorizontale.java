package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BarreHorizontale extends Obstacle{

	private Rectangle[] rectangles;
	private Color[] couleursRectangles;

	public BarreHorizontale(float x, float y, float taille, float vitesse, int difficulte) {
		super(x,y, taille,vitesse, difficulte);
		rectangles = new Rectangle[5];
		couleursRectangles = new Color[5];
		couleursRectangles[0] = new Color(1,1,0,1);
		couleursRectangles[1] = new Color(1,0,1,1);
		couleursRectangles[2] = new Color(0,1,1,1);
		couleursRectangles[3] = new Color(0.5f,0,1,1);
		couleursRectangles[4] = new Color(1,1,0,1);
		rectangles[0] = new Rectangle(this.position.x, this.position.y, 136,17);
		rectangles[1] = new Rectangle(position.x+136, position.y, 136,17);
		rectangles[2] = new Rectangle(position.x+272, position.y, 136,17);
		rectangles[3] = new Rectangle(position.x+408, position.y, 136,17);
		rectangles[4] = new Rectangle(position.x+544, position.y, 136,17);
	}
	
	@Override
	public void Move(float delta, float hauteur) {
		for(int i=0; i<rectangles.length; i++) {
			//Gdx.app.log("BarreH", rectangles[i].toString() + "  " + i);
			rectangles[i].y -= hauteur/60;
			rectangles[i].x += vitesse;
			if(rectangles[i].x >= 544) {
				rectangles[i].x = -136;
				if(i==0) {
					couleursRectangles[i] = couleursRectangles[couleursRectangles.length-1];
				}else {
					couleursRectangles[i] = couleursRectangles[i-1];
				}
			}
			//rectangles[i].setPosition(rectangles[i].getPosition(new Vector2()).add(new Vector2(5,0)).scl(delta));
			//rectangles[i].setPosition(new Vector2(rectangles[i].getX()+50,rectangles[i].getY()).scl(delta));
			//rectangles[i].setPosition(new Vector2(0,0).scl(delta));
		}
	}
	
	public Rectangle[] getRectangles() {
		return rectangles;
	}

	public Color[] getCouleursRectangles() {
		return couleursRectangles;
	}

}
