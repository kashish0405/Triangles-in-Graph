
public class Shape implements ShapeInterface
{

	// THE DEFAULT IS JUST ADDED SO THAT YOU CAN BUILD YOUR IMPLEMENTATION INCREMENTALLY.

	LinkedList<Point> allpoints= new LinkedList<Point>();
	LinkedList<Edge> alledges= new LinkedList<Edge>();
	LinkedList<Triangle> alltriangles= new LinkedList<Triangle>();
	LinkedList<Point> centroid;
	public static int mycount=0;
	public static int mycountpoint=0;
	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public boolean ADD_TRIANGLE(float [] triangle_coord){

		float x1=triangle_coord[0];
		float y1=triangle_coord[1];
		float z1=triangle_coord[2];
		float x2=triangle_coord[3];
		float y2=triangle_coord[4];
		float z2=triangle_coord[5];
		float x3=triangle_coord[6];
		float y3=triangle_coord[7];
		float z3=triangle_coord[8];
		float k1=(x2-x1)/(x3-x2);
		float k2=(y2-y1)/(y3-y2);
		float k3=(z2-z1)/(z3-z2);
		int r1=-1;
		if(x1==x2 && x2==x3) {
			r1=1;
		}
		int r2=-1;
		if(y1==y2 && y2==y3) {
			r2=1;
		}
		int r3=-1;
		if(z1==z2 && z2==z3) {
			r3=1;
		}
		/////+- ??????
		
		if((k1==k2 && k2==k3)||(r1==1 && r2==1)||(r3==1 && r2==1)||(r1==1 && r3==1))/// 
		{
//			System.out.println("false");
			
			return false;
			}
		
		else {
			Point a=new Point(x1,y1,z1);
			Point b=new Point(x2,y2,z2);
			Point c=new Point(x3,y3,z3);
			Edge ab=new Edge(a,b);
			Edge bc=new Edge(b,c);
			Edge ca=new Edge(c,a);
			int i=0;
			boolean found1=false;
			boolean found2=false;
			boolean found3=false;
			Triangle t= new Triangle(a,b,c);
			t.pos=mycount;
			mycount++;
			
//			bc.trianglelist.addLast(t);
//			
//			//alledges.addLast(ab);
//			ca.trianglelist.addLast(t);
//			ab.trianglelist.addLast(t);
			boolean f1=false;
			boolean f2=false;
			boolean f3=false,f4=false,f5=false,f6=false;
			
			boolean p1=false,p2=false,p3=false;
			
			
			
			
			Node<Edge> temp=alledges.getNodeAt(0);
			for(int k=0;k<alledges.size();k++) {
//				Edge temp=alledges.getAt(k);
				if(temp.data.compareTo(ab)==1 ) {
//					
					temp.data.trianglelist.addLast(t);
					t.edges.addLast(temp.data);
					p1=true;


				}
				
				if(temp.data.compareTo(bc)==1) {
//					
					
					temp.data.trianglelist.addLast(t);

					t.edges.addLast(temp.data);
					p2=true;

				}
				
					if(temp.data.compareTo(ca)==1 ) {
//						
						temp.data.trianglelist.addLast(t);
						t.edges.addLast(temp.data);
						p3=true;

					}
				
				temp=temp.next;
			}
			
			boolean s1=false;
			int i1=-1,i2=-1,i3=-1;
			boolean s2=false;
			boolean	s3=false;
			Point x=null,y=null,z=null;
			Node<Point> p=allpoints.getNodeAt(0);
			while(i<allpoints.size() && (s1==false|| s2==false|| s3==false))
			{

				if(a.compareTo(p.data)==1) {
					i1=p.data.pos;
					x=p.data;
					s1=true;
				}
				if(b.compareTo(p.data)==1) {
					i2=p.data.pos;
					y=p.data;
					s2=true;
				}
				if(c.compareTo(p.data)==1) {
					i3=p.data.pos;
					z=p.data;
					s3=true;
				}

				i++;
			p=p.next;
			}

				i=0;
			
			 p=allpoints.getNodeAt(0);
			
			while(i<allpoints.size() && (found1==false|| found2==false|| found3==false)) {
				
				
					
					if(a.compareTo(p.data)==1) {   ////////point a is already existing
						p.data.incidenttriangle.addLast(t);
						int j=0;
						found1=true;
						Node<Edge> e= p.data.edgelist.getNodeAt(0);
						while(j<p.data.edgelist.size() && (f1==false || f2==false)) {
							
							if(e.data.compareTo(ab)==1 )//&& f3==false          ==> b point already exists
							{
								f1=true;
							}
							if(e.data.compareTo(ca)==1) {
								
//								if(f1==false)
//								e.trianglelist.addLast(t);
								f2=true;
							}
							j++;
							e=e.next;
						}
						if(f1==false)
							{ 
							if(s2==true)           //b point already exists
							{
								b.pos=i2;
								
								b=y;
								
//							System.out.println("bb"+b.pos+" "+b);
							}
							p.data.pointlist.addLast(b);  //we dont know whether b exists or not  so its pos has not been updated
							
							p.data.edgelist.addLast(ab);
//							alledges.addLast(ab);
							}
						if(f2==false) {
							if(s3==true)
								{c.pos=i3;
								c=z;
//								System.out.println("cc"+c.pos+" "+c);
								
								}
							p.data.pointlist.addLast(c);
							
						p.data.edgelist.addLast(ca);
//						alledges.addLast(ca);
						}
//						if(f1==false &&)
					
					}
					
					
					if(b.compareTo(p.data)==1) {   ////////point b is already existing
						p.data.incidenttriangle.addLast(t);
						int j=0;
						found2=true;
						Node<Edge> e= p.data.edgelist.getNodeAt(0);
						while(j<p.data.edgelist.size() && (f3==false || f4==false)) {
							
							if(e.data.compareTo(ab)==1 )//&& f1==false
							{
								
								f3=true;
							}
							if(e.data.compareTo(bc)==1) {
								
									
							
								f4=true;
							}
							j++;
							e=e.next;
						}
						if(f3==false )
							{
							if(s1==true)
							{	a.pos=i1;
							a=x;
//							System.out.println("aa"+a.pos+" "+a);
							}
							p.data.pointlist.addLast(a);
							
							p.data.edgelist.addLast(ab);
							//alledges.addLast(ab);
							}
//						else if(f3==false) {
//							p.edgelist.addLast(ab);
//						}
						if(f4==false) {
							if(s3==true) {
								c.pos=i3;
								c=z;
//								System.out.println("cc"+c.pos+" "+c);
								
							}
								
							p.data.pointlist.addLast(c);
						
							p.data.edgelist.addLast(bc);
//						alledges.addLast(bc);
						}
					}
					
					
					if(c.compareTo(p.data)==1) {   ////////point c is already existing
						p.data.incidenttriangle.addLast(t);
						int j=0;
						found3=true;
						Node<Edge> e= p.data.edgelist.getNodeAt(0);
						while(j<p.data.edgelist.size() && (f5==false || f6==false)) {
							
							if(e.data.compareTo(bc)==1)
							{
								
								f5=true;
							}
							if(e.data.compareTo(ca)==1) {
								
								
								f6=true;
							}
							j++;
							e=e.next;
						}
						if(f5==false)
							{
							if(s2==true)
							{	
								b.pos=i2;
								b=y;
//								System.out.println("bb"+b.pos+" "+b);
							}
								p.data.pointlist.addLast(b);
							
							p.data.edgelist.addLast(bc);
//							alledges.addLast(bc);
							}
//						else if(f5==false) {
//							p.edgelist.addLast(ab);
//						}
						if(f6==false  ) {
							if(s1==true)
							{
								a.pos=i1;
								a=x;
//								System.out.println("aa"+a.pos+" "+a);
							}
							p.data.pointlist.addLast(a);
							
							p.data.edgelist.addLast(ca);
//						alledges.addLast(bc);
						}
					}
						
					
					i++;
					
					
					
				p=p.next;
				
			}
			if(found1==false) {
				
					a.pos=mycountpoint;
					mycountpoint++;
					allpoints.addLast(a);
					if(s2==true)
						b=y;
					a.pointlist.addLast(b);
					if(s3==true)
						c=z;
					a.pointlist.addLast(c);
					a.edgelist.addLast(ab);
					a.edgelist.addLast(ca);
					a.incidenttriangle.addLast(t);
					
//			ca.trianglelist.addLast(t);
////					
////					
//					ab.trianglelist.addLast(t);
//					
				
			}
			
			
			if(found2==false) {
				
				b.pos=mycountpoint;
				mycountpoint++;
				allpoints.addLast(b);
				if(s1==true)
					a=x;
				b.pointlist.addLast(a);
				if(s3==true)
					c=z;
				b.pointlist.addLast(c);
				b.edgelist.addLast(ab);
				b.edgelist.addLast(bc);
				b.incidenttriangle.addLast(t);
				
//				bc.trianglelist.addLast(t);
////			
//				ab.trianglelist.addLast(t);
				
			
		}
			if(found3==false) {
				
				
				c.pos=mycountpoint;
				mycountpoint++;
				if(s1==true)
					a=x;
				c.pointlist.addLast(a);
				if(s2==true)
					b=y;
				c.pointlist.addLast(b);
				allpoints.addLast(c);
				c.edgelist.addLast(ca);
				c.edgelist.addLast(bc);
				c.incidenttriangle.addLast(t);
		
			
		}
			
			

			bc.trianglelist.addLast(t);
//			
//			//alledges.addLast(ab);
			ca.trianglelist.addLast(t);
			ab.trianglelist.addLast(t);
			
			///////all points are existing still edge needs to be constructed
			if(p1==false) {
				alledges.addLast(ab);
				t.edges.addLast(ab);
				
			}
			
			if(p2==false ) {
				alledges.addLast(bc);
				t.edges.addLast(bc);
				
			}
			
			if(p3==false) {
				alledges.addLast(ca);
				t.edges.addLast(ca);
			
			}
			
			
			
			Node<Triangle> tr=alltriangles.getNodeAt(0);
			for(int k=0;k<alltriangles.size();k++) 
			{
				
				Node<Edge> e=tr.data.edges.getNodeAt(0);
				for(int j=0;j<tr.data.edges.size();j++ ) {              ///only three elements in edges list
					
					if(ab.compareTo(e.data)==1 || bc.compareTo(e.data)==1 || ca.compareTo(e.data)==1) {
						tr.data.tris.addLast(t);
						t.tris.addLast(tr.data);
					}
					e=e.next;
				}
				tr=tr.next;
			}
			
			
			
			alltriangles.addLast(t);

		
			
//			printlists();

			return true;
		}
		
		}
	public void printlists() {

		for(int i=0;i<allpoints.size();i++) {
			System.out.println(allpoints.getAt(i));
			allpoints.getAt(i).pointlist.display();

		}
		
		
	}
	//
	public int TYPE_MESH(){
		
//		alltriangles.getAt(1).tris.display();
		boolean semi=false;
		
		Node<Edge> e=alledges.getNodeAt(0);
		for(int i=0;i<alledges.size();i++) {
			
			
			int size=e.data.trianglelist.size();

			if(size>2) {
				
				return 3;
			}
			
			else if(size==1) {
				
				semi=true;
				
			}
			
			e=e.next;
		}
		if(semi==true)
			return 2;
		else 
			return 1;
		
		
		}

