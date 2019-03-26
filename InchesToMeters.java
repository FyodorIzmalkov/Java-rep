public class InchesToMeters{
	public static void main(String args[]){
		int counter;
		int inches;
		int max_table;
		double metres;
		double metres_conversion;

		counter = 0;
		max_table = 12 * 12;
		metres_conversion = 1 / 39.37;
		for (inches = 1; inches <= max_table; inches++){
			metres = inches * metres_conversion;
			System.out.println(inches + " inches is " + metres + " metres.");
			counter++;
			if (counter == 12){
				System.out.println();
				counter = 0;
			}
		}
	}
}