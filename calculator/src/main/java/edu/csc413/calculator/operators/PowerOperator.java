package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    @Override
    public int precedence() {
        return 3;
    }

    @Override
    public Operand execute(Operand lhs, Operand rhs) {
        int base = lhs.getValue();
        int power = rhs.getValue();

        //Type Casting! Since Math.pow always returns a double, let's cast it to an int value since Operand only accepts ints and Strings of ints
        int result = (int)Math.pow(base,power);
        return new Operand(result);
    }
}
