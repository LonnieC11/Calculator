package edu.csc413.calculator.operators;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyOperatorTest {
    Operand op1;
    Operand op2;

    @Test
    void test_MultiplyOps(){
        op1 = new Operand(5);
        op2 = new Operand(2);
        MultiplyOperator multOp = new MultiplyOperator();
        Operand result = multOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(10));
    }
    @Test
    void test_MultiplyOps_NegativeLHS(){
        op1 = new Operand(-5);
        op2 = new Operand(2);
        MultiplyOperator multOp = new MultiplyOperator();
        Operand result = multOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(-10));
    }
    @Test
    void test_MultiplyOps_NegativeRHS(){
        op1 = new Operand(5);
        op2 = new Operand(-2);
        MultiplyOperator multOp = new MultiplyOperator();
        Operand result = multOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(-10));
    }
    @Test
    void test_MultiplyOps_DoubleNegatives(){
        op1 = new Operand(-5);
        op2 = new Operand(-2);
        MultiplyOperator multOp = new MultiplyOperator();
        Operand result = multOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(10));
    }
}