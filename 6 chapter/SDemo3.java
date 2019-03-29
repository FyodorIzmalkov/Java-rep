class StaticBlock{
	static double rootof2;
	static double rootof3;

	static{
		System.out.println("Inside static block.");
		rootof2 = Math.sqrt(2.0);
		rootof3 = Math.sqrt(3.0);
	}

	StaticBlock(String msg){
		System.out.println(msg);
	}
}

class Sdemo3{
	static public void main(String args[]){
		StaticBlock ob = new StaticBlock("Inside constructor. Hello!");

		System.out.println("Sqr of 2 is: " + StaticBlock.rootof2);
		System.out.println("Sqr of 3 is: " + StaticBlock.rootof3);
	}
}