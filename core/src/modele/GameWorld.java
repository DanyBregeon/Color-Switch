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
	private int score;
	private int[] idObstacle;
	private ChangeColor[] changementCouleurs;
	private Sol sol;
	public static int nbObstacle = 3;
	public static Color[] couleurs = {new Color(1,1,0,1), new Color(0,1,1,1),new Color(1,0,1,1),new Color(0.5f,0,1,1)};
	
	public GameWorld(int largeurFenetre, int hauteurFenetre) {
		score = 0;
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		bille = new Personnage(largeurFenetre/2,hauteurFenetre*0.8f,640,40,16);
		//bille = new Personnage(milieuX,408,16,1,16);
		obstacles = new Obstacle[3];
		idObstacle = new int[3];
		changementCouleurs = new ChangeColor[3];
		distanceEntreObstacle = 500;
		sol = new Sol(largeurFenetre/2-largeurFenetre/10,bille.getPosition().y+bille.getTaille());
		//obstacles[0] = new BarreHorizontale(0, hauteurFenetre/4, 1,2,1);
		//obstacles[0] = new CercleObstacle(largeurFenetre/2, hauteurFenetre/4, 1,2,1);
		//obstacles[1] = new BarreHorizontale(0, hauteurFenetre/4-distanceEntreObstacle, 1,2,1);
		//obstacles[2] = new BarreHorizontale(0, hauteurFenetre/4-2*distanceEntreObstacle, 1,2,1);
		creerObstacle(0, hauteurFenetre/4);
		creerObstacle(1, hauteurFenetre/4-distanceEntreObstacle);
		creerObstacle(2, hauteurFenetre/4-2*distanceEntreObstacle);
		changementCouleurs[0] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -0.5f*distanceEntreObstacle);
		changementCouleurs[1] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -1.5f*distanceEntreObstacle);
		changementCouleurs[2] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -2.5f*distanceEntreObstacle);
		//Gdx.app.log("world", String.valueOf(changementCouleurs[0].getPosition().y));
	}
	
	public void update(float delta) {
		hauteur = bille.update(delta);
		for(int i=0; i<obstacles.length; i++) {
			obstacles[i].Move(delta, hauteur);
			changementCouleurs[i].Move(delta, hauteur);
		}
		if(sol != null) {
			sol.Move(delta, hauteur);
			if(sol.getRectangle().y > hauteurFenetre+3) {
				sol = null;
			}
		}
		//Gdx.app.log("GameWorld", String.valueOf(obstacles[0].getPosition().y) + "   " + String.valueOf(obstacles[2].getPosition().y));
		if(obstacles[0].getPosition().y>hauteurFenetre*1.4) {
			//obstacles[0] = new BarreHorizontale(0, obstacles[2].getPosition().y-distanceEntreObstacle, 1,2,1);
			creerObstacle(0, obstacles[2].getPosition().y-distanceEntreObstacle);
		}
		else if(obstacles[1].getPosition().y>hauteurFenetre*1.4) {
			//obstacles[1] = new BarreHorizontale(0, obstacles[0].getPosition().y-distanceEntreObstacle, 1,2,1);
			creerObstacle(1, obstacles[0].getPosition().y-distanceEntreObstacle);
		}
		else if(obstacles[2].getPosition().y>hauteurFenetre*1.4) {
			//obstacles[2] = new BarreHorizontale(0, obstacles[1].getPosition().y-distanceEntreObstacle, 1,2,1);
			creerObstacle(2, obstacles[1].getPosition().y-distanceEntreObstacle);
		}
        //Gdx.app.log("GameWorld", "update");
           
    }
	
	public void creerObstacle(int num, float y) {
		int random = (int)(Math.random() * nbObstacle) + 1;
		//random = 3;
		Gdx.app.log("GameWorld", String.valueOf((float)Math.pow(1+score, 1/3f)));
		switch (random) {
			case 1: obstacles[num] = new BarreHorizontale(largeurFenetre/2, y, 1,2+(float)Math.pow(2+score, 1/3f),1);
					break;
			
			case 2: obstacles[num] = new CercleObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(1+score, 1/3f),1);
					break;
					
			case 3: obstacles[num] = new CarreObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(0.5+score, 1/3f),1);
					break;
		}
		idObstacle[num] = random;
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

	public int[] getIdObstacle() {
		return idObstacle;
	}

	public ChangeColor[] getChangementCouleurs() {
		return changementCouleurs;
	}

	public int getHauteurFenetre() {
		return hauteurFenetre;
	}

	public int getLargeurFenetre() {
		return largeurFenetre;
	}

	public int getDistanceEntreObstacle() {
		return distanceEntreObstacle;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Sol getSol() {
		return sol;
	}
	
}
