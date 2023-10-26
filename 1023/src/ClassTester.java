import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassTester {

    @Test
    void testOne() {
        final A a1 = new A("Hello!");
        B b = new B(a1);
        C c = new C(a1);

        // What do each of these output?
//        assert______(b.getA(), c.getA());
//        assert______(b.getA().getS(), c.getA().getS());
//        a.setS("Hi!");
//        assert______(b.getA().getS(), c.getA().getS());
//        b.getA().setS("Howdy!");
//        assert______(b.getA().getS(), c.getA().getS());

//        assert______(a1.equals(a2));
//        assert______(a1.getS().equals(a2.getS()));
//        assert______(a2.getS().equals(a3.getS()));

//        B b2 = new B(a1);
//        assert______(a1, b2.getA());
//        assert______(b, b2);
//        b = b2;
//        assert______(a1, b.getA());
//        assert______(b, b2);

        final A a2 = new A("Hello!");
        final A a3 = new A("Hi!");
        final A a4 = new A(new String("Hello!"));

//        assert______(a1, a2);
//        assert______(a1, a4);
//        assert______(a1.getS(), a2.getS());
//        assert______(a1.getS(), a3.getS());
//        assert______(a1.getS(), a2.getS());
    }

    @Test
    void testTwo() {
        D d = new D();
        E e = new E(42);
        E[] arrOfE = new E[10];
        for (int i = 0; i < arrOfE.length; i++) { arrOfE[i] = new E(i); }
//        assert______(arrOfE[2], arrOfE[5]);
//        assert______(arrOfE[2].getNumber(), arrOfE[5].getNumber());
//
//        for (int i = 0; i < arrOfE.length; i++) { arrOfE[i] = e; }
//        assert______(arrOfE[0], arrOfE[2]);
//        assert______(arrOfE[0].getNumber(), arrOfE[2].getNumber());
//        arrOfE[7].setNumber(102);
//        assert______(arrOfE[0].getNumber(), arrOfE[2].getNumber());
    }
}
