import java.io.*;

class ShowFile2{
	public static void main(String args[]){
		int i;

		if (args.length != 1){
			System.out.println("Usage: ShowFile2 Filename");
			return;
		}
		//try with resources to open a file and automatically close it
		try (FileInputStream fin = new FileInputStream(args[0])){
			do{
				i = fin.read();
				if (i != -1)
					System.out.print((char) i);
			}	while (i != -1);
		} catch (IOException exc){
			System.out.println("I/O error: " + exc);
		}
	}
}