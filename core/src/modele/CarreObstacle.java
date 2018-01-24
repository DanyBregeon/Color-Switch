package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CarreObstacle extends Obstacle{

	private RectanglePlus[] rectangles;
	private Color[] couleursRectangles;
	
	public CarreObstacle(float x, float y, float taille, float vitesse, int difficulte) {
		super(x, y, taille, vitesse, difficulte);
		rectangles = new RectanglePlus[4];
		couleursRectangles = new Color[4];
		couleursRectangles[0] = GameWorld.couleurs[0];//new Color(1,1,0,1);
		couleursRectangles[1] = GameWorld.couleurs[1];
		couleursRectangles[2] = GameWorld.couleurs[2];
		couleursRectangles[3] = GameWorld.couleurs[3];
		rectangles[0] = new RectanglePlus(position.x-100*taille, position.y-100*taille, 183*taille,17*taille);
		rectangles[1] = new RectanglePlus(position.x+100*taille, position.y-100*taille, -17*taille,183*taille);
		rectangles[2] = new RectanglePlus(position.x+100*taille, position.y+100*taille, -183*taille,-17*taille);
		rectangles[3] = new RectanglePlus(position.x-100*taille, position.y+100*taille, 17*taille,-183*taille);
	}

	public void Move(float delta, float hauteur) {
		super.Move(delta, hauteur);
		Vector2 v2 = new Vector2(0, -hauteur).scl(delta);
		for(int i=0; i<rectangles.length; i++) {
			
			rectangles[i].y += v2.y;
			rectangles[i].getSommets()[1] += v2.y;
			rectangles[i].getSommets()[3] += v2.y;
			rectangles[i].getSommets()[5] += v2.y;
			rectangles[i].getSommets()[7] += v2.y;
			
		}
		for(int i=0; i<rectangles.length; i++) {
			rectangles[i].rotate(position.x, position.y, 1*vitesse);
			rectangles[i].setAngleTotal(rectangles[i].getAngleTotal()+1*vitesse);
		}
		
	}

	public RectanglePlus[] getRectangles() {
		return rectangles;
	}

	public Color[] getCouleursRectangles() {
		return couleursRectangles;
	}

}
