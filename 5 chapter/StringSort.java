class StringSort{
	public static void main(String args[]){
		String arr[] = new String[10];
		arr[0] = new String("Hello World!");
		arr[1] = "QQQ I am here!";
		arr[2] = "WWW IT IS WWW";
		arr[3] = "ZZZ IT IS ZZZ!";
		arr[4] = "AAA Some A's!";
		arr[5] = "Maybe smth more?";
		arr[6] = "I need more arrays!";
		arr[7] = "Almost finished!";
		arr[8] = "I am almost almost here!";
		arr[9] = "Lets sort it!";

		System.out.println("Array before sorting: \n");
		for (int i = 0; i < 10; i++)
			System.out.println(arr[i]);

		String tmp;
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if (arr[i].compareTo(arr[j]) < 0)
				{
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		System.out.println("Array after sorting: \n");
		for (int i = 0; i < 10; i++)
			System.out.println(arr[i]);

		tmp = new String("I like Java");
		System.out.println("\nStrlen of tmp is : " + tmp.length());
		System.out.println("Char at 7 pos: " + tmp.charAt(7));
	}
}