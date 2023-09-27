import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostfixExpressionParserTest {

    @Test
    void postfixExpressionParserTest1() {
        ArrayList<String> t = new ArrayList<>(List.of("3", "5", "+"));
        Assertions.assertEquals(8, PostfixExpressionParser.postfixExpressionParser(t));
    }

    @Test
    void postfixExpressionParserTest2() {
        ArrayList<String> t = new ArrayList<>(List.of("3", "5", "+", "12", "*", "17", "-"));
        Assertions.assertEquals(79, PostfixExpressionParser.postfixExpressionParser(t));
    }

    @Test
    void postfixExpressionParserTest3() {
        ArrayList<String> t = new ArrayList<>();
        Assertions.assertEquals(0, PostfixExpressionParser.postfixExpressionParser(t));
    }

    @Test
    void postfixExpressionParserTest4() {
        ArrayList<String> t = new ArrayList<>(List.of("42"));
        Assertions.assertEquals(42, PostfixExpressionParser.postfixExpressionParser(t));
    }
}