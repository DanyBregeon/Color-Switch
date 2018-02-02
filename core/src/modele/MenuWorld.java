package modele;

public class MenuWorld{
	private Bouton[] boutons;
	private int nbBoutons = 1;
	
	public MenuWorld() {
		boutons = new Bouton[nbBoutons];
		boutons[0]= new Bouton(250,400,50);
	}
	
	public void update(float delta) {
		
	}

	public Bouton[] getBoutons() {
		return boutons;
	}
	
	
}
