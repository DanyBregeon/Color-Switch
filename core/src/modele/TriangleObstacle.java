package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TriangleObstacle extends Obstacle{

	private TrianglePlus[] rectangles;
	private Color[] couleursRectangles;
	
	public TriangleObstacle(float x, float y, float taille, float vitesse, int difficulte) {
		super(x, y, taille, vitesse, difficulte);
		hauteurPlusDistance = 350*taille;
		position.y -= hauteurPlusDistance;
		y -= hauteurPlusDistance;
		etoile.setPosition(y);
		rectangles = new TrianglePlus[3];
		couleursRectangles = new Color[3];
		couleursRectangles[0] = GameWorld.couleurs[0];//new Color(1,1,0,1);
		couleursRectangles[1] = GameWorld.couleurs[1];
		couleursRectangles[2] = GameWorld.couleurs[2];
		
		for(int i=0; i<rectangles.length; i++) {
			rectangles[i] = new TrianglePlus(position.x-201*taille, position.y-125*taille, 373*taille,25*taille);

			rectangles[i].rotate(position.x, position.y, 120*i);
		}
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

	public TrianglePlus[] getRectangles() {
		return rectangles;
	}

	public Color[] getCouleursRectangles() {
		return couleursRectangles;
	}

	public void setCouleursRectangles(int i,Color couleursRectangles) {
		this.couleursRectangles[i] = couleursRectangles;
	}

}