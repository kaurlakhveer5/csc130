public class edge{
	public  node front;
	
	public edge(){
		front = null;
	}

	public void add(int index, int value, String city){
		if(index == 0)
			front = new node(value, city);
		else{
			node current = front;
			for(int i = 0; i< index-1; i++)
				current = current.next;
			current.next = new node(value, city);	 
		}
	}
	public String toString(){
		if(front == null)
			return "[]";
		else{
			String result = "[" + front.neighbour + ":" + front.dist;
		
			node current = front.next;
			while(current!=null){
				result += ", " + current.neighbour + ":" + current.dist;
				current = current.next;
			}
			result += "]";
			return result;
		}
	
	}	
	
	
	public node nodeAt(int index){
		node current = front;
		for(int i = 0; i<index; i++)
			current = current.next;
		return current;
	}
	
	
	
	
	public int size(){
		int count = 0;
		node current = front;
		while(current != null){
		current = current.next;
		count++;
		}
		return count;
	}
	
	
	
}


/*	public  void add(int value, String city){
	if (front == null)
		front = new node(value, city);
		
	else{
		node current = front;
		while(current.next != null)
			current = current.next;
	
		current.next = new node(value, city);
	}
}
*/