import java.util.Scanner;

class HumanPlayer implements Player {

    private Scanner scn;

    public HumanPlayer() { this.scn = new Scanner(System.in); }

    @Override
    public boolean anotherCard() {
        String line = this.scn.nextLine();
        return line.contains("Y");
    }

    @Override
    public void addCard(int value) {
        System.out.println("You got a " + value + " card.");
    }

    @Override
    public void print() { }
}
