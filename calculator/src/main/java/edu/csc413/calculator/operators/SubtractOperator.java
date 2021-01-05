package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator{
    @Override
    public int precedence() {
        return 1;
    }

    @Override
    public Operand execute(Operand lhs, Operand rhs) {
        int op1 = lhs.getValue();
        int op2 = rhs.getValue();
        int result = op1 - op2;
        return new Operand(result);
    }
}
