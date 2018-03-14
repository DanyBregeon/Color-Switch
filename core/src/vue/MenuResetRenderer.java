package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import modele.GameWorld;
import modele.MenuResetWorld;

public class MenuResetRenderer {
	private MenuResetWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Texture bandeauScore;
    private Texture bandeauBestScore;
    private Texture buttonHome;
    private Texture buttonReset;
    private SpriteBatch batch;
    private BitmapFont scoreText;
    
	public MenuResetRenderer(MenuResetWorld world) {
			myWorld = world;
	        cam = new OrthographicCamera();
	        cam.setToOrtho(true, 544, 816);
	        shapeRenderer = new ShapeRenderer();
	        shapeRenderer.setProjectionMatrix(cam.combined);
	        bandeauScore = new Texture("menuBandeauScore.png");
	        bandeauBestScore = new Texture("menuBandeauBestScore.png");
	        buttonHome = new Texture("buttonHome.png");
	        buttonReset = new Texture("buttonReset.png");
	        batch = new SpriteBatch();
	        scoreText = new BitmapFont(Gdx.files.internal("arial64.fnt"));
	        scoreText.setColor(Color.WHITE);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.circle(myWorld.getBoutons()[0].getPosition().x, myWorld.getBoutons()[0].getPosition().y, myWorld.getBoutons()[0].getTaille());
		shapeRenderer.end();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.circle(myWorld.getBoutons()[1].getPosition().x, myWorld.getBoutons()[1].getPosition().y, myWorld.getBoutons()[1].getTaille());
		shapeRenderer.end();*/
        batch.begin();
		batch.draw(buttonHome, myWorld.getBoutons()[1].getPosition().x-myWorld.getBoutons()[1].getTaille(), Gdx.graphics.getHeight()-myWorld.getBoutons()[1].getPosition().y-myWorld.getBoutons()[1].getTaille());
		batch.end();
		batch.begin();
		batch.draw(buttonReset, myWorld.getBoutons()[0].getPosition().x-myWorld.getBoutons()[0].getTaille(), Gdx.graphics.getHeight()-myWorld.getBoutons()[0].getPosition().y-myWorld.getBoutons()[0].getTaille());
		batch.end();
		batch.begin();
		if(myWorld.getScore()<10) {
			scoreText.draw(batch, String.valueOf(myWorld.getScore()), Gdx.graphics.getWidth()/2-18, Gdx.graphics.getHeight()/1.55f);
		}else {
			scoreText.draw(batch, String.valueOf(myWorld.getScore()), Gdx.graphics.getWidth()/2-36, Gdx.graphics.getHeight()/1.55f);
		}
        batch.end();
		batch.begin();
		if(GameWorld.modeDeJeu==0) {
			scoreText.draw(batch, String.valueOf(Gdx.app.getPreferences("ScorePref").getInteger("score",0)), Gdx.graphics.getWidth()/2-35, Gdx.graphics.getHeight()/2.2f);
		}else if(GameWorld.modeDeJeu==1) {
			scoreText.draw(batch, String.valueOf(Gdx.app.getPreferences("ScorePref").getInteger("score1",0)), Gdx.graphics.getWidth()/2-35, Gdx.graphics.getHeight()/2.2f);
		}else if(GameWorld.modeDeJeu==2) {
			scoreText.draw(batch, String.valueOf(Gdx.app.getPreferences("ScorePref").getInteger("score2",0)), Gdx.graphics.getWidth()/2-35, Gdx.graphics.getHeight()/2.2f);
		}

        batch.end();
		batch.begin();
		batch.draw(bandeauScore, 0, Gdx.graphics.getHeight()/1.5f);
		batch.end();
		batch.begin();
		batch.draw(bandeauBestScore, 0, Gdx.graphics.getHeight()/2);
		batch.end();
	}
}
