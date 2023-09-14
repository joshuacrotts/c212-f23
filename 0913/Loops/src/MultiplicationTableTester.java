import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplicationTableTester {

    @Test
    void multiplicationTableTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("1*1=1,1*2=2,1*3=3,2*1=2,2*2=4,2*3=6,3*1=3,3*2=6,3*3=9", MultiplicationTable.multTable(3, 3)),
                () -> Assertions.assertEquals("1*1=1,1*2=2,1*3=3,1*4=4,1*5=5,1*6=6,2*1=2,2*2=4,2*3=6,2*4=8,2*5=10,2*6=12", MultiplicationTable.multTable(2, 6))
        );
    }
}
