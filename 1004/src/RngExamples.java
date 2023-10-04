import java.util.Random;
import java.util.stream.IntStream;

class RngExamples {

    public static void main(String[] args) {
        Random rng = new Random();
        Random rngSeed = new Random(212212);
        IntStream ris = rng.ints(0, 20);

        // Generate 10 random numbers from the stream.
        System.out.printf("%s\n", ris.limit(10).boxed().toList());

        // These three will ALWAYS be the same!
        System.out.printf("%d\n", rngSeed.nextInt(500));
        System.out.printf("%d\n", rngSeed.nextInt(500));
        System.out.printf("%d\n", rngSeed.nextInt(500));
    }
}
