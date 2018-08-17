import java.util.Arrays;
import java.util.Scanner;
public class driver{

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String line; String[] cityList; String[] adjacents; String[] city = null; String[] temp; int count = 0; int sourceIndex = 0; int myIndex = 0;
		System.out.println("Please enter all the vertices (using comma separators e.g. folsom, rancho cordova, sacramento...)");
	        line = console.nextLine(); //read 1,2,3
	       //separate all values by comma
	        cityList = line.split(",");
	        
	        //Trim the values, delete the white space
	        Arrays.stream(cityList).map(String::trim).toArray(unused -> cityList);
	        vertex[] array = new vertex[cityList.length];			//Array of Objects
     
	    //Get all the Adjacents and distance from user
	    for(int i = 0; i<cityList.length; i++){
	    	System.out.println("Please Enter the all the adjacent vertices for " + cityList[i]);
	        line = console.nextLine();
	        adjacents = line.split(",");

	       System.out.println("Enter the cost in the same order");
           line = console.nextLine();
           temp = line.split(",");
           int[] prices = new int[temp.length]; 
           
        	
           for (int k = 0; k < prices.length; k++){
        	    prices[k] = Integer.parseInt(temp[k]); 	//parse the string to integer
           }
           
           //Check if same number of prices are enetered
           	if(prices.length != adjacents.length){
           		System.out.println("number of enterd costs are not matching with the number of adjacents entered");
           	break;
           	}
 
	        //Filling the linkedlist with adjacent cities and distances
           edge[] EdgeArray = new edge[cityList.length];	//Array of Edge Objects
           
           for (int j = 0; j<cityList.length; j++){			//Create the edge objects
		        EdgeArray[j] = new edge();
		        
           }
           
           for(int j = 0; j<adjacents.length; j++)
	        	EdgeArray[i].add(j, prices[j], adjacents[j]);   //Fill LinkedList for the first vertex
	        	
           //Fill the vertexes and edges together
          array[i] = new vertex(cityList[i], EdgeArray[i]);
	       System.out.println("city:  " + array[i].name+ " LinkedList:  " +  array[i].adjNode.toString());
	        
	    }

	    //Get the source from user
	    System.out.println("Please enter the source");
        String source = console.next();  
         
        //Index of source
        sourceIndex = FindIndex(source, array);
        vertex sourceV = array[sourceIndex];
        
        FindPath(sourceV, array);
        
        /*for(count = 0; count< array.length; count++){
        	System.out.println("Minimum Distance is as following:");
        	System.out.println(array[count].name + ": " + array[count].dist);
        
        }*/
        
        System.out.println("Please Enter the Destination");
        String destination = console.next();
        int destIndex = FindIndex(destination, array); 
        System.out.println("Minimum Dist/Cost from " + source + " to " + destination + " is " + array[destIndex].dist + "." );
        System.out.println("The Path from right to left is " );
        System.out.print(":) " + destination + " <= ");
        while(!array[destIndex].name.equals(sourceV.name)){
        	System.out.print(" " + array[destIndex].path.name + " <= " );
        	destIndex = FindIndex(array[destIndex].path.name, array);
        }
       
        	
	}
		//System.out.println("Source name is " + sourceV.name + ", Adjacencies are " + sourceV.adjNode.toString());
        	
        //Write a function that find the paths from one to others   	
	
	
	static void FindPath(vertex s, vertex[] array){
		vertex v; 
		int min = Integer.MAX_VALUE;
		//node wN; vertex wV; //wN= adjacent node in LinkedList; wV= find the values in the vertices for wL
		int j =0;
		s.known = true;
		s.dist = 0;
		ShortestPath(s, array);
	
		while(j<array.length-1 ){ //&& array[j].known== false){
			int count = 0;  
			min = Integer.MAX_VALUE;
			for(int i = 0; i<array.length; i++){
				if(array[i].known== false && array[i].dist < min){
					min = array[i].dist;
					count = i;
				}
			}
			v = array[count];
         //System.out.println("count: " + count + "Next v: " + v.name);
			ShortestPath(v, array);
			j++;  		
         }
	}
	   
	
	public static void ShortestPath(vertex v, vertex[] array){
		node wN; vertex wV; node prev;
      //System.out.println("Test: Dist of v is " + v.dist); 
		v.known = true;
		for(int i = 0; i < v.adjNode.size(); i++){
			wV = array[FindIndex(v.adjNode.nodeAt(i).neighbour, array)]; //find this node in Vertex
			//System.out.println("This is my current wV for " + v.name + ": " + wV.name + ". Dist: " + wV.dist);
			wN = v.adjNode.nodeAt(i);							   //Adjacent Nodes 
			//System.out.println("This is my current wN for " + v.name + ": " + wN.neighbour + ". Dist: " + wN.dist);
			if(wV.known == false){
				if(v.dist + wN.dist < wV.dist){
					wV.dist = v.dist + wN.dist;
					wV.path = v;
					//wV.path = array[FindIndex(wN.neighbour, array)];
              // System.out.println("Test: updated dist of wV is " + wV.dist);
				}
				
			}
		}
	}

	public static  int FindIndex(String anyCity, vertex[] array){
		int stupid = -1;
        for(int i = 0; i < array.length; i++){
        	if(anyCity.equals(array[i].name))
        		stupid = i;
        }
        return stupid;
    }
	  
        
	
}
