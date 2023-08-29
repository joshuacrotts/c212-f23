public class Conditionals {

    public static String computeGrade(int grade) {
        String letterGrade = "";
        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else if (grade >= 0) {
            letterGrade = "F";
        }

        return letterGrade;
    }

    public static int w = 0;

    public static boolean setW() {
        w++;
        // w = w + 1
        // w += 1
        return false;
    }

    public static boolean isStrictlyIncreasing(int x, int y, int z) {
        return x < y && y < z;
    }

    /**
     * Returns the number of days in the given month.
     *
     * @param s String - month of year (e.g., "January" "February")
     * @return the number of days in the month.
     */
    public static int monthToDays(String s, int year) {
        // The February case.
        if (s.equals("February")) {
            return 28;
        }
        // If the month has 30 days...
        else if (s.equals("April") || s.equals("June") || s.equals("September") || s.equals("November")) {
            return 30;
        } else {
            return 31;
        }
    }

    public static void main(String[] args) {
    }
}
