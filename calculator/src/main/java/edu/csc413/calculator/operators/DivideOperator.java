package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator {

    @Override
    public int precedence() {
        return 2;
    }

    @Override
    public Operand execute(Operand lhs, Operand rhs) {
        int op1 = lhs.getValue();
        int op2 = rhs.getValue();
        int result;
        //Special case: you can't divide by zero. op2 is the denominator; therefore, it can't have a value of zero. This is unique to division.

        if (op2 == 0){
            return null;
        }
        else{
            result = op1 / op2;
            return new Operand(result);
        }
    }
}
