/*
	Byte Stream and Character Stream
	____________________________________________________
	
	Byte Stream - 
	----------------------------------------

	- A Byte Stream in Java is used to perform input and output of 8-bit data 
		(1 byte)- (not text-specific).
	- It reads and writes raw binary data (not text-specific).
	- It works for files like .jpg, png, .mp3, .mp4, pdf, word etc.
	- It doesn't works for text because byte streams do not understand 
		characters/Unicode encoding, they just copy raw bytes.
		
		
	- Package - java.io
	- Input (reading data):
		- InputStream (abstract base class)
		- Common subclasses:
			1. FileInputStream → read data from files
			2. BufferedInputStream → read data faster with buffer
			3. DataInputStream → read primitive data types

	- Output (writing data):
		- OutputStream (abstract base class)
		- Common subclasses:
			1. FileOutputStream → write data to files
			2. BufferedOutputStream → write faster with buffer
			3. DataOutputStream → write primitive data types
	
	- Basic Methods:
			1. int read() → reads one byte (0–255), returns -1 if end of file.
			2. int read(byte[] b) → reads multiple bytes into an array.
			3. void write(int b) → writes one byte.
			4. void write(byte[] b) → writes a whole array of bytes.
			5. close() → closes the stream and releases resources.
			
	Reading a File with Byte Array (Faster)

*/



import java.io.FileInputStream;
import java.io.FileOutputStream;

public class J_30_0_ByteStream {
    
    public static void main(String [] args) {
		
		try {
			FileInputStream input = new FileInputStream("C:\\Users\\himan\\Desktop\\Hair Solution.pdf");
			FileOutputStream output = new FileOutputStream("C:\\Users\\himan\\Desktop\\jpy-copy.pdf");
			
			int byteData ;
			
			while((byteData = input.read()) != -1) {
				output.write(byteData);
			}
			
			input.close();
			output.close();
			System.out.println("Worked fine and created a copy of image.");
			
			
			
			//	Reading a File with Byte Array (Faster) - 
			
			FileInputStream inputBuf = new FileInputStream("C:\\Users\\himan\\Desktop\\Hair Solution.pdf");
			FileOutputStream outputBuf = new FileOutputStream("C:\\Users\\himan\\Desktop\\jpy-anotherCopy.pdf");
			
			byte[] buffer = new byte[1024];
			int bytesRead ;
			
			while ((bytesRead = inputBuf.read(buffer)) != -1) {
                outputBuf.write(buffer, 0, bytesRead); // write only the read bytes
            }

            inputBuf.close();
            outputBuf.close();
            System.out.println("PDF copied successfully using buffer!");
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
