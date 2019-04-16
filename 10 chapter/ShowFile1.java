import java.io.*;

class ShowFile1{
	public static void main(String args[]){
		int i;

		FileInputStream fin = null; 

		if (args.length != 1){
			System.out.println("Usage: ShowFile1 Filename");
			return;
		}
		try{
			fin = new FileInputStream(args[0]);

			do{
				i = fin.read();
				if (i != -1)
					System.out.print((char)i);
			}	while(i != -1);
		} catch (FileNotFoundException exc){
			System.out.println("File not found.");
		} catch (IOException exc){
			System.out.println("An IO error occurred");
		} finally{
			// close file in all cases
			try{
				if (fin != null)
					fin.close();
			} catch (IOException exc){
				System.out.println("Error closing file.");
			}
		}
	}
}