public class StringExamples {

    /**
     * Computes a user ID based on the given person's name and birth year.
     * @param first - first name
     * @param last - last name
     * @param birthYear - year of person's birth
     * @return String containing first letter of first name, first six letters of
     *         lastname, and last two digits of birth year.
     */
    public static String computeUserId(String first, String last, int birthYear) {
        char fChar = first.charAt(0);
        String lName = last.length() > 6 ? last.substring(0, 6) : last;
        String sBirthyear = String.format("%d", birthYear).substring(2);
        return String.format("%c%s%s", fChar, lName, sBirthyear);
    }

    public static void main(String[] args) {
        String s1 = "Hello, world!";
        String s2 = 5 + " this is a string " + 100 + " this is another string" + 2.581623873;
        System.out.println(s1.isEmpty());
        String num = "512313";
        int res = (int) (Double.parseDouble(num) + 5);
        double x = 5;
        String numPlusFive = num + 5;
        System.out.println(Integer.parseInt(num) + 5);
        System.out.println(num + 5);
        System.out.println(res);
        System.out.println(numPlusFive);

        //  H  e  l  l  o  ,  _  w  o  r  l  d  !
        //  0  1  2  3  4  5  6  7  8  9  10 11 12
    }
}
