package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	
	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    
    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204); //width = 136, height = 204
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
	public void render() {
        Gdx.app.log("GameRenderer", "render");
        //Dessine un fond noir
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Dessine les formes pleines
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(myWorld.getBille().getCouleur());
        
        //Dessine le rectangle de myWorld (Using ShapeType.Filled)
        shapeRenderer.circle(myWorld.getBille().getPosition().x, myWorld.getBille().getPosition().y, myWorld.getBille().getTaille());
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y, 
        		//myWorld.getRect().width, myWorld.getRect().height);

        // Dit au shapeRenderer d'arreter d'afficher
        // On doit le faire à chaque fois.
        shapeRenderer.end();
        
        // Dit au shapeRenderer de dessiner le contour des formes
        //shapeRenderer.begin(ShapeType.Line);
        //shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Dessine le rectangle de myWorld (Using ShapeType.Line)
        //shapeRenderer.circle(myWorld.getBille().getPosition().x, myWorld.getBille().getPosition().y, myWorld.getBille().getTaille());
        //shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                //myWorld.getRect().width, myWorld.getRect().height);

        //shapeRenderer.end();
    }
}
