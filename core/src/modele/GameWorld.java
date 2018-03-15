package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.gdx.colorswitch.ColorSwitch;

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
	private Lave lava;
	public static int nbObstacle = 6;
	public static Color[] couleurs = {new Color(1,1,0,1), new Color(0,1,1,1),new Color(1,0,1,1),new Color(0.5f,0,1,1)};
	public static int modeDeJeu = 0;
	public static boolean son = true;
	
	public GameWorld(int largeurFenetre, int hauteurFenetre, int mdj, boolean sonActif) {
		son = sonActif;
		modeDeJeu=mdj;
		if(mdj==2) {
			lava = new Lave(0,(int) (hauteurFenetre*1.55f), 2.3f, (int) (hauteurFenetre*1.25f));
		}
		score = 0;
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		bille = new Personnage(largeurFenetre/2,hauteurFenetre*0.8f,640*ColorSwitch.ratioTailleEcran,40*ColorSwitch.ratioTailleEcran,16*ColorSwitch.ratioTailleEcran);
		//bille = new Personnage(milieuX,408,16,1,16);
		obstacles = new Obstacle[3];
		idObstacle = new int[3];
		changementCouleurs = new ChangeColor[3];
		//distanceEntreObstacle = 500;
		sol = new Sol(largeurFenetre/2-largeurFenetre/10,bille.getPosition().y+bille.getTaille());
		//obstacles[0] = new BarreHorizontale(0, hauteurFenetre/4, 1,2,1);
		//obstacles[0] = new CercleObstacle(largeurFenetre/2, hauteurFenetre/4, 1,2,1);
		//obstacles[1] = new BarreHorizontale(0, hauteurFenetre/4-distanceEntreObstacle, 1,2,1);
		//obstacles[2] = new BarreHorizontale(0, hauteurFenetre/4-2*distanceEntreObstacle, 1,2,1);
		creerObstacle(0, hauteurFenetre/2/*hauteurFenetre/4*/);
		if(getIdObstacle()[0]==6 && bille.getCouleur()==GameWorld.couleurs[3]) {
			bille.setCouleur(GameWorld.couleurs[0]);
		}
		changementCouleurs[0] = new ChangeColor(largeurFenetre/2, obstacles[0].getPosition().y - obstacles[0].getHauteurPlusDistance());
		creerObstacle(1, changementCouleurs[0].getPosition().y);
		changementCouleurs[1] = new ChangeColor(largeurFenetre/2, obstacles[1].getPosition().y - obstacles[1].getHauteurPlusDistance());
		creerObstacle(2, changementCouleurs[1].getPosition().y);
		changementCouleurs[2] = new ChangeColor(largeurFenetre/2, obstacles[2].getPosition().y - obstacles[2].getHauteurPlusDistance());
		//Gdx.app.log("world", String.valueOf(changementCouleurs[0].getPosition().y));
	}
	
	public void update(float delta) {
		hauteur = bille.update(delta);
		if(modeDeJeu==2 && !bille.isStart()) {
			lava.Move(delta, hauteur);
			if(lava.getPosition().y-bille.getPosition().y>lava.getDistanceMaxPersonnage()) {
				lava.setPosition((int)bille.getPosition().y+lava.getDistanceMaxPersonnage());
			}
			Gdx.app.log("gameworld", String.valueOf(lava.getPosition().y-bille.getPosition().y));
		}
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
		float randomTaille = 1;
		if(modeDeJeu==1) {
			randomTaille = (float) ((Math.random()*0.7f) + 0.7f);
		}
		//random = 6;
		//Gdx.app.log("GameWorld", String.valueOf((float)Math.pow(1+score, 1/3f)));
		switch (random) {
		
			case 1:
			obstacles[num] = new BarreHorizontale(largeurFenetre/2, y, 1*randomTaille*ColorSwitch.ratioTailleEcran,2+(float)Math.pow(2+score, 1/3f),1);			
			break;
			
			case 2:
			obstacles[num] = new CercleObstacle(largeurFenetre/2, y, 1.2f*randomTaille*ColorSwitch.ratioTailleEcran,(float)Math.pow(1+score, 1/3f),1);			
			break;
					
			case 3:
			obstacles[num] = new CarreObstacle(largeurFenetre/2, y, 1.2f*randomTaille*ColorSwitch.ratioTailleEcran,(float)Math.pow(0.5+score, 1/3f),1);
			break;
			
			case 4:
			obstacles[num] = new CercleSynchroObstacle(largeurFenetre/2, y, 0.95f*randomTaille*ColorSwitch.ratioTailleEcran,(float)Math.pow(1.5f+score, 1/3f),1);
			break;
			
			case 5:
			obstacles[num] = new TripleCercleObstacle(largeurFenetre/2, y, 1.1f*randomTaille*ColorSwitch.ratioTailleEcran,(float)Math.pow(0.75f+score, 1/3f),1);
			break;
			
			case 6:
			obstacles[num] = new TriangleObstacle(largeurFenetre/2, y, 0.7f*randomTaille*ColorSwitch.ratioTailleEcran,(float)Math.pow(0.5+score, 1/3f),1);
			//colorTriInBilleStart(num);
			break;
		}
		idObstacle[num] = random;
	}
	
	/*public void colorTriInBilleStart(int num) { //change
		if(num==0 && getObstacles()[1]==null) {
			Color[] colTab= ((TriangleObstacle)getObstacles()[0]).getCouleursRectangles();
			int randomRect = (int)(Math.random() * 3);
			getBille().setCouleur(colTab[randomRect]);
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
		}
	
	}*/
	
	public void saveScore() {
		Preferences ScorePref = Gdx.app.getPreferences("ScorePref");
		
		if(modeDeJeu==0) {
			if(score> ScorePref.getInteger("score",0)) {
				ScorePref.putInteger("score",  score);
				Gdx.app.log("Best score", Integer.toString(ScorePref.getInteger("score")));
			}
		}else if(modeDeJeu==1) {
			if(score> ScorePref.getInteger("score1",0)) {
				ScorePref.putInteger("score1",  score);
				Gdx.app.log("Best score", Integer.toString(ScorePref.getInteger("score1")));
			}
		}else if(modeDeJeu==2) {
			if(score> ScorePref.getInteger("score2",0)) {
				ScorePref.putInteger("score2",  score);
				Gdx.app.log("Best score", Integer.toString(ScorePref.getInteger("score2")));
			}
		}
		ScorePref.flush();
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

	public Lave getLava() {
		return lava;
	}
	
}
