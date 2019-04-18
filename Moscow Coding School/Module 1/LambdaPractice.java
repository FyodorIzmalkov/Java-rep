import java.util.Set;
import java.util.Arrays;


public class LambdaPractice{

	interface isIllegalString <T, U>{
		boolean test(T chars, String str);
	}

	interface MyInterface{
		void run();
	}

	interface printCode<T>{
		void accept(String str);
	}

	void printHello(){
		System.out.println("Hello!");
	}
	
	public static void main(String args[]){

		isIllegalString <Set<Character>, String> isillegalString = (ch, s)-> ch != null && s != null && !Arrays.equals(ch, s.toCharArray());
		LambdaPractice l = new LambdaPractice();
		MyInterface mi = ()->System.out.println("Hello world");
		mi = l::printHello;
		mi.run();
		System.out.println();
		
		printCode <String> pc = str->{
			for (int i = 0; i < str.length(); i++)
			{
				System.out.print((int)str.charAt(i));
				if (i != str.length() - 1)
					System.out.print(" ");
			}
			System.out.println();
		};
		pc.accept("abc");

	}
}