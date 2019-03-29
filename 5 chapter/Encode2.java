class Encode2{
	public static void main(String args[]){
		String msg = "This would be encoded, I hope.";
		String encmsg = "";
		String decmsg = "";
		String key = "qwertyui";

		System.out.println("Original message: " + msg);

		int j = 0;
		for (int i = 0; i < msg.length(); i++)
		{
			j = i > 8 ? i % 8 : i;
			encmsg = encmsg + (char)(msg.charAt(i) ^ (char)(msg.charAt(j)));
		}

		System.out.println("Encoded message: " + encmsg);

		j = 0;
		for (int i = 0; i < msg.length(); i++)
		{
			j = i > 8 ? i % 8 : i;
			decmsg = decmsg + (char)(encmsg.charAt(i) ^ (char)(msg.charAt(j)));
		}
		System.out.println("Decoded message: " + decmsg);
	}
}