import java.io.*;

class BufferedReaderWriterExamples {

    public static void main(String[] args) {
        // FileIOStream and FileReader/Writer are low-level operations that interact
        // directly with the operating system reader/writer functions. Invoking them
        // multiple times over and over, char-by-char, or byte-by-byte, is incredibly
        // inefficient. The BufferedReader/Writer classes create buffers, then flush
        // the data to/from the source at once.

        // To read from a stream, use BufferedReader. It receives a Reader object of some kind.
        // Reading from a file, we can wrap a FileReader inside.
        // BufferedReader provides
        // - readLine
        // - lines(): returns a stream of lines
        try (BufferedReader br = new BufferedReader(new FileReader("file1.in"))) {
            String line = "";
            while ((line = br.readLine()) != null) { System.out.println(line); }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // We can use BufferedReader to read from any input stream type, including standard input.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "";
            // Typing CTRL/CMD+D will send an EOF signal, resulting in readLine() returning null.
            while ((line = br.readLine()) != null && !line.equals("Q")) { System.out.printf("Line: %s\n", line); }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // To write to a stream, use BufferedWriter and FileWriter.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("file3.out"))) {
            bw.write("This is a line\n");
            bw.write("This is another line\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Should we want better methods for writing non-text data, we can instantiate
        // a PrintWriter instance. PrintWriter's constructor instantiates a BufferedWriter
        // within, meaning we don't need to instantiate one ourselves.
        try (PrintWriter pw = new PrintWriter(new FileWriter("file4.out"))) {
            pw.println(Math.PI);
            pw.println(false);
            pw.printf("This is a %s string with %c and %d and %f and %b\n", "formatted", '&', 42, Math.E, true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
