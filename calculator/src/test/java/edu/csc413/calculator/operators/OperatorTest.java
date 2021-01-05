package edu.csc413.calculator.operators;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void test_precedence() {
        Operator addOp = Operator.create("+");
        Operator powOp = Operator.create("^");
        int powPrecedence = powOp.precedence();
        int addPrecedence = addOp.precedence();
        assertThat(powPrecedence, equalTo(3));
        assertThat(addPrecedence, equalTo(1));
    }

    @Test
    void test_executeAddition() {
        Operator testOP = Operator.create("+");
        Operand lhs= new Operand(7);
        Operand rhs = new Operand(3);
        int result = testOP.execute(lhs,rhs).getValue();
        assertThat(result, equalTo(10));
    }
    @Test
    void test_executeSubtraction() {
        Operator testOP = Operator.create("-");
        Operand lhs= new Operand(7);
        Operand rhs = new Operand(3);
        int result = testOP.execute(lhs,rhs).getValue();
        assertThat(result, equalTo(4));
    }
    @Test
    void test_executeMultiplication() {
        Operator testOP = Operator.create("*");
        Operand lhs= new Operand(7);
        Operand rhs = new Operand(3);
        int result = testOP.execute(lhs,rhs).getValue();
        assertThat(result, equalTo(21));
    }
    @Test
    void test_executeMultiplicatDivision() {
        Operator testOP = Operator.create("/");
        Operand lhs= new Operand(7);
        Operand rhs = new Operand(3);
        int result = testOP.execute(lhs,rhs).getValue();
        assertThat(result, equalTo(2));
    }
    @Test
    void test_executePower() {
        Operator testOP = Operator.create("^");
        Operand lhs= new Operand(7);
        Operand rhs = new Operand(3);
        int result = testOP.execute(lhs,rhs).getValue();
        assertThat(result, equalTo(343));
    }
    @Test
    void test_executeException() {
        assertThrows(NullPointerException.class, ()-> {
            Operator testOP = Operator.create("q");
            Operand lhs= new Operand(7);
            Operand rhs = new Operand(3);
            int result = testOP.execute(lhs,rhs).getValue();
        });
    }
    @Test
    void test_createAdd() {
        Operator addOp = Operator.create("+");
        assertThat(addOp.getClass(),equalTo(AddOperator.class));
    }
    @Test
    void test_createSubtract() {
        Operator subOp = Operator.create("-");
        assertThat(subOp.getClass(),equalTo(SubtractOperator.class));
    }
    @Test
    void test_createMultiply() {
        Operator op = Operator.create("*");
        assertThat(op.getClass(),equalTo(MultiplyOperator.class));
    }
    @Test
    void test_createDivision() {
        Operator op = Operator.create("/");
        assertThat(op.getClass(),equalTo(DivideOperator.class));
    }
    @Test
    void test_createPower() {
        Operator op = Operator.create("^");
        assertThat(op.getClass(),equalTo(PowerOperator.class));
    }
    @Test
    void test_createException(){
        assertThrows(NullPointerException.class, ()-> {
            Operator op = Operator.create("b");
            System.out.println(op.getClass());
        });
    }
}