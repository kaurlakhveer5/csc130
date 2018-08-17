/*Lakhveer Kaur
 * CSC 130
 * Assignment #1
 * Finding Nth Fibonacci Number
*/

import java.util.*;
public class assign1{
	public static void main(String [] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the Fibonacci term that you want to find: ");
		int n = console.nextInt();			//n = nth term
		int first = 1;
		int second = 1;
		int Nth = 0;						// declaring and intializing the Nth term
		while(n<0){
			System.out.print("Oops! Please try again with a positive number: ");
			n = console.nextInt();
		}
		
		if(n==0 || n==1){
			Nth = 1;
		}
		else{
			for(int i = 2; i<=n; i++){
				Nth = first + second;
				first = second;
				second = Nth;	
			}
		
		}
		System.out.println(n + " term of Fibonacci series is " + Nth);
	

	}
}