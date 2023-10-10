import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Main {

    static int pow(int a, int b) {
        if (a == 0) { return 0; }
        else if (b == 0) { return 1; }
        else { return a * pow(a, b - 1); }
    }

    static int powTR(int a, int b) {
        return powTRHelper(a, b, 1);
    }

    private static int powTRHelper(int a, int b, int acc) {
        if (a == 0) { return 0; }
        else if (b == 0) { return acc; }
        else { return powTRHelper(a, b - 1, a * acc); }
    }

    static int powLoop(int a, int b) {
        int acc = 1;
        if (a == 0) { return 0; }
        else {
            while (!(b == 0)) {
                b = b - 1;
                acc = acc * a;
            }
        }
        return acc;
    }

    static boolean unifiesAll(HashMap<String, Integer> U, ArrayList<LinkedList<String>> goals) {
        for (LinkedList<String> G : goals) {
            String v1 = G.get(0);
            String v2 = G.get(1);
            // If we unify a val with itself, it's satisfied.
            if (v1.equals(v2)) { continue; }
            // If v1 is a variable and v2 is not, check to see if v1 is in the map and if so, check its value.
            else if (isVar(v1) && !isVar(v2)) {
                if (U.containsKey(v1) && U.get(v1) == Integer.parseInt(v2)) { continue; }
                else if (!U.containsKey(v1)) { U.put(v1, Integer.parseInt(v2)); }
                else { return false; }
            }
            // Same case as above but flipped.
            else if (!isVar(v1) && isVar(v2)) {
                if (U.containsKey(v2) && U.get(v2) == Integer.parseInt(v1)) { continue; }
                else if (!U.containsKey(v2)) { U.put(v2, Integer.parseInt(v1)); }
                else { return false; }
            }
            // If U contains both vals and they map to the same result, we can unify them.
            else if (U.containsKey(v1) && U.containsKey(v2) && U.get(v1) == U.get(v2)) { continue; }
            // If U contains v1 but not v2, we can unify them.
            else if (U.containsKey(v1) && !U.containsKey(v2)) { U.put(v2, U.get(v1)); }
            // If U contains v2 but not v1, we can unify them.
            else if (!U.containsKey(v1) && U.containsKey(v2)) { U.put(v1, U.get(v2)); }
            // All other cases return false.
            else { return false; }
        }

        return true;
    }

    private static boolean isVar(String s) {
        return !s.isEmpty() && !Character.isDigit(s.charAt(0));
    }

    public static void main(String[] args) {
        HashMap<String, Integer> U4 = new HashMap<>();
        U4.put("x", 5); U4.put("y", 10); U4.put("z", 15); U4.put("w", 5);
        ArrayList<LinkedList<String>> G4
                = new ArrayList<>(List.of(new LinkedList<>(List.of("q", "x")),
                new LinkedList<>(List.of("q", "10"))));
        System.out.println(unifiesAll(U4, G4));
    }
}
