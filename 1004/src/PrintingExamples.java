import java.util.Scanner;

class PrintingExamples {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Read an integer.
        int x = in.nextInt();
        // Read a String.
        String l = in.nextLine();
        System.out.printf("%d,%s\n", x, l);
    }
}
