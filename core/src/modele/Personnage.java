package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.gdx.colorswitch.ColorSwitch;

import controleur.GameScreen;

public class Personnage {
	private Vector2 position;
	private Color couleur;
	private float hauteurSaut;
	private float poids;
	private float taille;
	private float acceleration;
	private Circle hitBox;
	private boolean start;
	private Sound sound = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
	private Sound soundDie = Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
	private int rand;
	private float vitessex=800f;
	private float vitessey;
	
	
	public Personnage(float x, float y, float hauteurSaut, float poids, float taille) {
		position = new Vector2(x,y);
		this.hauteurSaut = hauteurSaut;
		this.poids = poids;
		this.taille = taille;
		int random = (int)(Math.random() * GameWorld.couleurs.length);
		couleur = GameWorld.couleurs[random];
		acceleration = 0;
		hitBox = new Circle(position, taille*0.98f);
		start = true;
	}

	public void diePersonnage() {
		if(GameWorld.son) {
			soundDie.play();
		}
		//String bla="";
		vitessex=(float)(Math.random()*(vitessex/10))+(vitessex*9/10);
		vitessey=vitessex;
		rand=(int)(Math.random()*360) ;
		//bla+="x:"+rand+"|";
		vitessex=(float)Math.cos(rand)*vitessex;
		rand=(int)(Math.random()*360) ;
		vitessey=(float)Math.cos(rand)*vitessey;
		//bla+="y:"+rand;
		//Gdx.app.log("Personnage", bla);
		
	}
	
	public float update(float delta) {
		
		if(GameWorld.die) {
			
			acceleration += poids;
			
			//Gdx.app.log(String.valueOf(taille),String.valueOf(acceleration));

			
			if (position.x > Gdx.graphics.getWidth() - taille/2 ||position.x< 0 + taille/2) {
	           
	            vitessex = -vitessex;
	           
	        }
	        //Same as above, but with on the y-axis.
	        if (position.y > Gdx.graphics.getHeight() - taille/2 || position.y < 0 + taille/2) {
	            vitessey = -vitessey;
	            
	        }
	      
	        position.add(new Vector2(vitessex, vitessey+acceleration).scl(delta));
		}
		else if(start) {
			acceleration=0;
			
		}
		
		else {
			acceleration += poids;
			if(acceleration>1200*ColorSwitch.ratioTailleEcran) {
				acceleration = 1200*ColorSwitch.ratioTailleEcran;
			}
			//position.add(new Vector2(0, acceleration).scl(delta));
			//hitBox.setPosition(position);
			float diff=0;
			//Gdx.app.log("Personnage",String.valueOf(position.y) + "   " + String.valueOf(acceleration) + "   " + String.valueOf(position.y + acceleration));
			int hauteurMaxSaut = (int) (Gdx.graphics.getHeight()*0.40);
			if(position.y + (acceleration/60)<hauteurMaxSaut) {
				position.y = hauteurMaxSaut;
				diff = position.y + acceleration - hauteurMaxSaut;
			}else {
				position.add(new Vector2(0, acceleration).scl(delta));
				//position.y+=acceleration;
			}
			hitBox.setPosition(position);
			//Gdx.app.log("Personnage", String.valueOf(diff));
			return diff;
		}
		return 0;
	}
	
	public void onClick() {
		//Gdx.app.log("Personnage", String.valueOf(((Gdx.graphics.getHeight()-Gdx.input.getY())/(Gdx.graphics.getHeight()/2f))));
		if(GameWorld.modeDeJeu==1) {
			acceleration = -hauteurSaut*((Gdx.graphics.getHeight()-Gdx.input.getY())/(Gdx.graphics.getHeight()/2f));
		}else {
			acceleration = -hauteurSaut;
		}
		if(start) {
			start = false;
		}
    }

	public Vector2 getPosition() {
		return position;
	}

	public Color getCouleur() {
		return couleur;
	}

	public float getHauteurSaut() {
		return hauteurSaut;
	}

	public float getPoids() {
		return poids;
	}

	public float getTaille() {
		return taille;
	}

	public Circle getHitBox() {
		return hitBox;
	}
	
	public Sound getSound() {
		return sound;
	}
	
	public Sound getSoundDie() {
		return soundDie;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
}
