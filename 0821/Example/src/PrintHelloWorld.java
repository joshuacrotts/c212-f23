public class PrintHelloWorld {
    // All code should go inside the main method.
    // "public static" and "[] args" are irrelevant for now.
    public static void main(String[] args) {
        // Immutable variables (whose value cannot be changed later)
        // should use the "final" keyword and have a UPPER_CASE identifier.
        final String S = "Hello, world!";

        // Regular variables should use theCamelCaseNamingConvention.
        String mutableString = "Hi!";

        // This is a STATEMENT! What does this method "resolve to"? Nothing!
        // Same idea for assignment statements;
        // x = 5;
        // x = 10; <- what can this possibly resolve to? (C programmers, don't answer this)
        // 5 + 6, on the other hand, RESOLVES to 11! Therefore, it's an expression.
        System.out.println(S);
    }
}
