import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileReaderWriterExamples {

    public static void main(String[] args) {
        // FileIOStream reads data as raw bytes. We most certainly want characters...
        // FileReader extends Reader; NOT InputStream!
        // FileReader is for reading text; FileInputStream is for reading raw byte content
        // of a file. We can only read text files (e.g., files without encoding); not .docx, .pdf, blah blah...
        try (FileReader fr = new FileReader("file1.in")) {
            int c = -1;
            while ((c = fr.read()) != -1) { System.out.print((char) c); }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // FileWriter is the dual to FileReader.
        // Gives us more capable methods for outputting strings and chars.
        // Quiz: what does this output?
        try (FileWriter fw = new FileWriter("file2.out")) {
            fw.write("Here is a string");
            fw.write("\nHere is another string\n");
            fw.write(9);
            fw.write(71);
            fw.write(33);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
