import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

class ObjectIoStreamExamples {

    public static void main(String[] args) {
        // If we want to output objects, they must be serializable!
        BigInteger integer = new BigInteger("1");
        for (int i = 1; i <= 100; i++) {
            integer = integer.multiply(new BigInteger(String.valueOf(i)));
        }

        // Write the big integer to a file.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file5.out"))) {
            oos.writeObject(integer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // What happens if we OPEN that file?
        // Doesn't make any sense...!

        // Read the big integer from a file.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file5.out"))) {
            BigInteger input = (BigInteger) ois.readObject();
            System.out.printf("The number we read: %s\n", input);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // Can we write our own serializable classes? Of course!
        Player p1 = new Player("Joshua", 42, 100, new double[]{100.0, Math.PI, Math.E, 729.31415});
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file6.out"))) {
            oos.writeObject(p1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file6.out"))) {
            Player p2 = (Player) ois.readObject();
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // Question: why not just use strings? That's HARD! Parsing is a pain in the NECK!
    }

    private static class Player implements Serializable {
        private int score;
        private int health;
        private String name;
        private double[] records;

        public Player(String name, int score, int health, double[] records) {
            this.name = name;
            this.score = score;
            this.health = health;
            this.records = records;
        }

        @Override
        public String toString() {
            return String.format("<%s, %d, %d, %s>", this.name, this.score, this.health, Arrays.toString(this.records));
        }
    }
}