	 public int partition(Edge[] a,int left,int right)
	   
	    {
		Edge temp;
		int i=left+1;
		int pos=left;
		int j=right;
		
		Edge x=a[left];
//	    INV:a[left...j-1]<=x,a[j+1...i]>x,left+1<=j<=i-1,left<=right
	    while(i<=j)
	    	
	    {  
	    	
	    	//Edge u1=a[i];
	    	
	    	if(a[i].distance()<x.distance())
	    	
	        {temp=a[i];  
	        a[i]=a[pos];
	        //a.set(i,a.get(pos));
	        a[pos]=temp;
	    	//a[i],a[pos]=a[pos],a[i];
	            pos=i;
	            i=i+1;
	        }
	  
	        else
	        {
	        	temp=a[i];  
	            a[i]=a[j];
	            a[j]=temp;
	            j=j-1;
	        }}
	    
	    		a[j]=x;
	    //a.set(j,x);
	            
	    return pos;
	    }
	    public void quicksort(Edge[] a,int left,int right)
	    { 
	    	if(left<right)
	    	{
	    		
	        int p=partition(a,left,right);
	        quicksort(a,left,p-1);
	        quicksort(a,p+1,right);
	    	}
	    }
	//
	public EdgeInterface [] BOUNDARY_EDGES(){
		int j=0;
		Edge[] arr=new Edge[alledges.size()];
		Node<Edge> e=alledges.getNodeAt(0);
		for(int i=0;i<alledges.size();i++) {
			

			int size=e.data.trianglelist.size();
			if(size==1)
				
			{	
				arr[j]=e.data;
				j++;
			}
			e=e.next;
		}
		quicksort(arr,0,j-1);
		Edge[] finarr=new Edge[j];
//		System.out.println(j);
		for(int i=0;i<j;i++) {
			finarr[i]=arr[i];
//			System.out.println(finarr[i]+" length "+finarr[i].distance());
		}
		if(j==0)
			return null;
		else
		return finarr;
		}
	
	
	public void help(Triangle t) {
		 // Mark the current node as visited and print it 
        t.visited=true; 
//        System.out.println("COMPONENT "+t+" "); 
       
        Node<Triangle> tri=t.tris.getNodeAt(0);
        for (int i=0;i<t.tris.size();i++) { 
        	
            if(!tri.data.visited) 
            	help(tri.data); 
            
            tri=tri.next;
        } 
  
	}

