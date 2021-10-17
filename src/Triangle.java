
public class Triangle implements TriangleInterface {
	Point a,b,c;
//	public static int count=0;
	int pos;
	boolean visited=false;
	boolean bfsvisited=false;
	LinkedList<Edge> edges= new LinkedList<Edge>();
	LinkedList<Triangle> tris=new LinkedList<Triangle>();
	public Triangle(Point a,Point b,Point c) {
		this.a=a;
		this.b=b;
//		pos=count;
//		count++;
		
		this.c=c;
	}
	@Override
	public PointInterface[] triangle_coord() {
		// TODO Auto-generated method stub
		PointInterface[] points= new Point[] {a,b,c};
		return points;
	}
	public String toString() {
		return "("+a.x+" ,"+a.y+" ,"+a.z+" ) .( "+b.x+" ,"+b.y+" ,"+b.z+") .("+c.x+" ,"+c.y+" ,"+c.z+")";
	}
	
		
	public int compareTo(Triangle t) {
		
		if(this.a.compareTo(t.a)==1 && this.b.compareTo(t.b)==1 && this.c.compareTo(t.c)==1)
			return 1;
		else if(this.a.compareTo(t.b)==1 && this.b.compareTo(t.a)==1 && this.c.compareTo(t.c)==1)
			return 1;
		else if(this.a.compareTo(t.a)==1 && this.b.compareTo(t.c)==1 && this.c.compareTo(t.b)==1)
			return 1;
		else if(this.a.compareTo(t.a)==1 && this.b.compareTo(t.b)==1 && this.c.compareTo(t.c)==1)
			return 1;
		else if(this.a.compareTo(t.a)==1 && this.b.compareTo(t.b)==1 && this.c.compareTo(t.c)==1)
			return 1;
		else if(this.a.compareTo(t.c)==1 && this.b.compareTo(t.b)==1 && this.c.compareTo(t.a)==1)
			return 1;
		else 
			return 0;
	}
}
