package modele;

public class TripleCercleObstacle extends Obstacle{

	private CercleObstacle[] cercles;
	
	public TripleCercleObstacle(float x, float y, float taille, float vitesse, int difficulte) {
		super(x, y, taille, vitesse, difficulte);
		hauteurPlusDistance = 400*taille;
		position.y -= hauteurPlusDistance;
		y -= hauteurPlusDistance;
		etoile.setPosition(y);
		cercles = new CercleObstacle[3];
		cercles[0] = new CercleObstacle(x,y+200*taille,taille,vitesse,difficulte,0,1,2,3);
		cercles[1] = new CercleObstacle(x,y,taille,-vitesse,difficulte,3,2,1,0);
		cercles[2] = new CercleObstacle(x,y-200*taille,taille,vitesse,difficulte,0,1,2,3);
	}
	
	public void Move(float delta, float hauteur) {
		super.Move(delta, hauteur);
		cercles[0].Move(delta, hauteur);
		cercles[1].Move(delta, hauteur);
		cercles[2].Move(delta, hauteur);
	}
	
	public CercleObstacle[] getCercles() {
		return cercles;
	}

}