	//
	public int COUNT_CONNECTED_COMPONENTS(){
		
		int count=0;
		Node<Triangle> t=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			
				t.data.visited=false;
			t=t.next;
		}
			
		t=alltriangles.getNodeAt(0);
	        for(int i = 0; i < alltriangles.size(); ++i) { 
	        	
	            if(!t.data.visited) { 
	                // print all reachable vertices 
	                // from v 
	                help(t.data); 
	                count++;

	            } 
	            t=t.next;
	        } 
		
//		System.out.println(count);
		
		return count;} 



	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		
		
		
		
		float x1=triangle_coord[0];
		float y1=triangle_coord[1];
		float z1=triangle_coord[2];
		float x2=triangle_coord[3];
		float y2=triangle_coord[4];
		float z2=triangle_coord[5];
		float x3=triangle_coord[6];
		float y3=triangle_coord[7];
		float z3=triangle_coord[8];
		
		Point a=new Point(x1,y1,z1);
		Point b=new Point(x2,y2,z2);
		Point c=new Point(x3,y3,z3);
		
		Triangle t= new Triangle(a,b,c);
		
//		Triangle[] trilist=new Triangle[alltriangles.size()];
//		int k=0;
//		boolean found1=false,found2=false,found3=false;
		int f=0;
//		alltriangles.display();
		boolean flag=false;
		Node<Triangle> temp=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			
			if(temp.data.compareTo(t)==1) {
				f=i;
				flag=true;
				break;
			}
			temp=temp.next;	
			}
		if(flag==false) {
			return null;
		}

		Node<Triangle> g=alltriangles.getNodeAt(f);
		Triangle[] fintri=new Triangle[g.data.tris.size()];
		
		Node<Triangle> tr=g.data.tris.getNodeAt(0);
		for(int i=0;i<g.data.tris.size();i++) {
			fintri[i]=tr.data;
//			System.out.println(fintri[i]+" length "+fintri[i].pos);
			tr=tr.next;
		}
		
		return fintri;
		}

	 public int partitiontri(Triangle[] a,int left,int right)
	   
	    {
		Triangle temp;
		int i=left+1;
		int pos=left;
		int j=right;
		
		Triangle x=a[left];
//	    INV:a[left...j-1]<=x,a[j+1...i]>x,left+1<=j<=i-1,left<=right
	    while(i<=j)
	    	
	    {  
	    	
	    	//Edge u1=a[i];
	    	
	    	if(a[i].pos<x.pos)
	    	
	        {temp=a[i];  
	        a[i]=a[pos];
	        //a.set(i,a.get(pos));
	        a[pos]=temp;
	    	//a[i],a[pos]=a[pos],a[i];
	            pos=i;
	            i=i+1;
	        }
	    	
	        else
	        {
	        	temp=a[i];  
	            a[i]=a[j];
	            a[j]=temp;
	            j=j-1;
	        }}
	    
	    		a[j]=x;
	    //a.set(j,x);
	            
	    return pos;
	    }
	    public void quicksorttri(Triangle[] a,int left,int right)
	    { 
	    	if(left<right)
	    	{
	    		
	        int p=partitiontri(a,left,right);
	        quicksorttri(a,left,p-1);
	        quicksorttri(a,p+1,right);
	    	}
	    }

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		float x1=triangle_coord[0];
		float y1=triangle_coord[1];
		float z1=triangle_coord[2];
		float x2=triangle_coord[3];
		float y2=triangle_coord[4];
		float z2=triangle_coord[5];
		float x3=triangle_coord[6];
		float y3=triangle_coord[7];
		float z3=triangle_coord[8];
		
		Point a=new Point(x1,y1,z1);
		Point b=new Point(x2,y2,z2);
		Point c=new Point(x3,y3,z3);
		
		Edge ab=new Edge(a,b);
		Edge bc=new Edge(b,c);
		Edge ca=new Edge(c,a);
		Triangle t= new Triangle(a,b,c);
		boolean flag=false;
		Node<Triangle> temp=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			
			if(temp.data.compareTo(t)==1) {
				flag=true;
				break;
			}
			
			temp=temp.next;
			}
		if(flag==false) {
			return null;
		}
		Edge[] elist=new Edge[] {ab,bc,ca};
		
		
		
		return elist;
		}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		float x1=triangle_coord[0];
		float y1=triangle_coord[1];
		float z1=triangle_coord[2];
		float x2=triangle_coord[3];
		float y2=triangle_coord[4];
		float z2=triangle_coord[5];
		float x3=triangle_coord[6];
		float y3=triangle_coord[7];
		float z3=triangle_coord[8];
		
		Point a=new Point(x1,y1,z1);
		Point b=new Point(x2,y2,z2);
		Point c=new Point(x3,y3,z3);
		
		
		Triangle t= new Triangle(a,b,c);
		
		boolean flag=false;
		Node<Triangle> temp=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			
			if(temp.data.compareTo(t)==1) {
				flag=true;
				break;
			}
			
			temp=temp.next;
				
			}
		if(flag==false) {
			return null;
		}
		Point[] plist=new Point[] {a,b,c};
		
		
		
		return plist;
		
		}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		
		float x1=triangle_coord[0];
		float y1=triangle_coord[1];
		float z1=triangle_coord[2];
		float x2=triangle_coord[3];
		float y2=triangle_coord[4];
		float z2=triangle_coord[5];
		float x3=triangle_coord[6];
		float y3=triangle_coord[7];
		float z3=triangle_coord[8];
		
		Point a=new Point(x1,y1,z1);
		Point b=new Point(x2,y2,z2);
		Point c=new Point(x3,y3,z3);
		
		
		Triangle t= new Triangle(a,b,c);
		
		LinkedList<Triangle> trilist=new LinkedList<Triangle>();
		
		boolean found1=false,found2=false,found3=false;
		
