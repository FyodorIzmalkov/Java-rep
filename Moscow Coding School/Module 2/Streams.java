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
		
		// тип Optional говорит о том что значение в нем может быть, а может и не быть
		// Optional <Integer> max = stream.max();
		// .isPresent() возвращает true если в Optional есть значение
		// .get() возвращает значение или null
		// .orElse() позволяет задать значение "по умолчанию"
		//		String s = opt.orElse(""); Т.е либо верни что там лежит либо верни то что мы передаем аргументом
		// .orElseThrow() если там ничего не лежит - выброси исключение
		// 		String s = opt.orElseThrow(MyException::new);

		// Коллекторы позволяют нам собирать значения которые лежат в нашем потоке
		// class - Collectors
		// String s = stream.collect(Collectors.joining("; "));  // объедени все значения через то что мы укажем
		// System.out.println(s);
		// String s = stream.map(i -> "" + i.length()).collect(Collectors.joining("; ")); // коллектору нужны строчки
		// System.out.println(s);

		// FLAT MAP
		// List <Integer> list = new ArrayList<>();
		// stream.flatMap(i->Stream.of(i, i.length())) // Берем каждое значение из нашего потока и создаем поток - где первое значение это сама строка, а второе - длина строки
		// 		.forEach(System.out::println);

		// List <Integer> list = Arrays.asList(1,2);
		// System.out.println(list.stream().reduce(0, (a, b)->a+b));

		// eсли List <Integer> list = Arrays.asList();
		// тогда System.out.println(list.stream().reduce((a, b)->a+b));
		// венрнет Optional.empty потому что явным образом неизвестен результат

		// List <Integer> list = Arrays.asList();
		// Optional <Integer> r = list.stream().reduce((a,b)-> a + b);
		// System.out.println(r.orElse(0));
		// System.out.println(r.orElseGet(()->2));
		// System.out.println(r.orElseThrow(()-> new RuntimeException("Cannot get result;")));

		//Map <Integer , List<Person>> result  = persons.stream().filter(person -> person.getAge() > 20).collect(Collectors.groupingBy(Person::getAge));
		// ключ - возраст
		// значение - список List<People> всех людей этого возраста

		// сжимающий коллектор, может, например, считать количество Collectors.counting()

		// Примитивные Data stream
		// IntStream - поток для обработки примитивов типа int. DoubleStream. LongStream
		// IntStream.of(2,3,3,4).max();
		// .boxed() превращает в стрим объектов Integer
		// .mapToInt() - превращает стрим в обычный IntStream

		// Stream parallel() - возвращает Stream обрабатывающий данные многопоточно !Сильное ускорение
		// Stream unordered() - возвращает неупорядоченный поток

		// Поток - объект предназначенный для обработки данных
		// Обработка - операция map / filter / reduce
		// обработка оптимизирована: сначала мы определяем все операции, запускаем на исполение
		// поток НЕ МОЖЕТ быть использован повторно

	}
}