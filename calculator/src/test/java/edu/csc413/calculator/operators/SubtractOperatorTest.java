package edu.csc413.calculator.operators;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtractOperatorTest {
    Operand lhs;
    Operand rhs;
    @Test
    void test_subtractOps(){
        lhs = new Operand(7);
        rhs = new Operand(4);
        SubtractOperator subOp= new SubtractOperator();
        Operand result = subOp.execute(lhs, rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(3));
    }
    @Test
    void test_subtractOps_TwoNegs(){
        lhs = new Operand(-8);
        rhs = new Operand(-9);
        SubtractOperator subOp= new SubtractOperator();
        Operand result = subOp.execute(lhs, rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(1));
    }
    @Test
    void test_subtractOps_NegLHS(){
        lhs = new Operand(-8);
        rhs = new Operand(9);
        SubtractOperator subOp= new SubtractOperator();
        Operand result = subOp.execute(lhs, rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(-17));
    }
    @Test
    void test_SubtractOps_NegativeRHS(){
        lhs = new Operand(7);
        rhs = new Operand(-3);
        SubtractOperator subOp = new SubtractOperator();
        Operand result = subOp.execute(lhs,rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(), equalTo(10));
    }
}