//		alltriangles.display();
		boolean flag=false;
		Node<Triangle> temp=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
//			Triangle temp=alltriangles.getAt(i);
			if(temp.data.compareTo(t)==1) {
				flag=true;
				break;
			}
			temp=temp.next;	
			}
		if(flag==false) {
			return null;
		}
		
		Node<Point> e=allpoints.getNodeAt(0);
		for(int i=0;i<allpoints.size() &&( found1==false ||found2==false || found3==false);i++) {
			
//			System.out.println(allpoints.size());
//			System.out.println("yee");
			if(a.compareTo(e.data)==1)
			{
				Node<Triangle> tri=e.data.incidenttriangle.getNodeAt(0);
				for(int j=0;j<e.data.incidenttriangle.size();j++) {      //constant time bcoz edge will have max two triangles
					
					if(t.compareTo(tri.data)==0 )
						
						{
//						System.out.println("hehe "+tri);
						trilist.addLast(tri.data);
						
						}
				}
				tri=tri.next;
				found1=true;
			}
			
			if(b.compareTo(e.data)==1)
			{
				Node<Triangle> tri=e.data.incidenttriangle.getNodeAt(0);
				
				for(int j=0;j<e.data.incidenttriangle.size();j++) {      //constant time bcoz edge will have max two triangles
					
					if(t.compareTo(tri.data)==0)
						{
//						System.out.println("hehe "+tri);
						trilist.addLast(tri.data);
						}
					tri=tri.next;
				}
				found2=true;
			}
			
			if(c.compareTo(e.data)==1)
			{
				Node<Triangle> tri=e.data.incidenttriangle.getNodeAt(0);
				for(int j=0;j<e.data.incidenttriangle.size();j++) {      //constant time bcoz edge will have max two triangles
					
					if(t.compareTo(tri.data)==0)
						{
//						System.out.println("hehe "+tri);
						trilist.addLast(tri.data);
						}
					tri=tri.next;
				}
				found3=true;
			}
			
			e=e.next;
		}
		Triangle[] fintri=new Triangle[trilist.size()];
