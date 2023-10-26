import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        ArrayList<Suit> suits = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (Math.random() < 0.5) { suits.add(new Diamond()); }
            else { suits.add(new Hearts()); }
        }

        for (Suit s : suits) {
            if (s instanceof Diamond) {
                System.out.println(((Diamond) s).diamondCount());
            }
            System.out.println(s.suitToString());
        }
    }
}
