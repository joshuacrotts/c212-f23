import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class ScannerExamples {

    public static void main(String[] args) {
        // We can use Scanner to do many things. It accepts any InputStream or reader.
        // We've seen this idea with Stdin, but let's wrap other constructs in it.

        // Helpful methods:
        // - hasNext(), hasNextLine(), nextInt(), nextDouble, nextLine...
        // The "next..." methods consume data from the input stream.
        // If you're unsure about the data, read as lines and parse later. Use BufferedReader for that though...
        // If the structure of the data is predetermined, Scanners can be invaluable for extracting components.
        try (Scanner f = new Scanner(new File("file1.in"))) {
            while (f.hasNext()) {
                System.out.println(f.nextLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // If it tries to read in data of the wrong type, it will throw an
        // InputMismatchException
        // If no data exists,
        // NoSuchElementException
        // If the scanner is closed prematurely,
        // IllegalStateException


    }
}
