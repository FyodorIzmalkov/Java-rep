import java.io.File;
import java.io.FileFilter;

public class Lambda{

	@FunctionalInterface
	interface MyInterface{
		String run();
	}

	interface MyInterface2{
		String run(String a, String b);
	}

	interface MyInterface3{
		String run(String a);
	}

	interface MyInterface4<T, F>{
		F run(T i);
	}

	interface Predicate<T>{
		boolean test(T a);
	}

	interface Function<String, Integer>{
		Integer apply(String s);
	}

	interface Supplier<T>{
		T get();
	}

	interface Consumer<I>{
		void accept(I s);
	}

	static void processValues(String[] values, Function<String, Integer> f){
		for (String v: values){
			System.out.println(f.apply(v));
		}
	}

	static <T,R> void processValues1(T[] values, Function<T, R> f){
		for (T v: values){
			System.out.println(f.apply(v));
		}
	}

	static void showValues(String [] values, Predicate <String> p){
		for (String v: values){
			if (p.test(v)){
				System.out.println(v);
			}
		}
	}

	static String supply(){
		return "hello from supply";
	}

	String supply2(){
		return "hello from supply2";
	}

	void consumer2(String s){
		System.out.println(s + " hello from consumer2");
	}

	public static void main(String args[]){
		FileFilter fileFilter = path->path.getName().endsWith("java");
		File dir  = new File ("./src");
		File[] files = dir.listFiles(fileFilter);
		for (File f: files){
			System.out.println(f);
		}

		MyInterface i = ()->{
			System.out.println("Hello!");
			return "bye";
		};
		String s = i.run();

		MyInterface i2 = ()->"Hello again.";
		System.out.println(s);
		System.out.println(i2.run());

		MyInterface2 i3 = (String a, String b)->{
			System.out.println("Hello " + a + b);
			return "bye";
		};

		MyInterface2 i4 = (a, b)->(a + b);

		String s1 = i3.run("Nikolay", " Korolev");
		System.out.println(s1);

		System.out.println(i4.run("I called the ", "i4 interface."));

		MyInterface3 i5 = a->"I just returning " +a;
		System.out.println(i5.run("Its 5th interface"));

		MyInterface4<Integer, String> i6 = a->""+a+1;
		String j = i6.run(5);
		System.out.println(j);

		Predicate <String> i7 = str->str.startsWith("a");
		System.out.println(i7.test("Hello"));
		System.out.println(i7.test("aallooo"));

		showValues(new String[]{"hello", "alko", "arnold", "arsenal", "uyyjks"}, str->str.startsWith("a"));
		System.out.println();
		showValues(new String[]{"hello", "alkoa", "arnolda", "arsenal", "uyyjks"}, str->str.startsWith("a") && str.endsWith("a"));
		System.out.println();
		processValues(new String[]{"hello", "alkoa", "arnolda", "arsenal", "uyyjks"}, str->str.length());
		System.out.println();
		processValues1(new String[]{"hello", "alkoa", "arnolda", "arsenal", "uyyjks"}, str->str + str);
		System.out.println();

		Supplier<String> ss = ()->"I am supplier.";
		ss = ()->Lambda.supply();
		ss = Lambda::supply; // присваиваем в переменную ss ссылку на функцию supply
		Lambda l = new Lambda();
		ss = l::supply2; // присваиваем ссылку на конкретную функцию supply2 в объекте l 
		// второй вариант ss = ()->l.supply2();
		System.out.println(ss.get());

		System.out.println();
		Consumer<String> c = sss->System.out.println(sss);
		c.accept("Hello World again.");
		c = l::consumer2;
		c.accept("Q Q");
	}
}