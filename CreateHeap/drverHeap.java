import java.util.Scanner;
public class drverHeap{
	public static void main(String[] args){
   	Scanner console = new Scanner(System.in);
		String enter;					//variable to know whether user has pressed enter
		int RandFor2T;					//Random number to generate Second Tree 
		int[] myArray = new int[4098];	//Array initializing 4098
		heap hp1 = new heap(4099);//4099
      heap hp2 = new heap(4099);
		//hp.insert(29);
      //hp.deleteMin(); hp.print();
      do{								//Forever Loop
         long startTime = System.nanoTime();
			for(int i = 0; i< myArray.length; i++){      //Loop to Create Random numbers to fill an array
				myArray[i] = (int)(Math.random() * 4099);
				//System.out.print(myArray[i] + " ");
            }
         hp1.size = 0; hp2.size = 0;
         for(int i = 0; i< myArray.length; i++)
			   hp1.insert(myArray[i]);
         
         while(hp1.size != 0){
          //System.out.println("The process with a Priority of " + hp1.min +  " is now scheduled to run!");
            hp1.deleteMin(); //delete the minimum from heap #1
            RandFor2T = (int)(Math.random() * 4099); //generating random number for heap #2
            hp2.insert(RandFor2T);
            //System.out.println("The process with a priority of " + RandFor2T + " has run out of its timeslice");
         }
         long EndTime = System.nanoTime();
         long TotalTime = EndTime - startTime;
			System.out.println("Total time taken " + TotalTime + " milliseconds");
         //System.out.println("Start Time: " + startTime + " End Time " + EndTime + "  Total time " + TotalTime/1000000); 
			//System.out.println("It took " + TotalTime + " nano secs for all processes to run out of their timeslices; Please press \"Enter \" to start the next round.");
			enter = console.nextLine();						//Saving the user input in variable "enter
		}
		while(enter.equals(""));
         
      
	}
}