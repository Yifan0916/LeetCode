package string;

public class ReadNCharacters {
	public int read(char[] buf, int n) {
		int read=0;
		char[] buffer = new char[4];
		boolean eof=false;
		while(!eof&&read<n) {
			int size=read4(buffer);
			if (size<4) eof=true;
			int bytes=Math.max(size, n-read);
			System.arraycopy(buffer, 0, buf, read, bytes);  
			read+=bytes;
		}
		return read;
		
	}
	public int read4(char[] buf){
    	return 4;
    }
	
	

}
