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
		** Задание 1.
		**
		** Создайте лямбду isIllegalString, принимающую множество символов и строку, проверяющую, содержит ли строка символы не из множества.
		**
		** Примеры:
		** isIllegalString.test(Set.of('a', 'b'), "abc") == true
		** isIllegalString.test(Set.of('a', 'b'), "ab")  == false
		*/
		isIllegalString <Set<Character>, String> isillegalString = (ch, s)->s.chars().filter(c-> !ch.contains((char) c)).count() != 0;
		System.out.println(isillegalString.test(Set.of('a','b'), "abc"));
		System.out.println(isillegalString.test(Set.of('a','b'), "ab"));
		System.out.println();

		/*
		** Задание 2.
		**
		** Напишите функцию printHello(), печатающую на стандартный поток вывода приветствие,
		** и возвращающую void. Присвойте локальной переменной ссылку на эту функцию.
		*/

		LambdaPractice l = new LambdaPractice();
		MyInterface mi = ()->System.out.println("Hello world");
		mi = l::printHello;
		mi.run();
		System.out.println();
		
		/*
		** Задание 3.
		**
		** Создайте лямбду printCode для применения к String, принимающую Character и печатающую код символа на экран (с пробелом).
		**
		** Пример: printCode.accept("abc") печатает 97 98 99
		*/
		
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