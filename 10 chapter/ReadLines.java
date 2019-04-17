import java.io.*;

class ReadLines{
	public static void main(String args[]) throws IOException{
		// create a bufferreader using system.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;

		System.out.println("Enter text; 'stop' to quit");

		do{
			str = br.readLine();
			System.out.println(str);
		}	while(!str.equals("stop"));
	}
}