//		System.out.println("okkskoks");
		Node<Triangle> tw=trilist.getNodeAt(0);
		for(int i=0;i<trilist.size();i++) {
			
			fintri[i]=tw.data;
//			System.out.println(fintri[i]);
			tw=tw.next;
		}
		//quicksort on fintri
		quicksorttri(fintri,0,trilist.size()-1);
		Triangle[] finaltri=new Triangle[trilist.size()];
		int j=0;
		for(int i=0;i<trilist.size();i++) {
			finaltri[j]=fintri[i];
			while(i+1<trilist.size() && fintri[i].pos==fintri[i+1].pos ) {
				
				i++;
			}
			
//			System.out.println(finaltri[j]+" p "+fintri[i].pos);
			j++;
			
		}
		Triangle[] tempi=new Triangle[j];
		for(int i=0;i<j;i++) {
			tempi[i]=finaltri[i];
		}
		
		return tempi;
		
	}


	//INPUT [x,y,z]
	public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){
		float x1=point_coordinates[0];
		float y1=point_coordinates[1];
		float z1=point_coordinates[2];
		Point a=new Point(x1,y1,z1);
		Point x=null;
		boolean flag=false;
		Node<Point> p=allpoints.getNodeAt(0);
		for(int i=0;i<allpoints.size();i++) {
			
			if(a.compareTo(p.data)==1) {
				x=p.data;
//				x.incidenttriangle=p.incidenttriangle;
			
				flag=true;
				break;
			}
			
			p=p.next;
		}
		if(flag==false)
			return null;
		int size=x.incidenttriangle.size();
		Triangle[] tris=new Triangle[size];
		Node<Triangle> tr=x.incidenttriangle.getNodeAt(0);
		for(int i=0;i<size;i++) {
			tris[i]=tr.data;
			tr=tr.next;
		}
//		quicksorttri(tris,0,size-1);
		
//		for(int i=0;i<size;i++) {
//			System.out.println(tris[i]+"pos "+tris[i].pos);
//		}
		return tris;
		
	}


	// INPUT [x,y,z]
	public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
		
		float x1=point_coordinates[0];
		float y1=point_coordinates[1];
		float z1=point_coordinates[2];
		Point a=new Point(x1,y1,z1);
		Point x=null;
		boolean flag=false;
		Node<Point> p=allpoints.getNodeAt(0);
		for(int i=0;i<allpoints.size();i++) {
			
			if(a.compareTo(p.data)==1) {
				x=p.data;
//				x.pointlist.display();
//				x.incidenttriangle=p.incidenttriangle;
			
				flag=true;
				break;
			}
			p=p.next;
			
		}
		if(flag==false)
			return null;
		Point[] tris=new Point[x.pointlist.size()];

		
		Node<Point> k=x.pointlist.getNodeAt(0);
		for(int i=0;i<x.pointlist.size();i++) {
			
		
			tris[i]=k.data;
			k=k.next;
//			System.out.println(tris[i]);
		}
		
		
		
		
		return tris;
		
		}


	// INPUT[x,y,z]
	public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){
		
		
		float x1=point_coordinates[0];
		float y1=point_coordinates[1];
		float z1=point_coordinates[2];
		Point a=new Point(x1,y1,z1);
		Point x=null;
		boolean flag=false;
		Node<Point> p=allpoints.getNodeAt(0);
		for(int i=0;i<allpoints.size();i++) {
			
			if(a.compareTo(p.data)==1) {
				x=p.data;			
				flag=true;
				break;
			}
			
			p=p.next;
		}
		if(flag==false)
			return null;
		int size=x.edgelist.size();
		Edge[] tris=new Edge[size];
		Node<Edge> e=x.edgelist.getNodeAt(0);
		for(int i=0;i<size;i++) {
			tris[i]=e.data;
			e=e.next;
		}

		
//		for(int i=0;i<size;i++) {
//			System.out.println(tris[i]+"pos "+tris[i].distance());
//		}
		return tris;
		
		}


	// INPUT[x,y,z]
	public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ 

		float x1=point_coordinates[0];
		float y1=point_coordinates[1];
		float z1=point_coordinates[2];
		Point a=new Point(x1,y1,z1);
		Point x=null;
		boolean flag=false;
		Node<Point> p=allpoints.getNodeAt(0);
		for(int i=0;i<allpoints.size();i++) {
//			Point p=allpoints.getAt(i);
			if(a.compareTo(p.data)==1) {
				x=p.data;
//				x.incidenttriangle=p.incidenttriangle;
			
				flag=true;
				break;
			}
			
			p=p.next;
		}
		if(flag==false)
			return null;
		int size=x.incidenttriangle.size();
		Triangle[] tris=new Triangle[size];
		
		
		
		Node<Triangle> e=x.incidenttriangle.getNodeAt(0);
		for(int i=0;i<size;i++) {
			tris[i]=e.data;
			e=e.next;
		}
		
