class AverageInArray{
	public static void main(String args[]){
		double arr[] = {10.5, 15.5, 20.0, 100.0, 999.0, 846.0, 157.0, 582.0, 521.0, 710.0};
		double sum;
		double num;

		sum = 0.0;
		num = 0.0;
		for (double x : arr) {
			sum += x;
			num++;
		}
		System.out.println("Average is : " + sum / num);
	}
}