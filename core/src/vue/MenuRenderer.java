package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import modele.MenuWorld;

public class MenuRenderer {
	private MenuWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    
	public MenuRenderer(MenuWorld world) {
			myWorld = world;
	        cam = new OrthographicCamera();
	        cam.setToOrtho(true, 544, 816);
	        shapeRenderer = new ShapeRenderer();
	        shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.circle(myWorld.getBoutons()[0].getPosition().x, myWorld.getBoutons()[0].getPosition().y, myWorld.getBoutons()[0].getTaille());
		shapeRenderer.end();
	}
}
