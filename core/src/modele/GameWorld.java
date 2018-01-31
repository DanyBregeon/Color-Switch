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
	//private int distanceEntreObstacle;
	private int hauteurFenetre;
	private int largeurFenetre;
	private int score;
	private int[] idObstacle;
	private ChangeColor[] changementCouleurs;
	private Sol sol;
<<<<<<< HEAD
	public static int nbObstacle = 5;
=======
	public static int nbObstacle = 4; //change
>>>>>>> Loïs
	public static Color[] couleurs = {new Color(1,1,0,1), new Color(0,1,1,1),new Color(1,0,1,1),new Color(0.5f,0,1,1)};
	
	public GameWorld(int largeurFenetre, int hauteurFenetre) {
		score = 0;
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		bille = new Personnage(largeurFenetre/2,hauteurFenetre*0.8f,640,40,16);
		//bille = new Personnage(milieuX,408,16,1,16);
<<<<<<< HEAD
		obstacles = new Obstacle[3];
		idObstacle = new int[3];
		changementCouleurs = new ChangeColor[3];
		//distanceEntreObstacle = 500;
=======
		obstacles = new Obstacle[3];//not change
		idObstacle = new int[3];//not change
		changementCouleurs = new ChangeColor[3];//change not sure before 3
		distanceEntreObstacle = 500;
>>>>>>> Loïs
		sol = new Sol(largeurFenetre/2-largeurFenetre/10,bille.getPosition().y+bille.getTaille());
		//obstacles[0] = new BarreHorizontale(0, hauteurFenetre/4, 1,2,1);
		//obstacles[0] = new CercleObstacle(largeurFenetre/2, hauteurFenetre/4, 1,2,1);
		//obstacles[1] = new BarreHorizontale(0, hauteurFenetre/4-distanceEntreObstacle, 1,2,1);
		//obstacles[2] = new BarreHorizontale(0, hauteurFenetre/4-2*distanceEntreObstacle, 1,2,1);
<<<<<<< HEAD
		creerObstacle(0, hauteurFenetre/2/*hauteurFenetre/4*/);
		changementCouleurs[0] = new ChangeColor(largeurFenetre/2, obstacles[0].getPosition().y - obstacles[0].getHauteurPlusDistance());
		creerObstacle(1, changementCouleurs[0].getPosition().y);
		changementCouleurs[1] = new ChangeColor(largeurFenetre/2, obstacles[1].getPosition().y - obstacles[1].getHauteurPlusDistance());
		creerObstacle(2, changementCouleurs[1].getPosition().y);
		changementCouleurs[2] = new ChangeColor(largeurFenetre/2, obstacles[2].getPosition().y - obstacles[2].getHauteurPlusDistance());
=======
		creerObstacle(0, hauteurFenetre/4);
		creerObstacle(1, hauteurFenetre/4-distanceEntreObstacle);
		creerObstacle(2, hauteurFenetre/4-2*distanceEntreObstacle);
		changementCouleurs[0] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -0.5f*distanceEntreObstacle);
		changementCouleurs[1] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -1.5f*distanceEntreObstacle);
		changementCouleurs[2] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -2.5f*distanceEntreObstacle);
		//changementCouleurs[3] = new ChangeColor(largeurFenetre/2, hauteurFenetre/4 -2.5f*distanceEntreObstacle); //change not sure
