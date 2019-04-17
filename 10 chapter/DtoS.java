import java.io.*;

class DtoS{
	static public void main(String args[]){
		String s;

		//create and use a filereader wrapped in a bufferreader
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))){
			while ((s = br.readLine()) != null){
				System.out.println(s);
			}
		} catch (IOException exc){
			System.out.println("Error occured: " + exc);
		}
	}
}