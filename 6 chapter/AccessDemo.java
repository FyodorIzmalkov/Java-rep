class Myclass{
	private int alpha;
	public int beta;
	int gamma;

	void setAlpha(int a){
		alpha = a;
	}

	int getAlpha(){
		return alpha;
	}
}

class AccessDemo{
	public static void main(String args[]){
		Myclass ob = new Myclass();

		ob.setAlpha(-99);
		System.out.println("Alpha is: " + ob.getAlpha());
		ob.gamma = 99;
	}
}