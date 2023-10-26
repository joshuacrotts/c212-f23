import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class NumTest {

    @org.junit.jupiter.api.Test
    void value() {
        assertEquals(42, new Num(42).value());
        assertEquals(12, new Add(new Num(5),
                                         new Add(new Num(3),
                                                 new Num(4))).value());
        assertEquals(-12, new Neg(new Add(new Num(5),
                                                   new Add(new Num(3),
                                                           new Num(4)))).value());
    }
}