//		quicksorttri(tris,0,size-1);
		
//		for(int i=0;i<size;i++) {
//			System.out.println(tris[i]+"pos "+tris[i].pos);
//		}
		return tris;
	
	}


	public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){
		
//		boolean[] visited=new boolean[alltriangles.size()];
		Point a=new Point(triangle_coord_1[0],triangle_coord_1[1],triangle_coord_1[2]);
		Point b=new Point(triangle_coord_1[3],triangle_coord_1[4],triangle_coord_1[5]);
		Point c=new Point(triangle_coord_1[6],triangle_coord_1[7],triangle_coord_1[8]);
		
		
		Point d=new Point(triangle_coord_2[0],triangle_coord_2[1],triangle_coord_2[2]);
		Point e=new Point(triangle_coord_2[3],triangle_coord_2[4],triangle_coord_2[5]);
		Point f=new Point(triangle_coord_2[6],triangle_coord_2[7],triangle_coord_2[8]);
		
		
		
		Triangle temp=new Triangle(a,b,c);
		
		int index=-1;
		Triangle dest=new Triangle(d,e,f);
//		int pos=-1;
//		alltriangles.display();
		LinkedList<Triangle> path=new LinkedList<Triangle>();
		Node<Triangle> tu=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			if(tu.data.compareTo(temp)==1)
			{
				index=i;
//				pos=t.pos;
			}
				tu.data.visited=false;
				tu=tu.next;
			
		}
		Triangle start=alltriangles.getAt(index);
		start.visited=true;
		path.addFirst(start);
		int size=path.size();
		while(size>0) {
			Triangle t =path.removeFirst();
//			System.out.println("PATH ELEMENT "+t);
			size--;
			Node<Triangle> tri=t.tris.getNodeAt(0);
			for(int j=0;j<t.tris.size();j++) {
				
				if(tri.data.visited==false)
				{path.addFirst(tri.data);
				size++;
				tri.data.visited=true;
				if(tri.data.compareTo(dest)==1)
					return true;
				}
				tri=tri.next;
			}
		}
		
		
		return false;}
	

	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates)
	{ 
		float x1=edge_coordinates[0];
		float y1=edge_coordinates[1];
		float z1=edge_coordinates[2];
		float x2=edge_coordinates[3];
		float y2=edge_coordinates[4];
		float z2=edge_coordinates[5];
		Point a=new Point(x1,y1,z1);
		Point b=new Point(x2,y2,z2);
		Edge ab=new Edge(a,b);
		Edge x=null;
		boolean flag=false;
		Node<Edge> p=alledges.getNodeAt(0);
		for(int i=0;i<alledges.size();i++) {
			
			if(ab.compareTo(p.data)==1) {
				x=p.data;
//				x.incidenttriangle=p.incidenttriangle;
			
				flag=true;
				break;
			}
			p=p.next;
			
		}
		if(flag==false)
			return null;
		int size=x.trianglelist.size();
		Triangle[] tris=new Triangle[size];
		Node<Triangle> t=x.trianglelist.getNodeAt(0);
		for(int i=0;i<size;i++) {
			tris[i]=t.data;
			t=t.next;
		}
//		quicksorttri(tris,0,size-1);
		
//		for(int i=0;i<size;i++) {
//			System.out.println(tris[i]+"pos "+tris[i].pos);
//		}
		return tris;		
		
		
		
	}
	
	public int bfs(Triangle start) {
		int index=-1;
		
//		Triangle[] prev=new Triangle[alltriangles.size()];
		Integer[] dist=new Integer[alltriangles.size()];
		Node<Triangle> t=alltriangles.getNodeAt(0);
		for(int i=0;i<alltriangles.size();i++) {
			
			t.data.bfsvisited=false;
//			if(t.compareTo(start)==1)
//				index=i;
//			prev[i]=null;
			dist[i]=2147483647;
			t=t.next;
		}
		LinkedList<Triangle> queue=new LinkedList<Triangle>();
//		Triangle temp=alltriangles.getAt(index);
		Triangle temp=start;
		
		temp.bfsvisited=true;
		queue.addLast(temp);
		int size=queue.size();
		dist[temp.pos]=0;                         ///dist[i] returns minimum distance from source to ith dest
		int max=0;
//		System.out.println("max size"+alltriangles.size());
		while(size>0) {
			Triangle f=queue.removeFirst();
			size--;
			Node<Triangle> oo=f.tris.getNodeAt(0);
			for(int i=0;i<f.tris.size();i++) {
				
				if(oo.data.bfsvisited==false) {
					oo.data.bfsvisited=true;
					queue.addLast(oo.data);
					size++;
//					System.out.println("pos "+oo.pos+" "+f.pos);
//					prev[oo.pos]=f;                              ////wont work for triangles added afterwards
					dist[oo.data.pos]=dist[f.pos]+1;
					if(dist[oo.data.pos]>max)
						max=dist[oo.data.pos];
				}
				oo=oo.next;
			}
		}
		
		
	return max;	
		
	}
	public void helpdia(Triangle t) {
		 // Mark the current node as visited and print it 
      visited[t.pos]=true;
       counter++;
       
      int k= bfs(t);    ///visited nodes are getting varied need to get back the initial condition
       if(maxbfs<=k)
    	   maxbfs=k;
        
       // Recur for all the vertices 
       // adjacent to this vertex 
       Node<Triangle> tri=t.tris.getNodeAt(0);
       for (int i=0;i<t.tris.size();i++) { 
       	
           if(!visited[tri.data.pos]) 
           	helpdia(tri.data);
           
           tri=tri.next;
       } 
     
	}
	
	
	
	int counter=0;
	int maxbfs=0;
	public int MAXIMUM_DIAMETER(){
		int count=0;
		counter=0;
		
		Node<Triangle> t=alltriangles.getNodeAt(0);
		visited=new boolean[alltriangles.size()];
		int[] max=new int[alltriangles.size()];
		int[] innercounter=new int[alltriangles.size()];
		t=alltriangles.getNodeAt(0);
	        for(int i = 0; i < alltriangles.size(); ++i) { 
	        	
	            if(!visited[t.data.pos]) { 
	                // print all reachable vertices 
	                // from v 
	            	maxbfs=0;
	            	counter=0;
	                helpdia(t.data); 
	                innercounter[i]=counter;
	               
	                max[i]=maxbfs;
	                count++;
//	                System.out.println(); 
	            } 
	        } 
	        t=t.next;
		int maxindex=0;
		if(count>0) {
			int maxinner=innercounter[0];
			for(int i=0;i<alltriangles.size();i++) {
				if(innercounter[i]>maxinner)
					{maxinner=innercounter[i];
					
					maxindex=i;
					}
			}
//
//			}
		}
		System.out.println("final"+max[maxindex]);
		return max[maxindex];
		}

	
	
	
	
	boolean[] visited;
	public Point help2(Point t,float x,float y,float z,int count,boolean[] visited) {

       visited[t.pos]=true; 
      
//       System.out.println("before "+x+ " "+y+" "+z+" ");
       Point p=null;
       
   	Node<Point> po=t.pointlist.getNodeAt(0);
       for (int i=0;i<t.pointlist.size();i++) { 

//    	   
           if(!visited[po.data.pos]) 
           {

        	   x=x+po.data.x; 
               y=y+po.data.y;
               z=z+po.data.z;

        	  
        	   count++;
//        	   System.out.println(count);
        	   p=new Point(x/count,y/count,z/count);
        	   finp=p;
//        	   System.out.println(finp);
           p=help2(po.data,x,y,z,count,visited); 
           	
           }
          
           
           po=po.next;
       } 
//       System.out.println(count);
      
       return p;
       
	}

	//

	
	public PointInterface [] CENTROID (){
		LinkedList<Point> centroid= new LinkedList<Point>();
		Node<Point> t=allpoints.getNodeAt(0);
		visited=new boolean[allpoints.size()];
		
//		Point p=null;
		Point cen=null;
		t=allpoints.getNodeAt(0);
	        for(int i = 0; i < allpoints.size(); ++i) { 
	        	
//	        	System.out.println(t);
	            if(!visited[t.data.pos]) 
	            { 
	            	finp=t.data;
	                // print all reachable vertices 
	                // from v 
//	            	t.data.pointlist.display();
	                help2(t.data,t.data.x,t.data.y,t.data.z,1,visited);
	                cen= new Point(finp.x,finp.y,finp.z);
	                centroid.addLast(cen);
	                
//	                System.out.println(); 
	            } 
	            t=t.next;
	        } 
		Point[] centr= new Point[centroid.size()];
		Node<Point> po=centroid.getNodeAt(0);
		
		for(int i=0;i<centroid.size();i++) {
			
			centr[i]=po.data;
			po=po.next;
			System.out.println(centr[i]);
		}
		
	return centr;
	}

	// INPUT [x,y,z]
	Point finp=null;
	public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){
		
		Point k=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
		visited=new boolean[allpoints.size()];

		Point cen=null;
		Node<Point> t=allpoints.getNodeAt(0);
	        for(int i = 0; i < allpoints.size(); ++i) { 
	        	
//	        	System.out.println(t);
	            if(!visited[t.data.pos] && t.data.compareTo(k)==1) 
	            { 
//	            	System.out.println("pointlist");
//	            	t.data.pointlist.display();
	                // print all reachable vertices 
	                // from v 
	            	finp=t.data;
	                help2(t.data,t.data.x,t.data.y,t.data.z,1,visited);
	                
	                cen= new Point(finp.x,finp.y,finp.z);
	                break;
	                
//	                System.out.println(); 
	            }
	            t=t.next;
	        } 
	       
	        System.out.println("cen"+cen);
	return cen;
	}

	public void helpcompo(Point t,int k) {
		 // Mark the current node as visited and print it 
      visited[t.pos]=true; 
      
     t.component=k;
 
      // Recur for all the vertices 
      // adjacent to this vertex 
     Node<Point> po=t.pointlist.getNodeAt(0);
      for (int i=0;i<t.pointlist.size();i++) { 
      	
          if(!visited[po.data.pos]) 
          {
        	  po.data.component=k;
//        	  System.out.println(po+" "+t.component);
          	helpcompo(po.data,k); 
          	
          }
          po=po.next;
      } 
      
      
	}
	
	
	
	public 	PointInterface [] CLOSEST_COMPONENTS(){
		
		visited=new boolean[allpoints.size()];
		
		int count=0;
		
		Node<Point> t=allpoints.getNodeAt(0);
	        for(int i = 0; i < allpoints.size(); ++i) { 
	        	
	        	
	            if(!visited[t.data.pos]) 
	            { 
	                // print all reachable vertices 
	                // from v 
	                helpcompo(t.data,count);
	                
	                count++;
	                
//	                System.out.println(); 
	            } 
	            t=t.next;
	        } 
	        
	        float min=Integer.MAX_VALUE;
	        Point p1=null;
	        Point p2=null;
	        Node<Point> a=allpoints.getNodeAt(0);
	        for(int i=0;i<allpoints.size();i++) {
	        	Node<Point> b=allpoints.getNodeAt(0);
	        	for(int j=0;j<allpoints.size();j++) {
	        		
	        		float dist=(a.data.x-b.data.x)*(a.data.x-b.data.x)+(a.data.y-b.data.y)*(a.data.y-b.data.y)+(a.data.z-b.data.z)*(a.data.z-b.data.z);
	        		if(dist<=min && a.data.component!=b.data.component) {
	        			min=dist;
	        			p1=a.data;
	        			p2=b.data;
	        		}
	        		b=b.next;
	        	}
	        	a=a.next;
	        }
	       Point[] arr=new Point[]{p1,p2}; 
	       
	       System.out.println(p1+" "+p2);
	       return arr;
	}








}
