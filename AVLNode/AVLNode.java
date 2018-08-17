public class AVLNode{
	public int val;
	public AVLNode left;
	public AVLNode right;
	public int height;
	
	public AVLNode(int val){
		this(val, null, null, 1);
	}
	public AVLNode(int val, AVLNode left, AVLNode right, int height){
		this.val = val;
		this.left = left;
		this.right = right;
		this.height = height;
	}	
}