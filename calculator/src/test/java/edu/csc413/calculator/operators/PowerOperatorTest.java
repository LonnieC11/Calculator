package edu.csc413.calculator.operators;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOperatorTest {
    Operand base;
    Operand power;
    @Test
    void test_PowOperations(){
        base = new Operand(3);
        power = new Operand(2);
        PowerOperator powOp = new PowerOperator();
        Operand result = powOp.execute(base, power);
        assertThat(result.getValue(), equalTo(9));
    }
    @Test
    void test_PowOperations_PowerOfZero(){
        base = new Operand(3000000);
        power = new Operand(0);
        PowerOperator powOp = new PowerOperator();
        Operand result = powOp.execute(base, power);
        assertThat(result.getValue(), equalTo(1));
    }
    @Test
    void test_PowOperations_NegativeBase(){
        base = new Operand(-10);
        power = new Operand(3);
        PowerOperator powOp = new PowerOperator();
        Operand result = powOp.execute(base, power);
        assertThat(result.getValue(), equalTo(-1000));
    }
    @Test
    void test_PowOperations_NegativePower(){
        //Remember, we're only working with ints, so any fractions will be rounded down to zero.
        //a^(-b) = 1/(a^b)
        base = new Operand(10);
        power = new Operand(-4);
        PowerOperator powOp = new PowerOperator();
        Operand result = powOp.execute(base, power);
        assertThat(result.getValue(), equalTo(0));
    }
    @Test
    void test_PowOperations_NegativeBP(){
        //Remember, we're only working with ints, so any fractions will be rounded down to zero.
        //-a^(-b) = 1/(-a^-b)
        base = new Operand(-10);
        power = new Operand(-4);
        PowerOperator powOp = new PowerOperator();
        Operand result = powOp.execute(base, power);
        assertThat(result.getValue(), equalTo(0));
    }
}