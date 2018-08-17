public class AVLTree{
	 AVLNode root;
	
	/*public AVLTree(){
		root = null;
	}*/
	public AVLNode findMin(AVLNode t){		//Minimum value is on the left most in AVL Tree
		while(t.left != null)				//While Loop runs until there is a left node
			t = t.left; 					
		return t;							//returns the smallest value
	}
	boolean contains(AVLNode t, int x){
		if(t == null) return false;
		if(t.val == x) return true;
		if(t.val > x) return contains(t.left, x);
		return contains(t.right, x);
	}
	
	AVLNode rotateToRight(AVLNode k2){ 			
		AVLNode k1 = k2.left;				//assign a variable k1 to the left part of node for later use
		k2.left = k1.right;					//Update the node's left part to newly assigned variable's right
		k1.right = k2;						//update k1's right
		k2.height = Math.max(height(k2.left), height(k2.right))+1;   //Update k2's height
		k1.height = Math.max(height(k1.left), height(k1.right))+1;   //Update k1's height
		return k1;
	}
	AVLNode rotateToLeft(AVLNode k2){
		AVLNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), height(k1.right))+1;
		return k1;
	}
	AVLNode doubleRotateToRight(AVLNode k3){
		AVLNode k1 = k3.left;
		k3.left = rotateToLeft(k1);
		return rotateToRight(k3);
	}
	AVLNode doubleRotateToLeft(AVLNode k3){
		AVLNode k1 = k3.right;
		k3.right = rotateToRight(k1);
		return rotateToLeft(k3);
	}
	
	
	int height(AVLNode t){
		if(t == null)
			return 0;
		else 
			return Math.max(height(t.left), height(t.right))+ 1;	
	}
	
	AVLNode insert(AVLNode t, int x)
	{
		if (t== null) return new AVLNode(x, null, null, 1);
		if(x<t.val)
		{
			t.left = insert(t.left, x);
			if(height(t.left) - height(t.right) == 2)
			{
				if(x<t.left.val)
					t = rotateToRight(t);
				else 
					t = doubleRotateToRight(t);
			}
		}
		else if(x>t.val)
		{
			t.right = insert(t.right, x);
			if(height(t.right) - height(t.left) == 2)
			{
				if(x>t.right.val)
					t = rotateToLeft(t);
				else 
					t = doubleRotateToLeft(t);
			}
		}
		else 
			t.height = Math.max(height(t.left), height(t.right))+1;
		return t;
	}
			
	AVLNode remove(AVLNode t, int x){
		if(contains(t, x) == false) return t;
		else { 
			if(t == null) return null;
			if(x<t.val){
				t.left = remove(t.left, x);
				if(height(t.right) - height(t.left) == 2)
				{
					if(height(t.right.right) >= height(t.right.left))
						t = rotateToLeft(t);
					else 
						t = doubleRotateToLeft(t);
				}
			}
			else if (x>t.val){
				t.right = remove(t.right, x);
				if(height(t.left) - height(t.right) == 2)
				{
					if(x<t.left.val)
						t = rotateToRight(t);
					else 
						t = doubleRotateToRight(t);
				}
			}
			
			else if(t.left != null && t.right != null){
				t.val = findMin(t.right).val;
				t.right = remove(t.right, t.val);
			}
			else{
				if (t.left != null) return t.left;
				else return t.right;
			}
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}
	}

}