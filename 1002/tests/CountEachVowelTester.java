import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CountEachVowelTester {

    @Test
    void countEachVowelTest1() {
        String s = "hello how are you doing";
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('a', 1);
        m.put('e', 2);
        m.put('i', 1);
        m.put('o', 4);
        m.put('u', 1);
        Assertions.assertEquals(m, CountEachVowel.countEachVowel(s));
    }

    @Test
    void countEachVowelTest2() {
        String s = "hhhhhhhhhhhhhh";
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('a', 0);
        m.put('e', 0);
        m.put('i', 0);
        m.put('o', 0);
        m.put('u', 0);
        Assertions.assertEquals(m, CountEachVowel.countEachVowel(s));
    }

    @Test
    void countEachVowelTest3() {
        String s = "";
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('a', 0);
        m.put('e', 0);
        m.put('i', 0);
        m.put('o', 0);
        m.put('u', 0);
        Assertions.assertEquals(m, CountEachVowel.countEachVowel(s));
    }
}