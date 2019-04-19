import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;

public class Streams{
	public static void main(String args[]){
		Stream <String> stream = Stream.of("One", "Two", "Three", "Four", "Five");

		// отбирает экзмепляры которые начинаются с буквы Т и считает их количество
		//System.out.println(stream.filter(s->s.startsWith("T")).count());

		// все экземпляры начинаются с буквы Т
		//System.out.println(stream.allMatch(s->s.startsWith("T")));

		// какой нибудь экземпляр начинается с буквы Т
		//System.out.println(stream.anyMatch(s->s.startsWith("T")));

		//печатает длины всех строк
		//stream.map(s->s.length()).forEach(i-> System.out.println(i));

		// печатает через ссылку принта
		//stream.map(s->s.length()).forEach(System.out::print);

		// преобразовывает строки в их длины  и собирает их в сэт
		//Set <Integer> set = stream.map(s->s.length()).collect(Collectors.toSet());
		//System.out.println(set);

		// преобразовывает строки в их длины и собирает их в лист
		//List <Integer> list = stream.map(s->s.length()).collect(Collectors.toList());
		//System.out.println(list);

		//peek - позволяет подлгятеть в поток не изменяя его
		// stream.map(s-> s.length())
		// 			.peek(System.out::println)
		// 			.filter(i->i > 3)
		// 			.forEach(System.out::print);

		// stream.map(s-> s.length())
		// 			.peek(i-> System.out.println("peek: " + i))
		// 			.filter(i-> i > 3)
		// 			.forEach(System.out::println);

		// stream.peek(str->System.out.println("peek 1: " + str))
		// 			.map(s-> s.length())
		// 			.peek(i -> System.out.println("peek 2: " + i))
		// 			.filter(i -> i > 3)
		// 			.forEach(System.out::println);


		// в конце будет добавлять прошедшие фильтр значения в лист
		// List<Integer> list = new ArrayList<>();
		// stream.map(s-> s.length())
		// 			.filter(i -> i > 3)
		// 			.forEach(list::add); // или можно написать .forEach(i->list.add(i));
		// System.out.println(list);

		/* Операция FlatMap позволяет создавать из потока потоков - поток */
		// flatMap ( l -> l.stream() );
	}
}