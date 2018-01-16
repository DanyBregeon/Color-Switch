package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 17, 12);
	private Personnage bille;
	private Obstacle obs;

	public Obstacle getObs() {
		return obs;
	}

	public GameWorld(float milieuX) {
		bille = new Personnage(milieuX,408,640,40,16);
		obs = new BarreHorizontale(0, 200, 1,1,1);
	}
	
	public void update(float delta) {
		obs.Move(delta);
        bille.update(delta);    
        //Gdx.app.log("GameWorld", "update");
           
    }

	public Personnage getBille() {
		return bille;
	}

	public Rectangle getRect() {
		return rect;
	}
	
}
