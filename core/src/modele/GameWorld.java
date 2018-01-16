package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 17, 12);
	private Personnage bille;
	private float hauteur;
	private Obstacle[] obstacles;

	public GameWorld(float milieuX) {
		bille = new Personnage(milieuX,408,640,40,16);
		//bille = new Personnage(milieuX,408,16,1,16);
		obstacles = new Obstacle[3];
		obstacles[0] = new BarreHorizontale(0, 200, 1,1,1);
		obstacles[1] = new BarreHorizontale(0, -200, 1,1,1);
		obstacles[2] = new BarreHorizontale(0, -600, 1,1,1);
	}
	
	public void update(float delta) {
		hauteur = bille.update(delta);
		obstacles[0].Move(delta, hauteur);
		obstacles[1].Move(delta, hauteur);
		obstacles[2].Move(delta, hauteur);
		Gdx.app.log("GameWorld", String.valueOf(obstacles[0].getPosition().y) + "   " + String.valueOf(obstacles[2].getPosition().y));
		if(obstacles[0].getPosition().y>1200) {
			obstacles[0] = new BarreHorizontale(0, obstacles[2].getPosition().y-400, 1,1,1);
		}
		else if(obstacles[1].getPosition().y>1200) {
			obstacles[1] = new BarreHorizontale(0, obstacles[0].getPosition().y-400, 1,1,1);
		}
		else if(obstacles[2].getPosition().y>1200) {
			obstacles[2] = new BarreHorizontale(0, obstacles[1].getPosition().y-400, 1,1,1);
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
