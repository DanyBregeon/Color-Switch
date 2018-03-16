package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ShortArray;
import com.gdx.colorswitch.ColorSwitch;

import controleur.GameScreen;
import modele.TriangleObstacle;
import modele.TripleCercleObstacle;
import modele.CercleSynchroObstacle;
import modele.BarreHorizontale;
import modele.CercleObstacle;
import modele.EtoileScore;
import modele.CarreObstacle;
import modele.GameWorld;
import modele.Personnage;

public class GameRenderer {
	
	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer shapeRenderer2;
    private SpriteBatch batch;
    private BitmapFont font;
    //pour dessiner un polygone rempli
    private Texture texture;
    private PolygonSprite polySprite;
    private PolygonSpriteBatch polyBatch;
    private Texture [] textureTab;
    public Pixmap pix;
    private float tailleEtoile;
    private boolean sensAnimEtoile;
    private Texture lave;
    
    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); //width = 544, height = 816
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        if(GameWorld.modeDeJeu==2) {
        	lave = new Texture("lava.png");
        }
        batch = new SpriteBatch();
        /*font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(ColorSwitch.ratioTailleEcran*2);*/
        
        font = new BitmapFont(Gdx.files.internal("arial64.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(ColorSwitch.ratioTailleEcran);

    	polyBatch = new PolygonSpriteBatch();
    	tailleEtoile = 1;
    	sensAnimEtoile = true;
    	textureTab=new Texture[GameWorld.couleurs.length];
    	for(int i=0;i<GameWorld.couleurs.length;i++) {
    		pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    		pix.setColor(GameWorld.couleurs[i]);
        	pix.fill();
    		textureTab[i]=new Texture(pix);
    	}
    }
    
    private void drawRectangle(int num, int num2) {
    	shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((BarreHorizontale) myWorld.getObstacles()[num]).getCouleursRectangles()[num2]);
        shapeRenderer.rect(((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[num2].x, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[num2].y, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[num2].width, ((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles()[num2].height);
        shapeRenderer.end();
    }
    
    public void drawBarreHorizontale(int num) {
    	for(int i=0; i<((BarreHorizontale) myWorld.getObstacles()[num]).getRectangles().length; i++) {
    		drawRectangle(num, i);
    	}
    	/*shapeRenderer.begin(ShapeType.Filled);
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
        shapeRenderer.end();*/
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
        shapeRenderer.setColor(new Color(0.1f,0.1f,0.1f,1));
        shapeRenderer.circle(((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().x, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getPosition().y, ((CercleObstacle) myWorld.getObstacles()[num]).getArcs()[0].getRayon()*0.83f);
        shapeRenderer.end();
    }
    
    public void drawArcSynchro(int num1, int num2, int num3) {
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getCouleur());
    	shapeRenderer.arc(((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getPosition().x,
    					  ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getPosition().y,
    					  ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getRayon(),
    					  ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getAngleDepart(),
    					  ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getAngle());
    	shapeRenderer.end();
    }
    
    public void drawCercleSynchro(int num1, int num2) {
    	for(int i=0; i<((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[0].getArcs().length;i++) {
        	drawArcSynchro(num1, num2, i);    
    	}
    	shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(new Color(0.1f,0.1f,0.1f,1));
        shapeRenderer.circle(((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getPosition().x,
        					 ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getPosition().y,
        					 ((CercleSynchroObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[0].getRayon()*0.83f);
        shapeRenderer.end();
    }
    
    public void drawCerclesSynchro(int num) {
    	for(int i=0; i<((CercleSynchroObstacle) myWorld.getObstacles()[num]).getCercles().length;i++) {
    		drawCercleSynchro(num, i);
    	}
    }
    
    public void drawArcTriple(int num1, int num2, int num3) {
    	shapeRenderer.begin(ShapeType.Filled);
    	shapeRenderer.setColor(((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getCouleur());
    	shapeRenderer.arc(((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getPosition().x,
    					  ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getPosition().y,
    					  ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getRayon(),
    					  ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getAngleDepart(),
    					  ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[num3].getAngle());
    	shapeRenderer.end();
    }
    
    public void drawTripleCercles(int num1, int num2) {
    	for(int i=0; i<((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[0].getArcs().length;i++) {
        	drawArcTriple(num1, num2, i);    
    	}
    	shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(new Color(0.1f,0.1f,0.1f,1));
        shapeRenderer.circle(((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getPosition().x,
        					 ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getPosition().y,
        					 ((TripleCercleObstacle) myWorld.getObstacles()[num1]).getCercles()[num2].getArcs()[0].getRayon()*0.83f);
        shapeRenderer.end();
    }
    
    public void drawTripleCercles(int num) {
    	for(int i=0; i<((TripleCercleObstacle) myWorld.getObstacles()[num]).getCercles().length;i++) {
    		drawTripleCercles(num, i);
    	}
    }
    
    public void drawPolygonFilled(int num, Color couleur, float[] vertices) {
    	   	
    	//Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    	//pix.setColor(couleur);
    	//pix.fill();
    	for(int i=0;i<GameWorld.couleurs.length;i++) {
    		if(GameWorld.couleurs[i].equals(couleur)) {
    			texture=textureTab[i];
    		}
    	}
    	//texture = new Texture(pix);
    	TextureRegion textureRegion = new TextureRegion(texture);
    	//on triangularise le polygone
    	EarClippingTriangulator triangulator = new EarClippingTriangulator();
    	float[] f = new float[] { vertices[0], myWorld.getHauteurFenetre()-vertices[1], vertices[2], myWorld.getHauteurFenetre()-vertices[3],
    			vertices[4], myWorld.getHauteurFenetre()-vertices[5], vertices[6], myWorld.getHauteurFenetre()-vertices[7]};
    	ShortArray triangleIndices = triangulator.computeTriangles(f);
    	PolygonRegion polyReg = new PolygonRegion(textureRegion, f, triangleIndices.toArray());
    	polySprite = new PolygonSprite(polyReg);
    }
    
    public void drawTriangle(int num) { //change
    	
        drawPolygonFilled(num, ((TriangleObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[0], ((TriangleObstacle) myWorld.getObstacles()[num]).getRectangles()[0].getSommets());
        polyBatch.begin();
        polySprite.draw(polyBatch);
        polyBatch.end();
        drawPolygonFilled(num, ((TriangleObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[1], ((TriangleObstacle) myWorld.getObstacles()[num]).getRectangles()[1].getSommets());
        polyBatch.begin();
        polySprite.draw(polyBatch);
        polyBatch.end();
        drawPolygonFilled(num, ((TriangleObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[2], ((TriangleObstacle) myWorld.getObstacles()[num]).getRectangles()[2].getSommets());
        polyBatch.begin();
        polySprite.draw(polyBatch);
        polyBatch.end();
    }
    
    public void drawCarre(int num) {
    	
    	drawPolygonFilled(num, ((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[0], ((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].getSommets());
    	polyBatch.begin();
    	polySprite.draw(polyBatch);
    	polyBatch.end();
    	drawPolygonFilled(num, ((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[1], ((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].getSommets());
    	polyBatch.begin();
    	polySprite.draw(polyBatch);
    	polyBatch.end();
    	drawPolygonFilled(num, ((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[2], ((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].getSommets());
    	polyBatch.begin();
    	polySprite.draw(polyBatch);
    	polyBatch.end();
    	drawPolygonFilled(num, ((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[3], ((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].getSommets());
    	polyBatch.begin();
    	polySprite.draw(polyBatch);
    	polyBatch.end();
    	/*shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[0]);
        shapeRenderer.polygon(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].getSommets());     
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[1]);
        shapeRenderer.polygon(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].getSommets());     
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[2]);
        shapeRenderer.polygon(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].getSommets());     
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[3]);
        shapeRenderer.polygon(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].getSommets());     
        shapeRenderer.end();*/
        
        /*shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[0]);
        shapeRenderer.rect(myWorld.getObstacles()[num].getPosition().x, myWorld.getObstacles()[num].getPosition().y, 3,3);     
        shapeRenderer.end();*/
        
    	/*shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[0]);
        shapeRenderer.rect(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].x,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].y,
        		0,
        		0,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].width,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].height,
        		1,1,((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[0].getAngleTotal());
        
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[1]);
        shapeRenderer.rect(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].x,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].y,
        		0,
        		0,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].width,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].height,
        		1,1,((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[1].getAngleTotal());
        
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[2]);
        shapeRenderer.rect(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].x,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].y,
        		0,
        		0,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].width,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].height,
        		1,1,((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[2].getAngleTotal());
        
        shapeRenderer.end();
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(((CarreObstacle) myWorld.getObstacles()[num]).getCouleursRectangles()[3]);
        shapeRenderer.rect(((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].x,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].y,
        		0,
        		0,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].width,
        		((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].height,
        		1,1,((CarreObstacle) myWorld.getObstacles()[num]).getRectangles()[3].getAngleTotal());
        
        shapeRenderer.end();*/
        
    }
    
    private void drawetoileScore(EtoileScore etoile){
    	if(tailleEtoile>1.15) {
    		sensAnimEtoile = false;
    	}
    	if(tailleEtoile<1) {
    		sensAnimEtoile = true;
    	}
    	if(sensAnimEtoile) {
    		tailleEtoile += 0.0025;
    	}else {
    		tailleEtoile -= 0.0025;
    	}
    	if(etoile.isVivant()) {
        	shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.WHITE);
            //shapeRenderer.circle(etoile.getPosition().x, etoile.getPosition().y, etoile.getRayon());
            Vector2 v1 = new Vector2(-13*tailleEtoile*ColorSwitch.ratioTailleEcran, 0);
            Vector2 v2 = new Vector2(13*tailleEtoile*ColorSwitch.ratioTailleEcran, 0);
            Vector2 v3 = new Vector2(0, -26*tailleEtoile*ColorSwitch.ratioTailleEcran);
            shapeRenderer.triangle(etoile.getPosition().x+v1.x,etoile.getPosition().y+v1.y,etoile.getPosition().x+v2.x,etoile.getPosition().y+v2.y,etoile.getPosition().x+v3.x,etoile.getPosition().y+v3.y);
            shapeRenderer.end();
            for(int i=0; i<4; i++) {
                shapeRenderer.begin(ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                v1 = v1.rotate(72);
                v2 = v2.rotate(72);
                v3 = v3.rotate(72);
                shapeRenderer.triangle(etoile.getPosition().x+v1.x,etoile.getPosition().y+v1.y,etoile.getPosition().x+v2.x,etoile.getPosition().y+v2.y,etoile.getPosition().x+v3.x,etoile.getPosition().y+v3.y);
                shapeRenderer.end();
            }
    	}
    }
    
    public void drawObstacle() {
    	for(int i=0; i<myWorld.getIdObstacle().length; i++) {
    		switch (myWorld.getIdObstacle()[i]) {
				case 1: drawBarreHorizontale(i);
				break;
			
				case 2: drawCercle(i);
				break;
					
				case 3: drawCarre(i);
				break;
    				
				case 4: drawCerclesSynchro(i);
				break;
				
				case 5: drawTripleCercles(i);
				break;
				
				case 6: drawTriangle(i);
				break;
    		}
    		drawetoileScore(myWorld.getObstacles()[i].getEtoile());
    	}
    }
    
    public void drawLava() {
    	batch.begin();
		batch.draw(lave, myWorld.getLava().getPosition().x, Gdx.graphics.getHeight()-myWorld.getLava().getPosition().y, 552*ColorSwitch.ratioTailleEcran, 762*ColorSwitch.ratioTailleEcran);
		batch.end();
    }
    
    public void dieDisplay() {
    	
	    	for(int i=0;i<myWorld.getDiePerso().length;i++) {
	    	 	shapeRenderer.begin(ShapeType.Filled);
	         shapeRenderer.setColor(myWorld.getDiePerso()[i].getCouleur());
	         shapeRenderer.circle(myWorld.getDiePerso()[i].getPosition().x, myWorld.getDiePerso()[i].getPosition().y, myWorld.getDiePerso()[i].getTaille());
	         shapeRenderer.end();
	    	}
    }
    
	public void render() {
        //Gdx.app.log("GameRenderer", "render");
        //Dessine un fond noir
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        drawObstacle();
        
        /*drawCercle(0);
        drawBarreHorizontale(1);
        drawBarreHorizontale(2);*/
        if(myWorld.getSol() != null) {
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.rect(myWorld.getSol().getRectangle().x, myWorld.getSol().getRectangle().y, myWorld.getLargeurFenetre()/5, 8*ColorSwitch.ratioTailleEcran);
            shapeRenderer.end();
        }
        
        if(GameWorld.modeDeJeu!=2) {
            drawChangeColor(0);
            drawChangeColor(1);
            drawChangeColor(2);
        }
        
        if(GameWorld.die) {
    			dieDisplay();
        }else {
	        // Dessine les formes pleines
	        shapeRenderer.begin(ShapeType.Filled);
	        shapeRenderer.setColor(myWorld.getBille().getCouleur());
	        //Dessine le rectangle de myWorld (Using ShapeType.Filled)
	        shapeRenderer.circle(myWorld.getBille().getPosition().x, myWorld.getBille().getPosition().y, myWorld.getBille().getTaille());
	        // Dit au shapeRenderer d'arreter d'afficher
	        // On doit le faire � chaque fois.
	        shapeRenderer.end();
        }
        
        if(GameWorld.modeDeJeu==2) {
        	drawLava();
        }
        
        batch.begin();
        font.draw(batch, String.valueOf(myWorld.getScore()), 20*ColorSwitch.ratioTailleEcran, 775*ColorSwitch.ratioTailleEcran);
        batch.end();
        
        
    }
}
