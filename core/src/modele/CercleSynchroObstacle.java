package modele;

public class CercleSynchroObstacle extends Obstacle{

	private CercleObstacle[] cercles;
	
	public CercleSynchroObstacle(float x, float y, float taille, float vitesse, int difficulte) {
		super(x, y, taille, vitesse, difficulte);
		hauteurPlusDistance = 350*taille;
		position.y -= hauteurPlusDistance;
		y -= hauteurPlusDistance;
		etoile.setPosition(y);
		cercles = new CercleObstacle[4];
		cercles[0] = new CercleObstacle(x-105*taille,y+150*taille,taille,-vitesse,difficulte,0,1,2,3);
		cercles[1] = new CercleObstacle(x+105*taille,y+150*taille,taille,vitesse,difficulte,1,0,3,2);
		cercles[2] = new CercleObstacle(x-105*taille,y-150*taille,taille,vitesse/3,difficulte,0,1,2,3);
		cercles[3] = new CercleObstacle(x+105*taille,y-150*taille,taille,-vitesse/3,difficulte,1,0,3,2);
	}
	
	public void Move(float delta, float hauteur) {
		super.Move(delta, hauteur);
		cercles[0].Move(delta, hauteur);
		cercles[1].Move(delta, hauteur);
		cercles[2].Move(delta, hauteur);
		cercles[3].Move(delta, hauteur);
	}

	public CercleObstacle[] getCercles() {
		return cercles;
	}

}
