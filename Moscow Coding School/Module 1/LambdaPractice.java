import java.util.Set;
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

		/*
		** First task.
		*/

		isIllegalString <Set<Character>, String> isillegalString = (ch, s)->s.chars().filter(c-> !ch.contains((char) c)).count() != 0;
		System.out.println(isillegalString.test(Set.of('a','b'), "abc"));
		System.out.println(isillegalString.test(Set.of('a','b'), "ab"));
		System.out.println();

		/*
		** Second task.
		*/

		LambdaPractice l = new LambdaPractice();
		MyInterface mi = ()->System.out.println("Hello world");
		mi = l::printHello;
		mi.run();
		System.out.println();
		
		/*
		** Thrid task.
		*/

		printCode <String> pc = str->{for (int i = 0; i < str.length(); i++) System.out.print((int)str.charAt(i) + " ");};
		pc.accept("abc");
	}
}