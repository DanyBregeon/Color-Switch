package modele;

import com.badlogic.gdx.Gdx;

public class MenuWorld{
	private Bouton[] boutons;
	private Obstacle[] obstacles;
	private int nbBoutons = 5;
	
	public MenuWorld() {
		boutons = new Bouton[nbBoutons];
		boutons[0]= new Bouton(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,86);
		boutons[1]= new Bouton(Gdx.graphics.getWidth()*(7f/8f),Gdx.graphics.getHeight()*(11f/12f),43);
		boutons[2]= new Bouton(Gdx.graphics.getWidth()*(1f/8f),Gdx.graphics.getHeight()*(11f/12f),43);
		boutons[3]= new Bouton(Gdx.graphics.getWidth()*(3f/8f),Gdx.graphics.getHeight()*(11f/12f),43);
		boutons[4]= new Bouton(Gdx.graphics.getWidth()*(5f/8f),Gdx.graphics.getHeight()*(11f/12f),43);
		
		obstacles = new Obstacle[5];
		obstacles[0] = new CercleObstacle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2+200*2f, 2f,1,1);
		obstacles[1] = new CercleObstacle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2+200*1.57f, 1.57f,-1,1);
		obstacles[2] = new CercleObstacle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2+200*1.2f, 1.2f,1,1);
		obstacles[3] = new CercleObstacle(Gdx.graphics.getWidth()/2-53, Gdx.graphics.getHeight()/9+200*0.33f, 0.33f,2,1);
		obstacles[4] = new CercleObstacle(Gdx.graphics.getWidth()/2+55, Gdx.graphics.getHeight()/9+200*0.33f, 0.33f,-2,1);
	}
	
	public void update(float delta) {
		for(int i=0; i<obstacles.length; i++) {
			obstacles[i].Move(delta, 0);
		}
	}

	public Bouton[] getBoutons() {
		return boutons;
	}
	
	public Obstacle[] getObstacles() {
		return obstacles;
	}
	
}
