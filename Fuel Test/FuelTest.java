import java.util.*;
public class FuelTest{
	public static void main(String[] args){
		Fuel MyHighwayDriving = new Fuel();
		Fuel MyCityDriving = new Fuel();
		Fuel MyOtherCar = new Fuel();
		System.out.println("Testing the toString method:");
		System.out.println("myHighwayDriving is: \n" + MyHighwayDriving);
		System.out.println("TESTING the logmiles method using"
				+ "logMiles(100,4.0,3.00)");
		MyHighwayDriving.getMiles(100, 4.0,3.00);
		System.out.println("myHighwayDriving is: \n" + MyHighwayDriving);
		System.out.println("After logMiles(44, 2.0, 2.00)");
		MyHighwayDriving.getMiles(44, 2.0, 2.00);
		System.out.println("myHighwayDriving is: \n" + MyHighwayDriving);
		System.out.println("\nTesting the getMiles Method\nMyhighwayDriving miles are: " + MyHighwayDriving.getMiles());
		System.out.println("\nTesting the getGasUsed Method\nMyhighwayDriving gas used is: " + MyHighwayDriving.getGasUsed());
		System.out.println("\nTesting the getTotalCost Method\nMyhighwayDriving total cost is: " + MyHighwayDriving.getTotalCost());
		
		System.out.println("\nTesting the reset method");
		MyHighwayDriving.reset();
		System.out.println("\nAfter resetting myHighwayDriving is: \n" + MyHighwayDriving);
		System.out.println("\ntesting the equals method" );
		System.out.println("\nTHe fuelCalculators being tested are: " );
		
		MyHighwayDriving.getMiles(1000, 31.0, 3.09);
		MyCityDriving.getMiles(100, 3.0, 2.99);
		MyOtherCar.getMiles(1001, 31.0, 3.09);
		System.out.println(MyOtherCar);
		
		if (MyCityDriving.equals(MyHighwayDriving)){
			System.out.println("My Highway Driving is EQUAL to my City Driving");}
		else
			System.out.print("My Highway Driving is NOT equal to my City Driving\n");
				
	
	
	if (MyOtherCar.equals(MyHighwayDriving)){
		System.out.println("My Highway Driving is EQUAL to my other car driving");}
	else
		System.out.print("My Highway Driving is NOT equal to my other car driving");
			
	}
		
		
		
		
		
		
		
		
		
		
		
		
			
		
		
	}

	
