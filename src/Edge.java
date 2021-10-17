
public class Edge implements EdgeInterface {
	
	Point a,b;
	LinkedList<Triangle> trianglelist=new LinkedList<Triangle>();
	
	public Edge(Point a,Point b) {
		if(a.x<b.x) {
			this.a=a;
			this.b=b;
		}
		else if(a.x==b.x && a.y<b.y) {
			this.a=a;
			this.b=b;
		}
		else if(a.y==b.y && a.z<b.z) {
			this.a=a;
			this.b=b;
		}
		else {
			this.a=b;
			this.b=a;
		}
		
		
	}
	public float distance() {
		return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)+(a.z-b.z)*(a.z-b.z);
	}
	@Override
	public PointInterface[] edgeEndPoints() {
		// TODO Auto-generated method stub
		PointInterface[] points= new Point[] {a,b};
		return points;
	}
	public String toString() {
		return a.toString()+"..."+b.toString();
	}
	public int compareTo(Edge e) {
		if(this.a.compareTo(e.a)==1 && this.b.compareTo(e.b)==1)
			return 1;
		else
			return 0;
	}

}
