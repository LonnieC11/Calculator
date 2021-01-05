package edu.csc413.calculator.operators;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOperatorTest {
    @Test
    void getValue_fromOperation(){
        Operand lhs = new Operand(7);
        Operand rhs = new Operand(3);
        AddOperator addOp = new AddOperator();
        Operand result = addOp.execute(lhs,rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(), equalTo(10));
    }
    @Test
    void getValue_fromOperation_NegativeLHS(){
        Operand lhs = new Operand(-7);
        Operand rhs = new Operand(3);
        AddOperator addOp = new AddOperator();
        Operand result = addOp.execute(lhs,rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(), equalTo(-4));
    }
    @Test
    void getValue_fromOperation_NegativeRHS(){
        Operand lhs = new Operand(7);
        Operand rhs = new Operand(-3);
        AddOperator addOp = new AddOperator();
        Operand result = addOp.execute(lhs,rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(), equalTo(4));
    }
    @Test
    void getValue_fromOperation_NegativeLRHS(){
        Operand lhs = new Operand(-7);
        Operand rhs = new Operand(-3);
        AddOperator addOp = new AddOperator();
        Operand result = addOp.execute(lhs,rhs);
        System.out.println(result.getValue());
        assertThat(result.getValue(), equalTo(-10));
    }
}