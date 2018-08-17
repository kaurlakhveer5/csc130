public class heap{
	 int[] array;
	 int size;
	 int arraysize;
    int min;
	
	public heap(int arraysize){
		this.size = 0;
		this.arraysize = arraysize;
		array = new int[this.arraysize+1];
	}	

	public void insert(int x){
		if(size >= array.length-1) System.out.println("Out Of Bound Exception"); 
		//percolate up
		else{
			int hole = ++size;
			for(hole = size; hole>1 && x < array[hole/2]; hole/= 2)
				array[hole] = array[hole/2];
			array[hole] = x;
      }
      //System.out.println("Size: " + size + "  Inserted: " + x);
   }
	
	public void deleteMin(){
		int child = 1; //int test = 0;  
		if(size == 0) System.out.println("All items Deleted!");
		else{
			int hole = 1; min = array[hole]; 
			array[hole] = array[size--]; //int temp = array[hole];
			while(hole*2 <= size && (array[hole] > array[hole*2] || array[hole] > array[hole*2+1])){
				if(array[hole] > array[hole*2])
				 child = hole*2;
				if(child != size && array[hole*2] > array[hole*2+1])
				 child = hole*2+1;
				array[hole] = array[child];
				//array[child] = temp;
            hole = child;
			}
		}
      //System.out.println("size: " + size + " Deleted: " + min);
	}
	public void print(){
      //System.out.println("size: " + size);
		for(int i = 1; i<=size; i++)
			//System.out.println("Parent: " + array[i] + " Left child: " + array[2*i] + " Right Child: " + array[2*i+1]);
         System.out.print(array[i] + " ");
         System.out.println();
	}	
}
	
	
