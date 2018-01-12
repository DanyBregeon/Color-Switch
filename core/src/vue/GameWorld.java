package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import modele.Personnage;

public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 17, 12);
	private Personnage bille;

	public GameWorld(float milieuX) {
		bille = new Personnage(milieuX,102,30,60,5,10);
	}
	
	public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        //test rectangle
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
        
        bille.update(delta);        
    }

	public Personnage getBille() {
		return bille;
	}

	public Rectangle getRect() {
		return rect;
	}
	
}
