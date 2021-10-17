
public class Point implements PointInterface{
	float x,y,z;
	LinkedList<Triangle> incidenttriangle=new LinkedList<Triangle>();
	LinkedList<Edge> edgelist=new LinkedList<Edge>();
	boolean visited=false;
	int component;
	int pos;
	LinkedList<Point> pointlist=new LinkedList<Point>();
	public Point(float x,float y,float z) {
		   this.x=x;
		   this.y=y;
		   this.z=z;
	   }

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public float[] getXYZcoordinate() {
		float[] coord=new float[] {x,y,z};
		// TODO Auto-generated method stub
		
		return coord;
	}
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
	public int compareTo(Point k) {
		if(this.x==k.x && this.y==k.y && this.z==k.z)
			return 1;
		else 
			return 0;
	}
	//make compareTo

}
