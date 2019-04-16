import java.io.*;

class CopyFile2{
	public static void main(String args[]){
		int i;

		if (args.length != 2){
			System.out.println("Usage: copy file1 file2");
			return;
		}

		try(FileInputStream fin = new FileInputStream(args[0]); FileOutputStream fout = new FileOutputStream(args[1])){

			do{
				i = fin.read();
				if (i != -1)
					fout.write(i);
			}	while(i != -1);
		} catch(IOException exc){
			System.out.println("IO error occured: " + exc);
		}
	}
}