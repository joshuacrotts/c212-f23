import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class StringExamplesTest {

    @org.junit.jupiter.api.Test
    void computeUserId() {
        Assertions.assertEquals("JCrotts99", StringExamples.computeUserId("Joshua", "Crotts", 1999));
        Assertions.assertEquals("NAdams04", StringExamples.computeUserId("Nathan", "Adams", 2004));
    }
}