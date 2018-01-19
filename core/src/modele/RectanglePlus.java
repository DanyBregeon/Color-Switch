package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RectanglePlus extends Rectangle{
	private float[] sommets;
	private float angleTotal;
	
	public RectanglePlus(float x, float y, float width, float height) {
		super(x,y,width,height);
		sommets = new float[8];
		sommets[0]=x;
		sommets[1]=y;
		sommets[2]=x + width;
		sommets[3]=y;
		sommets[4]=x + width;
		sommets[5]=y + height;
		sommets[6]=x;
		sommets[7]=y + height;
	}
	
	public void rotate(float originX, float originY,float angle) {
		float cos = MathUtils.cosDeg(angle);
		float sin = MathUtils.sinDeg(angle);
		Gdx.app.log("rect", String.valueOf(x) + "   " +  String.valueOf(y));
		float fx = -(originX-x);
		float fy = -(originY-y);
		float fx2 = width - (originX-x);
		float fy2 = height - (originY-y);
		float worldOriginX = originX;
		float worldOriginY = originY;
		
		//Gdx.app.log("test", String.valueOf(cos * fx) + "   " +  String.valueOf(sin * fy + worldOriginX));
		
		
		sommets[0] = cos * fx - sin * fy + worldOriginX;
		sommets[1] = sin * fx + cos * fy + worldOriginY;
			
		x=sommets[0];
		y=sommets[1];

		//sommets[2] = cos * fx2 - sin * fy + worldOriginX;
		//sommets[3] = sin * fx2 + cos * fy + worldOriginY;
		
		Vector2 v= new Vector2(sommets[2] - originX, sommets[3] - originY);
		v.rotate(angle);
		sommets[2] = v.x+originX;
		sommets[3] = v.y+originY;
		
		Vector2 v2= new Vector2(sommets[4] - originX, sommets[5] - originY);
		v2.rotate(angle);
		sommets[4] = v2.x+originX;
		sommets[5] = v2.y+originY;
		
		Vector2 v3= new Vector2(sommets[6] - originX, sommets[7] - originY);
		v3.rotate(angle);
		sommets[6] = v3.x+originX;
		sommets[7] = v3.y+originY;

		//sommets[4] = cos * fx2 - sin * fy2 + worldOriginX;
		//sommets[5] = sin * fx2 + cos * fy2 + worldOriginY;

		//sommets[6] = sommets[0] + (sommets[4] - sommets[2]);
		//sommets[7] = sommets[5] - (sommets[3] - sommets[1]);
	}

	public float[] getSommets() {
		return sommets;
	}

	public float getAngleTotal() {
		return angleTotal;
	}

	public void setAngleTotal(float angleTotal) {
		this.angleTotal = angleTotal;
	}
	
}
