import java.util.HashMap;

class CountEachVowel {

    /**
     * Counts the number of vowels in the string.
     * @param s string.
     * @return a HashMap of the vowels to their respective counts.
     */
    static HashMap<Character, Integer> countEachVowel(String s) {
        HashMap<Character, Integer> cmap = new HashMap<>();
        cmap.put('a', 0);
        cmap.put('e', 0);
        cmap.put('i', 0);
        cmap.put('o', 0);
        cmap.put('u', 0);

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (cmap.containsKey(ch)) {
                cmap.put(ch, cmap.get(ch) + 1);
            }
        }
        return cmap;
    }















//    static HashMap<Character, Integer> countEachVowel(String s) {
//        HashMap<Character, Integer> cmap = new HashMap<>();
//        // Prepopulate with initial counts.
//        cmap.put('a', 0);
//        cmap.put('e', 0);
//        cmap.put('i', 0);
//        cmap.put('o', 0);
//        cmap.put('u', 0);
//
//        for (char ch : s.toCharArray()) {
//            ch = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : ch;
//            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//                cmap.put(ch, cmap.get(ch) + 1);
//            }
//        }
//        return cmap;
//    }
}
