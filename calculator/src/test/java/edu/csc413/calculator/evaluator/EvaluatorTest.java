package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidExpressionException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {
    @Test
    public void test_evaluateSimpleExpression() throws InvalidExpressionException {
        String expression = "3 + 4 * 2 - 3";
        int testResult = Evaluator.evaluateSimpleExpression(expression);
        System.out.println(testResult);
        assertThat(testResult, equalTo(8));

    }
    @Test
    public void test_evaluateSimpleExpression2() throws InvalidExpressionException {
        String expression = "18 * 3 - 20";
        int testResult = Evaluator.evaluateSimpleExpression(expression);
        System.out.println(testResult);
        assertThat(testResult, equalTo(34));

    }
    @Test
    public void test_evaluateSimpleExpression3() throws InvalidExpressionException {
        String expression = "24 / 4 * 3 + 89";
        int testResult = Evaluator.evaluateSimpleExpression(expression);
        System.out.println(testResult);
        assertThat(testResult, equalTo(107));

    }
    @Test
    public void test_evaluateSimpleExpression4() throws InvalidExpressionException {
        String expression = "3 + 8 * 4 - 19";
        int testResult = Evaluator.evaluateSimpleExpression(expression);
        System.out.println(testResult);
        assertThat(testResult, equalTo(16));

    }
    @Test
    public void test_evaluateSimpleExpressionError(){
        assertThrows(NullPointerException.class, () -> {
            String expression = "3+8(7-4)";
            int testResult = Evaluator.evaluateSimpleExpression(expression);
            System.out.println(testResult);
        });
    }
    @Test
    public void test_evaluateSimpleExpressionError2(){
        assertThrows(InvalidExpressionException.class, () -> {
            String expression = "3 + 8 * * 7 - 4";
            int testResult = Evaluator.evaluateSimpleExpression(expression);
            System.out.println(testResult);
        });
    }
    @Test
    public void test_evaluateExpression() throws InvalidExpressionException{
            String expression = "3 + (10 * 9) - 64";
            int testResult = Evaluator.evaluateExpression(expression);
            System.out.println(testResult);
        assertThat(testResult, equalTo(29));

    }
    @Test
    public void test_evaluateExpression2() throws InvalidExpressionException{
        String expression = "3 + (10 / 9) * 7";
        int testResult = Evaluator.evaluateExpression(expression);
        System.out.println(testResult);
        assertThat(testResult, equalTo(10));
    }
    @Test
    public void test_evaluateExpressionException(){
        assertThrows(InvalidExpressionException.class, () -> {
            String expression = "3 + (8 * 7)) - 4";
            int testResult = Evaluator.evaluateExpression(expression);
            System.out.println(testResult);
        });
    }
    @Test
    public void test_evaluateExpressionException2(){
        assertThrows(InvalidExpressionException.class, () -> {
            String expression = "3 + (8 * 7 - 4";
            int testResult = Evaluator.evaluateExpression(expression);
            System.out.println(testResult);
        });
    }
}