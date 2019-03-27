class Encode{
	public static void main(String args[])
	{
		String msg = "This is a test";
		String encmsg = "";
		String decmsg = "";
		int key = 88;

		System.out.println("Original message: " + msg);
		for (int i = 0; i < msg.length(); i++)
		{
			encmsg = encmsg + (char)(msg.charAt(i) ^ key);
		}
		System.out.println("Encoded message: " + encmsg);

		for (int i = 0; i < msg.length(); i++)
		{
			decmsg = decmsg + (char)(encmsg.charAt(i) ^ key);
		}

		System.out.println("Decoded message: " + decmsg);
	}
}