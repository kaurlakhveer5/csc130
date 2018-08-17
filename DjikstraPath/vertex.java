import java.lang.reflect.Array;

public class vertex{
	private static final int MAX_VALUE = 0;
	String name; 
	public int totalVertices;
	public edge adjNode;
	public vertex NextV;
	public boolean known;
	public int index;
	public int dist;
	public vertex path;
	
	
	public vertex(String city, edge e){
		this.name = city;
		this.index = totalVertices++;
		this.adjNode = e;
		this.NextV = null;
		this.dist = Integer.MAX_VALUE;
      this.known = false;
		totalVertices++;
	}	
	
	public vertex(){
		name = null;
		adjNode = null;
	}

	
	
	
	
}	
	
	

	
	
	
		


