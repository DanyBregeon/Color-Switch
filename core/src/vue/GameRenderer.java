package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import modele.BarreHorizontale;
import modele.CercleObstacle;
import modele.GameWorld;

public class GameRenderer {
	
	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer shapeRenderer2;
    private SpriteBatch batch;
    private BitmapFont font;
    
    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 544, 816); //width = 136, height = 204
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        batch = new SpriteBatch();    
        font = new BitmapFont();
        font.setColor(Color.WHITE);
    }
    
    public void drawBarreHorizontale(int num) {
    	shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[0]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[0].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[0].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[0].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[0].height);
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[1]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[1].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[1].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[1].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[1].height);
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[2]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[2].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[2].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[2].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[2].height);
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[3]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[3].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[3].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[3].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[3].height);
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[4]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[4].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[4].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[4].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[4].height);
        shapeRenderer.end();
    }
    
    public void drawArc(int num1, int num2) {
		//Gdx.app.log("renderer", String.valueOf(((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getRayon()));
    	shapeRenderer.arc(((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getPosition().x,
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getPosition().y,
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getRayon(),
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getAngleDepart(),
        		((CercleObstacle) myWorld.getObstacles()[num1]).getArcs()[num2].getAngle());
    }
    
    public void drawChangeColor(int num) {
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(GameWorld.couleurs[0]);
    	shapeRenderer.arc(myWorld.getChangementCouleurs()[num].getPosition().x, myWorld.getChangementCouleurs()[num].getPosition().y, myWorld.getChangementCouleurs()[num].getRayon(),0,90);
    	shapeRenderer.end();
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(GameWorld.couleurs[1]);
    	shapeRenderer.arc(myWorld.getChangementCouleurs()[num].getPosition().x, myWorld.getChangementCouleurs()[num].getPosition().y, myWorld.getChangementCouleurs()[num].getRayon(),90,90);
    	shapeRenderer.end();
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(GameWorld.couleurs[2]);
    	shapeRenderer.arc(myWorld.getChangementCouleurs()[num].getPosition().x, myWorld.getChangementCouleurs()[num].getPosition().y, myWorld.getChangementCouleurs()[num].getRayon(),180,90);
    	shapeRenderer.end();
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(GameWorld.couleurs[3]);
    	shapeRenderer.arc(myWorld.getChangementCouleurs()[num].getPosition().x, myWorld.getChangementCouleurs()[num].getPosition().y, myWorld.getChangementCouleurs()[num].getRayon(),270,90);
    	shapeRenderer.end();
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
        shapeRenderer.setColor(new Color(0,0,0,1));
        shapeRenderer.circle(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().x, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().y, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getRayon()*0.83f);
        shapeRenderer.end();
    }
    
    public void drawObstacle() {
    	for(int i=0; i<myWorld.getIdObstacle().length; i++) {
    		switch (myWorld.getIdObstacle()[i]) {
			case 1: drawBarreHorizontale(i);
					break;
			
			case 2: drawCercle(i);
					break;
    		}
    	}
    }
    
	public void render() {
        //Gdx.app.log("GameRenderer", "render");
        //Dessine un fond noir
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        font.draw(batch, String.valueOf(myWorld.getScore()), 20, 750);
        batch.end();
        
        
        drawObstacle();
        drawChangeColor(0);
        drawChangeColor(1);
        drawChangeColor(2);
        /*drawCercle(0);
        drawBarreHorizontale(1);
        drawBarreHorizontale(2);*/
        
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
        //drawBarreHorizontale(0);
        
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
