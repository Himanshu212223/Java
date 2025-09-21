# Difference between Byte Stream and Character Stream



|   Byte    | Character Stream  |
|-----------|-------------------|
works with raw bytes (8-bit). | works with characters (16-bit Unicode).|
|Best for binary files (images, audio, video, PDFs). | Best for text files (documents, JSON, XML, CSV). |
| InputStream (for reading bytes) | OutputStream (for writing bytes) | Reader (for reading characters) Writer (for writing characters) | 
| FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream | FileReader, FileWriter, BufferedReader, BufferedWriter |
| Faster for binary because it directly copies raw bytes. | Handles encoding/decoding (UTF-8, UTF-16), slightly slower but correct for text. |




| Feature	| Byte Stream (InputStream / OutputStream)	| Character Stream (Reader / Writer) |
|-------------------------------|----------------------------|------------------|
| Data type	| 8-bit bytes	| 16-bit Unicode characters | 
| Best for	| Binary data (image, audio, video, PDF)	|Text data (txt, XML, JSON, CSV) |
| Base classes	| InputStream, OutputStream	| Reader, Writer |
| Example subclasses	| FileInputStream, FileOutputStream	| FileReader, FileWriter |
| Encoding awareness	| No (raw bytes only)	| Yes (handles Unicode, character sets) | 