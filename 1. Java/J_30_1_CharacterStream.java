/*
	Character Stream
	____________________________________________________
	
	Character Stream - 
	----------------------------------------

	- A Character Stream in Java is used to perform input and 
		output of 16-bit Unicode characters.
	- Works with textual data (letters, digits, symbols, etc.).
	- Unlike Byte Streams (which deal with raw bytes), Character Streams 
		automatically handle encoding/decoding between characters and bytes.
	- Suitable for:
		Text files (.txt)
		CSV, XML, JSON, HTML, etc.
		
		
	- Package - java.io
	- Input (reading data):
		- Reader (abstract base class)
		- Common subclasses:
			1. FileReader → read data from files
			2. BufferedReader → read efficiently (line by line)

	- Output (writing data):
		- Writer (abstract base class)
		- Common subclasses:
			1. FileWriter → write characters to file
			2. BufferedWriter → write efficiently
	
	- Basic Methods:
			1. int read() → reads one character, returns -1 at end of file.
			2. int read(char[] c) → reads multiple characters into array.
			3. void write(int c) → writes a single character.
			4. void write(String s) → writes a string.
			5. close() → closes the stream.
			
	Reading a File with Byte Array (Faster)

*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class J_30_1_CharacterStream {
	
	
	
	public static void main(String [] args) {
		
		try {
			
			FileReader reader = new FileReader("C:\\Users\\himan\\Desktop\\jpy.jpg");	
			FileWriter writer = new FileWriter("C:\\Users\\himan\\Desktop\\jpy-copy.jpg");
			
			int value;
            while ((value = reader.read()) != -1) {  // read character by character
                writer.write(value);                 // write character by character
            }

            reader.close();
            writer.close();
            System.out.println("Text file copied using Character Streams!");
            
            
            //	Buffered operation (Efficient way)
            
            BufferedReader bfrReader = new BufferedReader( new FileReader("C:\\Users\\himan\\Desktop\\jpy.jpg") );
            BufferedWriter bfrWriter = new BufferedWriter( new FileWriter("C:\\Users\\himan\\Desktop\\jpy-buffered.jpg") ) ;
            
            String line  ;
            
            while((line = bfrReader.readLine()) != null ) {
            	bfrWriter.write(line);
            }
            
            bfrReader.close();
            bfrWriter.close();
            
            System.out.println("Text file copied using Buffer Character Streams!");
            
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
