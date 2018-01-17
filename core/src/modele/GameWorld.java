package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 17, 12);
	private Personnage bille;
	private float hauteur;
	private Obstacle[] obstacles;
	private int distanceEntreObstacle;
	private int hauteurFenetre;
	private int largeurFenetre;
	public static Color[] couleurs = {new Color(1,1,0,1), new Color(0,1,1,1),new Color(1,0,1,1),new Color(0.5f,0,1,1)};
	
	public GameWorld(int largeurFenetre, int hauteurFenetre) {
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		bille = new Personnage(largeurFenetre/2,hauteurFenetre/2,640,40,16);
		//bille = new Personnage(milieuX,408,16,1,16);
		obstacles = new Obstacle[3];
		distanceEntreObstacle = 400;
		//obstacles[0] = new BarreHorizontale(0, hauteurFenetre/4, 1,2,1);
		obstacles[0] = new CercleObstacle(largeurFenetre/2, hauteurFenetre/4, 1,2,1);
		obstacles[1] = new BarreHorizontale(0, hauteurFenetre/4-distanceEntreObstacle, 1,2,1);
		obstacles[2] = new BarreHorizontale(0, hauteurFenetre/4-2*distanceEntreObstacle, 1,2,1);
	}
	
	public void update(float delta) {
		hauteur = bille.update(delta);
		obstacles[0].Move(delta, hauteur);
		obstacles[1].Move(delta, hauteur);
		obstacles[2].Move(delta, hauteur);
		//Gdx.app.log("GameWorld", String.valueOf(obstacles[0].getPosition().y) + "   " + String.valueOf(obstacles[2].getPosition().y));
		if(obstacles[0].getPosition().y>hauteurFenetre*1.4) {
			obstacles[0] = new BarreHorizontale(0, obstacles[2].getPosition().y-distanceEntreObstacle, 1,2,1);
		}
		else if(obstacles[1].getPosition().y>hauteurFenetre*1.4) {
			obstacles[1] = new BarreHorizontale(0, obstacles[0].getPosition().y-distanceEntreObstacle, 1,2,1);
		}
		else if(obstacles[2].getPosition().y>hauteurFenetre*1.4) {
			obstacles[2] = new BarreHorizontale(0, obstacles[1].getPosition().y-distanceEntreObstacle, 1,2,1);
		}
        //Gdx.app.log("GameWorld", "update");
           
    }

	public Personnage getBille() {
		return bille;
	}

	public Rectangle getRect() {
		return rect;
	}

	public Obstacle[] getObstacles() {
		return obstacles;
	}
}
