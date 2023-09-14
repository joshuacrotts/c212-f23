import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x;
        do {
            System.out.println("Executed");
            x = in.nextInt();
        } while (x < 0);
        System.out.println(x);
    }
}
