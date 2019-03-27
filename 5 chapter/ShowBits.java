class ShowBits{
	public static void main(String args[])
	{
		byte b = 115;
		int i;

		for (i = 128; i > 0; i /= 2)
		{
			if ((b & i) != 0)
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		System.out.println();
	}
}