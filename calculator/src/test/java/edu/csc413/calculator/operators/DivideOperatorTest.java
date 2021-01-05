package edu.csc413.calculator.operators;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideOperatorTest {
    Operand op1;
    Operand op2;
    @Test
    void test_DivideOps_PositivesWhole(){
        Operand op1 = new Operand(20);
        Operand op2 = new Operand (4);
        DivideOperator divOp = new DivideOperator();
        Operand result = divOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(5));
    }
    @Test
    void test_DivideOps_PositivesFractions(){
        Operand op1 = new Operand(18);
        Operand op2 = new Operand (400);
        DivideOperator divOp = new DivideOperator();
        Operand result = divOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(0));
    }
    @Test
    void test_DivideOps_LHSNegative(){
        Operand op1 = new Operand(-20);
        Operand op2 = new Operand (4);
        DivideOperator divOp = new DivideOperator();
        Operand result = divOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(-5));
    }
    @Test
    void test_DivideOps_RHSNegative(){
        Operand op1 = new Operand(20);
        Operand op2 = new Operand (-4);
        DivideOperator divOp = new DivideOperator();
        Operand result = divOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(-5));
    }
    @Test
    void test_DivideOps_TwoNegatives(){
        Operand op1 = new Operand(-20);
        Operand op2 = new Operand (-4);
        DivideOperator divOp = new DivideOperator();
        Operand result = divOp.execute(op1,op2);
        System.out.println(result.getValue());
        assertThat(result.getValue(),equalTo(5));
    }
    @Test
    void test_divideOps_DividingByZero() {
        /*It is impossible to divide by zero. Because running tests like the ones above will cause this case to return null,
        we should handle the NullPointerException that would've been thrown had we just used a assertThat(value1, equalTo(null)) method.*/

        assertThrows(NullPointerException.class, ()-> {
                    Operand op1 = new Operand(-20);
                    Operand op2 = new Operand (0);
                    DivideOperator divOp = new DivideOperator();
                    Operand result = divOp.execute(op1,op2);
                    result.getValue();
                }
                );
    }
}