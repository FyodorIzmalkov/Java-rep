import java.io.*;
//bytes FileInputStream && FileOutputStream
class CopyAndChange{
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("Usage: CopyAndChange Filename1 Filename2");
			return;
		}

		byte b;
		FileInputStream fin = null;
		FileOutputStream fout = null;

		try{
			fin = new FileInputStream(args[0]);
			fout = new FileOutputStream(args[1]);

			do{
				b = (byte)fin.read();
				if (b != -1)
				{
					if (b == ' ')
						fout.write((int)'-');
					else
						fout.write(b);
				}
			}while( b!= -1);
			} catch (IOException exc){
				System.out.println("Error occured: " + exc);
			} finally{
				try{
				fin.close();
				fout.close();
				}
				catch (IOException exc){
					System.out.println("Error closing file" + exc);
				}
			}
		}
}