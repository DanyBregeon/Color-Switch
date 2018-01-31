package modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TrianglePlus extends Rectangle{
	private float[] sommets;
	private float angleTotal;
	
	public TrianglePlus(float x, float y, float width, float height) {
		super(x,y,width,height);
		
			sommets = new float[8];
			sommets[0]=x-height*2/3;
			sommets[1]=y;
			sommets[2]=x + width+height*2/3;
			sommets[3]=y;
			sommets[4]=x + width;
			sommets[5]=y + height;
			sommets[6]=x;
			sommets[7]=y + height;
		
	}
	
	public void rotate(float originX, float originY,float angle) {
		//angle=0;
		float cos = MathUtils.cosDeg(angle);
		float sin = MathUtils.sinDeg(angle);
		//Gdx.app.log("rect", String.valueOf(x) + "   " +  String.valueOf(y));
		float fx = -(originX-x);
		float fy = -(originY-y);
		float fx2 = width - (originX-x);
		float fy2 = height - (originY-y);
		float worldOriginX = originX;
		float worldOriginY = originY;
		
		
		Vector2 v0= new Vector2(sommets[0] - originX, sommets[1] - originY);
		v0.rotate(angle);
		sommets[0] = v0.x+originX;
		sommets[1] = v0.y+originY;
			
		x=sommets[0];
		y=sommets[1];

		
		Vector2 v1= new Vector2(sommets[2] - originX, sommets[3] - originY);
		v1.rotate(angle);
		sommets[2] = v1.x+originX;
		sommets[3] = v1.y+originY;
		
		Vector2 v2= new Vector2(sommets[4] - originX, sommets[5] - originY);
		v2.rotate(angle);
		sommets[4] = v2.x+originX;
		sommets[5] = v2.y+originY;
		
		Vector2 v3= new Vector2(sommets[6] - originX, sommets[7] - originY);
		v3.rotate(angle);
		sommets[6] = v3.x+originX;
		sommets[7] = v3.y+originY;

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
