package vue;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import controleur.Collision;
import controleur.InputHandler;
import modele.GameWorld;

public class GameScreen implements Screen{
	private GameWorld world;
	private GameRenderer renderer;
	private Collision col;
	
	public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
       // float screenWidth = Gdx.graphics.getWidth();
        //float screenHeight = Gdx.graphics.getHeight();
        //int gameWidth = 544;
        //int gameHeight = screenHeight / (screenWidth / gameWidth);

        world = new GameWorld(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); //initialise le monde
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
			world = new GameWorld(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			renderer = new GameRenderer(world);
			col = new Collision(world);
			Gdx.input.setInputProcessor(new InputHandler(world.getBille()));
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
		Gdx.app.log("GameScreen", "hide called");    
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
