package modele;

public class MenuResetWorld {
	private Bouton[] boutons;
	private int nbBoutons = 2;
	
	public MenuResetWorld() {
		boutons = new Bouton[nbBoutons];
		boutons[0] = new Bouton(250,500,50);
		boutons[1] = new Bouton(100,100,30);
	}
	
	public void update(float delta){
		
	}
	
	public Bouton[] getBoutons() {
		return boutons;
	}

}
