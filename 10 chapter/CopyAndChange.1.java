import java.io.*;
//chars FileReader && FileWriter
class CopyAndChange1{
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("Usage: CopyAndChange Filename1 Filename2");
			return;
		}

		int i;
		try(FileReader fin = new FileReader(args[0]); FileWriter fout = new FileWriter(args[1])){
			do{
				i = fin.read();
				if (i != -1)
				{
					if ((char)i == ' ')
						fout.write((int)'-');
					else
						fout.write(i);
				}
			}while( i != -1);
			} catch (IOException exc){
				System.out.println("Error occured: " + exc);
			}
		}
}