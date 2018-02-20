package controleur;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.gdx.colorswitch.ColorSwitch;

import modele.GameWorld;
import vue.GameRenderer;

public class GameScreen implements Screen{
	private ColorSwitch main;
	private GameWorld world;
	private GameRenderer renderer;
	private Collision col;
	
	public GameScreen(ColorSwitch cs, int modeDeJeu) {
        Gdx.app.log("GameScreen", "Attached");
        main = cs;
       // float screenWidth = Gdx.graphics.getWidth();
        //float screenHeight = Gdx.graphics.getHeight();
        //int gameWidth = 544;
        //int gameHeight = screenHeight / (screenWidth / gameWidth);
        Gdx.app.log("sreen init", String.valueOf(Gdx.graphics.getHeight()));
        world = new GameWorld(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), modeDeJeu); //initialise le monde
        renderer = new GameRenderer(world); //initialise le rendu
        col = new Collision(world);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getBille()));
    }
	@Override
	public void show() {
		Gdx.app.log("GameScreen", "show called");
		
	}

	@Override
	public void render(float delta) {
		world.update(delta); // GameWorld updates 
		renderer.render(); // GameRenderer renders
		try {
			col.update(delta); // Collision updates
		} catch(Exception e) {
			world.saveScore();
			col.getDeadSound().play();
			dispose();
			main.setScreen(new MenuResetScreen(main, world.getScore()));		
			/*Gdx.app.log("sreen reset", String.valueOf(Gdx.graphics.getHeight()));
			world = new GameWorld(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			renderer = new GameRenderer(world);
			col = new Collision(world);
			Gdx.input.setInputProcessor(new InputHandler(world.getBille()));*/
		}
		
		// Cree une couleur (RGB = 10, 15, 230)
        //Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        // Rempli la fenetre avec la couleur
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
        // Affiche les fps
        //Gdx.app.log("GameScreen FPS", (1/delta) + "");
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("GameScreen", "resizing");
		
	}

	@Override
	public void pause() {
		Gdx.app.log("GameScreen", "pause called");
		
	}

	@Override
	public void resume() {
		Gdx.app.log("GameScreen", "resume called");
		
	}

	@Override
	public void hide() {
		
		dispose();
		
		Gdx.app.log("GameScreen", "hide called");    
		
	}

	@Override
	public void dispose() {
		
		world.getBille().getSound().dispose();
		col.getStarSound().dispose();
		col.getColorSwitchSound().dispose();
		col.getDeadSound().dispose();
		// TODO Auto-generated method stub
		
	}

}