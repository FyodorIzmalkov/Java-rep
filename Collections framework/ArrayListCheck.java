import java.util.ArrayList;
import java.util.Arrays;

class ArrayListCheck{
	public static void main(String args[]){

		ArrayList<String> lst = new ArrayList<>();

		lst.add("Mercury");
		lst.add("Venus");
		lst.add("Earth");
		lst.add("Saturn");
		lst.add("Neptune");

		lst.addAll(Arrays.asList("PlanetX", "PlanetY", "PlanetZ"));

		lst.add(0, "Jupiter");
		lst.add(1, "Uranus");

		// получение True если значение есть в массиве, иначе False
		boolean isExist = lst.contains("Earth");

		// получение True если все значения есть в массиве, иначе False
		ArrayList<String> favorite = new ArrayList<>();
		favorite.add("Earth");
		favorite.add("Saturn");
		boolean isContains = lst.containsAll(favorite);

		// удаление элемента по значению
		lst.remove("Saturn");
		lst.remove("Neptune");

		// оставить в списке только указаные элементы
		ArrayList<String> favorite1 = new ArrayList<>();
		favorite.add("Earth");
		favorite.add("Saturn");
		lst.retainAll(favorite);

		// удаление элемента по индексу
		lst.remove(1);

		// удалить все элементы в списке
		ArrayList<String> favorite = new ArrayList<>();
		favorite.add("Earth");
		favorite.add("Saturn");
		planets.removeAll(favorite);
	}
}