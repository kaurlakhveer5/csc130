public class Fuel{
	 private int milesDriven;
	 private double gasConsumed;
	 private double totalCost;
	 
	 //default constructaotr
	 public Fuel (){
		 milesDriven = 0;
		 gasConsumed = 0;
		 totalCost = 0;
		 
	 }
	 
	 
	 //construstator
	 public Fuel(int milesD, double gasC, double totalGasU){
		 if(milesD < 0 )
			 milesDriven = 0;
		 else if(gasC< 0)
			 gasConsumed = 0;
		 else if(totalGasU < 0)
			 totalCost = 0;
		 else{
		 
		 milesDriven += milesD;
		 gasConsumed += gasC;
		 totalCost += totalGasU;
	 }
	 }
	 
	 
	 //mutators
	 public boolean getMiles(int newMilesDriven, double gasUsed, double costPerGallon){
		boolean success = false;
		if(newMilesDriven < 0 || gasUsed < 0 || costPerGallon< 0){
			success = false;
		}

		 milesDriven += newMilesDriven;
		 gasConsumed += gasUsed;
		 totalCost += costPerGallon*gasUsed;
		 
		 
		 return true;
	 }
	 
	 public double getFuelEfficiency(){
		double fuelEffici = 0;
		 if(gasConsumed>0)
			 fuelEffici=  milesDriven/gasConsumed;
		 else
			 fuelEffici =  0;
		 
		 return fuelEffici;
	 }
	 	
	 
	 public double getCostPerGallon(){
		 double costpg = 0;
		 if(gasConsumed>0)
			 costpg=  totalCost/gasConsumed;
		 else
			 costpg =  0;
		 
		 return costpg;
	 
		 
	 }
	 
	 public double getMiles(){
		 return milesDriven;
	 }
	 
	 public double getGasUsed(){
		 return gasConsumed;
	 }
	 
	 public double getTotalCost(){
		 return totalCost;
	 }
	
	 public void reset(){
		 milesDriven = 0;	
		 gasConsumed = 0;
		 totalCost = 0;
	 }
	 
	 
	 public boolean equals(Fuel other){
		 double difference = this.getFuelEfficiency()
				 - other.getFuelEfficiency();
				return Math.abs(difference) < 0.1; 
	 }

	 
	 	 
	 public String toString(){
		 String s = "Miles Driven: " +  milesDriven + "\t\tGas Used: " + gasConsumed+
				 " gallons\t\t Total Cost: $" + String.format("%.2f", totalCost) + "\nFuel Efficiency: " +
				 String.format("%.2f", getFuelEfficiency()) + " \t\t Average Cost " +
				 String.format("%.2f", getCostPerGallon());
		
		 return s;
	 }		 
	 
				
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
}