>>>>>>> Loïs
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
			creerObstacle(0, changementCouleurs[2].getPosition().y);
			changementCouleurs[0].setPosition(obstacles[0].getPosition().y - obstacles[0].getHauteurPlusDistance());
			//obstacles[0] = new BarreHorizontale(0, obstacles[2].getPosition().y-distanceEntreObstacle, 1,2,1);
			//creerObstacle(0, obstacles[2].getPosition().y);
		}
		else if(obstacles[1].getPosition().y>hauteurFenetre*1.4) {
			creerObstacle(1, changementCouleurs[0].getPosition().y);
			changementCouleurs[1].setPosition(obstacles[1].getPosition().y - obstacles[1].getHauteurPlusDistance());
			//obstacles[1] = new BarreHorizontale(0, obstacles[0].getPosition().y-distanceEntreObstacle, 1,2,1);
			//creerObstacle(1, obstacles[0].getPosition().y);
		}
		else if(obstacles[2].getPosition().y>hauteurFenetre*1.4) {
			creerObstacle(2, changementCouleurs[1].getPosition().y);
			changementCouleurs[2].setPosition(obstacles[2].getPosition().y - obstacles[2].getHauteurPlusDistance());
			//obstacles[2] = new BarreHorizontale(0, obstacles[1].getPosition().y-distanceEntreObstacle, 1,2,1);
			//creerObstacle(2, obstacles[1].getPosition().y);
		}
        //Gdx.app.log("GameWorld", "update");
		//Gdx.app.log("GameWorld", String.valueOf(obstacles[0].getPosition().y);
    }
	
	/*private float calculPositionObstacle(int num) {
		if(num != 0) {
			distanceEntreObstacle[num-1] += val;
			distanceEntreObstacle[num] = val;
			if(changementCouleurs[num-1] != null)
			changementCouleurs[num-1].setPosition(changementCouleurs[num-1].getPosition().y-val);
			return distanceEntreObstacle[num-1];
		}else {
			if(changementCouleurs[changementCouleurs.length-1] != null) {
				
			}else {
				
			}
			distanceEntreObstacle[distanceEntreObstacle.length-1] += val;
			distanceEntreObstacle[num] = val;
			if(changementCouleurs[changementCouleurs.length-1] != null)
				changementCouleurs[changementCouleurs.length-1].setPosition(changementCouleurs[changementCouleurs.length-1].getPosition().y-val);
			return distanceEntreObstacle[distanceEntreObstacle.length-1];
		}
	}*/
	
	public void creerObstacle(int num, float y) {
		int random = (int)(Math.random() * nbObstacle) + 1;
<<<<<<< HEAD

		Gdx.app.log("GameWorld", String.valueOf((float)Math.pow(1+score, 1/3f)));
		switch (random) {
		
			case 1: //y -= calculPositionObstacle(num, 250);
			obstacles[num] = new BarreHorizontale(largeurFenetre/2, y, 1,2+(float)Math.pow(2+score, 1/3f),1);			
			break;
			
			case 2:// y -= calculPositionObstacle(num, 250);
			obstacles[num] = new CercleObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(1+score, 1/3f),1);			
			break;
					
			case 3: //y -= calculPositionObstacle(num, 250);
			obstacles[num] = new CarreObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(0.5+score, 1/3f),1);
			break;
			
			case 4: //y -= calculPositionObstacle(num, 250);
			obstacles[num] = new CercleSynchroObstacle(largeurFenetre/2, y, 0.9f,(float)Math.pow(1.5f+score, 1/3f),1);
			break;
			
			case 5:	//y -= calculPositionObstacle(num, 500);
			obstacles[num] = new TripleCercleObstacle(largeurFenetre/2, y, 1.1f,(float)Math.pow(0.75f+score, 1/3f),1);
			break;
=======
		//random = 3; //change
		Gdx.app.log("GameWorld", String.valueOf((float)Math.pow(1+score, 1/3f)));
		switch (random) {
			case 1: obstacles[num] = new BarreHorizontale(largeurFenetre/2, y, 1,2+(float)Math.pow(2+score, 1/3f),1);
				
				break;
			
			case 2: obstacles[num] = new CercleObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(1+score, 1/3f),1);
				
				break;
					
			case 3: obstacles[num] = new CarreObstacle(largeurFenetre/2, y, 1.2f,(float)Math.pow(0.5+score, 1/3f),1);
				
				break;
			case 4: obstacles[num] = new TriangleObstacle(largeurFenetre/2, y, 0.8f,(float)Math.pow(0.5+score, 1/3f),1);
				colorTriInBilleStart(num);
				break; //change
			
>>>>>>> Loïs
		}
		idObstacle[num] = random;
	}
	
	public void colorTriInBilleStart(int num) { //change
		if(num==0 && getObstacles()[1]==null) {
			Color[] colTab= ((TriangleObstacle)getObstacles()[0]).getCouleursRectangles();
			int randomRect = (int)(Math.random() * 3);
			getBille().setCouleur(colTab[randomRect]);
			//Gdx.app.log("GameWorld", "color4");		
		}
	
	}
	
	public void colorTriInBille(int num) { //change
		int nextObstacle;
		if (num==2) {
			nextObstacle=0;
		}else {
			nextObstacle=num+1;
		}	
		if(getIdObstacle()[nextObstacle]==4) {
			Color[] colTab= ((TriangleObstacle)getObstacles()[nextObstacle]).getCouleursRectangles();
			int randomRect = (int)(Math.random() * 3);
			getBille().setCouleur(colTab[randomRect]);
			//Gdx.app.log("GameWorld", "color4");	
		}
	
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
