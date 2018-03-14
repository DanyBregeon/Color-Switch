package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import modele.CercleObstacle;
import modele.MenuWorld;

public class MenuRenderer {
	private MenuWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Texture titleText;
    private Texture buttonPlay;//a mettre dans le modele plus tard
    private TextureRegion buttonExit;//a mettre dans le modele plus tard
    private TextureRegion buttonGameMode1;//a mettre dans le modele plus tard
    private TextureRegion buttonGameMode2;//a mettre dans le modele plus tard
    private TextureRegion buttonSound;//a mettre dans le modele plus tard
    private TextureRegion buttonSoundOff;//a mettre dans le modele plus tard
    private SpriteBatch batch;
    private float angleButtonExit;
    
	public MenuRenderer(MenuWorld world) {
			myWorld = world;
	        cam = new OrthographicCamera();
	        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	        shapeRenderer = new ShapeRenderer();
	        shapeRenderer.setProjectionMatrix(cam.combined);
	        titleText = new Texture("colorSwitchTextMenu.png");
	        buttonPlay = new Texture("buttonPlay.png");
	        Texture buttonExitImg = new Texture("buttonExit.png");
	        buttonExit = new TextureRegion(buttonExitImg);
	        Texture buttonSoundImg = new Texture("buttonSound.png");
	        buttonSound = new TextureRegion(buttonSoundImg);
	        Texture buttonSoundOffImg = new Texture("buttonSoundOff.png");
	        buttonSoundOff = new TextureRegion(buttonSoundOffImg);
	        Texture buttonMouseImg = new Texture("buttonMouseGameMode.png");
	        buttonGameMode1 = new TextureRegion(buttonMouseImg);
	        Texture buttonChronoImg = new Texture("buttonLavaGameMode.png");
	        buttonGameMode2 = new TextureRegion(buttonChronoImg);
	        angleButtonExit = 0;
	        batch = new SpriteBatch();
	}
	
	public void drawArc(int num1, int num2) {
		//Gdx.app.log("renderer", String.valueOf(((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getRayon()));
    	shapeRenderer.arc(((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getPosition().x,
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getPosition().y,
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getRayon(),
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getAngleDepart(),
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getAngle());
    }
	
	
	public void drawCercle(int num) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getCouleur());
        drawArc(num, 0);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[1].getCouleur());
        drawArc(num, 1);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[2].getCouleur());
        drawArc(num, 2);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[3].getCouleur());
        drawArc(num, 3);
        shapeRenderer.end();     
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(new Color(41f/255f, 41f/255f, 41f/255f, 1));
        shapeRenderer.circle(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().x, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().y, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getRayon()*0.83f);
        shapeRenderer.end();
	}
	
	public void render() {
		Gdx.gl.glClearColor(41f/255f, 41f/255f, 41f/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.GRAY);
		shapeRenderer.circle(myWorld.getBoutons()[0].getPosition().x, myWorld.getBoutons()[0].getPosition().y, myWorld.getBoutons()[0].getTaille());
		shapeRenderer.end();*/
		drawCercle(0);
		drawCercle(1);
		drawCercle(2);
		batch.begin();
		batch.draw(titleText, Gdx.graphics.getWidth()/2-155, Gdx.graphics.getHeight()-200);
		batch.end();
		drawCercle(3);
		drawCercle(4);
		batch.begin();
		batch.draw(buttonPlay, myWorld.getBoutons()[0].getPosition().x-86, Gdx.graphics.getHeight()-myWorld.getBoutons()[0].getPosition().y-86);
		batch.end();
		batch.begin();
		angleButtonExit-=2;;
		batch.draw(buttonExit, myWorld.getBoutons()[1].getPosition().x-43, Gdx.graphics.getHeight()-myWorld.getBoutons()[1].getPosition().y-43, 43,43,86,86,1,1,angleButtonExit);
		batch.end();
		batch.begin();
		batch.draw(buttonGameMode1, myWorld.getBoutons()[2].getPosition().x-43, Gdx.graphics.getHeight()-myWorld.getBoutons()[2].getPosition().y-43, 43,43,86,86,1,1,angleButtonExit);
		batch.end();
		batch.begin();
		batch.draw(buttonGameMode2, myWorld.getBoutons()[3].getPosition().x-43, Gdx.graphics.getHeight()-myWorld.getBoutons()[3].getPosition().y-43, 43,43,86,86,1,1,angleButtonExit);
		batch.end();
		batch.begin();
		if(myWorld.isSon()) {
			batch.draw(buttonSound, myWorld.getBoutons()[4].getPosition().x-43, Gdx.graphics.getHeight()-myWorld.getBoutons()[4].getPosition().y-43, 43,43,86,86,1,1,angleButtonExit);
		}else {
			batch.draw(buttonSoundOff, myWorld.getBoutons()[4].getPosition().x-43, Gdx.graphics.getHeight()-myWorld.getBoutons()[4].getPosition().y-43, 43,43,86,86,1,1,angleButtonExit);
		}
		
		batch.end();
	}
}
