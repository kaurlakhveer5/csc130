public class node{
	public int dist;
	public String neighbour;
	public node next;
	
	public node(){
		this(0, null, null);
	}
	public node(int data){
		this(data, null, null);
	}
	public node(int data, String neighbour){
		this.dist = data;
		this.neighbour = neighbour;
	}
	
	public node(int data, String neighbour, node next){
		this.dist = data;
		this.neighbour = neighbour;
		this.next = next;
	}	
	

	
}
