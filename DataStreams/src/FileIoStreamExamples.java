import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileIoStreamExamples {

    public static void main(String[] args) {
        String file = "file1.in";
        // To open/read a file as raw bytes, use FileInputStream.
        // We have to use a try/catch since it uses the checked IOException.
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            // Read in data byte-by-byte.
            int val = -1;
            while ((val = fis.read()) != -1) { System.out.print(val); }

            // Don't forget to close the stream!
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("\n=====");

        // We can, and should, use try-with-resources:
        try (FileInputStream fis2 = new FileInputStream(file)) {
            int val = -1;
            while ((val = fis2.read()) != -1) {
                System.out.print(val);
            }
            // No need to close the stream if we use try-with-resources.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // We can also write bytes out to a file.
        try (FileOutputStream fos = new FileOutputStream("file1.out")) {
            String s = "Hello, world!";
            for (char c : s.toCharArray()) {
                fos.write(c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
