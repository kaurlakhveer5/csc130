import java.util.Scanner;
public class client{ 
	private static AVLNode root;
	private static AVLNode root2;
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String enter;					//variable to know whether user has pressed enter
		int RandFor2T;					//Random number to generate Second Tree 
		int[] myArray = new int[5000];	//Array initializing 
		AVLTree ft = new AVLTree();		//Creating FirstTree
		AVLTree st = new AVLTree();		//Creating SecondTree

		//AVLTree testTree = new AVLTree();
		//3, 2, 1, 4, 5, 6, 7, 16,15, 14, 13, 12, 11, 10, 8, 
		
		/*root = testTree.insert(root, 3);
		root = testTree.insert(root, 2);
		root = testTree.insert(root, 1);
		root = testTree.insert(root, 4);
		root = testTree.insert(root, 5);
		root = testTree.insert(root, 6);
		root = testTree.insert(root, 7);
		root = testTree.insert(root, 16);
		root = testTree.insert(root, 15);
		root = testTree.insert(root, 14);
		root = testTree.insert(root, 13);
		root = testTree.insert(root, 12);
		root = testTree.insert(root, 11);
		root = testTree.insert(root, 10);
		root = testTree.insert(root, 8);
		inOrder(root);
		System.out.println();
		root = testTree.remove(root, 9);
		root = testTree.remove(root, 6);
		root = testTree.remove(root, 1);
		root = testTree.remove(root, 3);
		inOrder(root);
	} */
		//9, 6, 1, 3,  
		
		
      
		do{								//Forever Loop
         long startTime = System.currentTimeMillis();
			for(int i = 0; i< myArray.length; i++){      //Loop to Create Random numbers to fill an array
				myArray[i] = (int)(Math.random() * 4099);
				//System.out.print(myArray[i] + " ");
            }
			
		
			
			for(int i = 0; i< myArray.length; i++){ 	//Loop inserting numbers from Array to tree
			root = ft.insert(root,  myArray[i]);}
			
			//inOrder(root);
			//System.out.println();
			
			while(root != null){						//Remove the smallest value from array until it is empty
				int min= ft.findMin(root).val;			//Finding node with minimum value in the First Tree
				root = ft.remove(root, min);			//Remove the node carrying minimum value
				//System.out.println("The process with a Priority of " + min +  " is now scheduled to run!");
				RandFor2T = (int)(Math.random() * 4099);		//Creating random for second tree
				root2 = st.insert(root2, RandFor2T);		//inserting nodes in second tree
				//System.out.println("The process with a priority of " + min + " has run out of its timeslice");
				//inOrder(root);
				//System.out.println();
			}
			long EndTime = System.currentTimeMillis();
         long TotalTime = EndTime - startTime;
			System.out.println("Total time taken " + TotalTime + " milliseconds   startTime: " + startTime + "End Time " + EndTime );
			System.out.println("Every process has got a chance to run; Please press \"Enter \" to start the next round.");
			enter = console.nextLine();						//Saving the user input in variable "enter
		}
		while(enter.equals(""));							//while user pressed enter, continue the loop 
	
	}
	
	public static void inOrder(AVLNode root){				//Print my tree nodes InOrder
		
		if(root != null){
			inOrder(root.left);
			System.out.printf("%d  ", root.val);
			inOrder(root.right);
		}
	}
	
	
}

