import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void pow() {
        assertAll(
                () -> assertEquals((int) Math.pow(4, 2), Main.pow(4, 2)),
                () -> assertEquals((int) Math.pow(422, 3), Main.pow(422, 3)),
                () -> assertEquals((int) Math.pow(0, 1), Main.pow(0, 1)),
                () -> assertEquals((int) Math.pow(0, 43193812), Main.pow(0, 43913812))
        );
    }

    @Test
    void powTR() {
        assertAll(
                () -> assertEquals((int) Math.pow(4, 2), Main.powTR(4, 2)),
                () -> assertEquals((int) Math.pow(422, 3), Main.powTR(422, 3)),
                () -> assertEquals((int) Math.pow(0, 1), Main.powTR(0, 1)),
                () -> assertEquals((int) Math.pow(0, 43193812), Main.powTR(0, 43913812))
        );
    }

    @Test
    void powLoop() {
        assertAll(
                () -> assertEquals((int) Math.pow(4, 2), Main.powLoop(4, 2)),
                () -> assertEquals((int) Math.pow(422, 3), Main.powLoop(422, 3)),
                () -> assertEquals((int) Math.pow(0, 1), Main.powLoop(0, 1)),
                () -> assertEquals((int) Math.pow(0, 43193812), Main.powLoop(0, 43913812))
        );
    }

    @Test
    void unifiesAll() {
        // T1
        HashMap<String, Integer> U1 = new HashMap<>();
        U1.put("x", 5); U1.put("y", 10); U1.put("z", 15); U1.put("w", 5);
        ArrayList<LinkedList<String>> G1
                = new ArrayList<>(List.of(new LinkedList<>(List.of("x", "x")),
                                          new LinkedList<>(List.of("10", "10")),
                                          new LinkedList<>(List.of("z", "15")),
                                          new LinkedList<>(List.of("w", "5"))));
        assertTrue(Main.unifiesAll(U1, G1));

        // T2
        HashMap<String, Integer> U2 = new HashMap<>();
        U2.put("x", 5); U2.put("y", 10); U2.put("z", 15); U2.put("w", 5);
        ArrayList<LinkedList<String>> G2
                = new ArrayList<>(List.of(new LinkedList<>(List.of("x", "y"))));
        assertFalse(Main.unifiesAll(U2, G2));

        // T3
        HashMap<String, Integer> U3 = new HashMap<>();
        U3.put("x", 5); U3.put("y", 10); U3.put("z", 15); U3.put("w", 5);
        ArrayList<LinkedList<String>> G3
                = new ArrayList<>(List.of(new LinkedList<>(List.of("q", "x")),
                new LinkedList<>(List.of("w", "5")),
                new LinkedList<>(List.of("q", "5")),
                new LinkedList<>(List.of("q", "w"))));
        assertTrue(Main.unifiesAll(U3, G3));

        // T4
        HashMap<String, Integer> U4 = new HashMap<>();
        U4.put("x", 5); U4.put("y", 10); U4.put("z", 15); U4.put("w", 5);
        ArrayList<LinkedList<String>> G4
                = new ArrayList<>(List.of(new LinkedList<>(List.of("q", "x")),
                new LinkedList<>(List.of("q", "10"))));
        assertFalse(Main.unifiesAll(U4, G4));
    }
}