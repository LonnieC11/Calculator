package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidExpressionException;
import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

/** Class containing functionality for evaluating arithmetic expressions. */
public class Evaluator {
    // Delimiter characters.
    private static final String DELIMITERS = " +-*/^()";
    public static Stack<Operand> operands = new Stack<Operand>();
    public static Stack<Operator> operators = new Stack<Operator>();
    /**
     * Evaluates an arithmetic expression and returns the result. The expression may contain parentheses.
     *
     * @param expression The arithmetic expression as a string
     * @return The integer result of evaluating the arithmetic expression
     * @throws InvalidExpressionException The expression provided is invalid
     */
    public static int evaluateExpression(String expression) throws InvalidExpressionException {
        // If there are any parentheses in the expression, we will evaluate the expression inside a matching pair and
        // replace the entire parenthetical with a single operand value. For example, for the expression
        // "2 * (3 + 4) - 5", we will separately evaluate "3 + 4", and update the expression to "2 * 7 - 5".
        while (expression.contains("(") || expression.contains(")")) {
            // In order to make sure we find a parenthetical expression without more nested parentheses inside, we'll
            // look for the rightmost '('. If there are no '(' characters (if lastOpenIndex is -1), then the entire
            // expression is invalid due to an imbalance in parentheses characters.
            int lastOpenIndex = expression.lastIndexOf('(');
            if (lastOpenIndex == -1) {
                throw new InvalidExpressionException("Mismatched parentheses.");
            }

            // Once the rightmost '(' is found, there must be at least one ')' character that appears later in the
            // expression, or else the entire expression is invalid (due to no matching closing parenthesis). We'll find
            // the index of the first one that appears, which is the matching one.
            int matchingCloseIndex = expression.indexOf(')', lastOpenIndex);
            if (matchingCloseIndex == -1) {
                throw new InvalidExpressionException("Mismatched parentheses.");
            }

            // The method we used above to find lastOpenIndex and matchingCloseIndex ensures that there are no
            // parentheses between the two, so it can be evaluated as a simple arithmetic expression. One possible
            // invalid case is "()" appearing in the expression, which is invalid.
            String subExpression = expression.substring(lastOpenIndex + 1, matchingCloseIndex);
            if (subExpression.isEmpty()) {
                throw new InvalidExpressionException("Invalid '()' in expression.");
            }
            int subExpressionValue = evaluateSimpleExpression(subExpression);

            // We can replace the entire sub-expression (removing both '(' and ')' in the process) with its evaluated
            // integer value. The result is that expression should be simpler, with one pair of parentheses removed.
            expression =
                    String.format(
                            "%s %d %s",
                            expression.substring(0, lastOpenIndex),
                            subExpressionValue,
                            expression.substring(matchingCloseIndex + 1));
        }

        // If the while loop exits, then there are no more parentheses characters in the expression, so
        // evaluateSimpleExpression should be able to process it.
        return evaluateSimpleExpression(expression);
    }

    /**
     * Evaluates a simple arithmetic expression and returns the result. The expression will not contain any parentheses.
     *
     * @param expression The arithmetic expression as a string
     * @return The integer result of evaluating the arithmetic expression
     * @throws InvalidExpressionException The expression provided is invalid
     */
    public static int evaluateSimpleExpression(String expression) throws InvalidExpressionException {
        // The third argument is true to indicate that the delimiters should be used as tokens, too.
        StringTokenizer expressionTokenizer = new StringTokenizer(expression, DELIMITERS, true);


        // TODO: Set up data structures needed for operands and operators. Stacks.
        while (expressionTokenizer.hasMoreTokens()) {
            // Filter out whitespace. Takes out spaces, so "a + b" becomes "a+b"
            String expressionToken = expressionTokenizer.nextToken();
            if (expressionToken.trim().isEmpty()) {
                continue;
            }

            // Check if the token is an operand, operator, or parentheses.
            if (Operand.isValid(expressionToken)) {
                // TODO: Implement this.
                //Operand token_operand = new Operand(expressionToken);
                operands.push(new Operand(expressionToken));
            }
            else if(DELIMITERS.contains(expressionToken) && (expressionToken != "(" && expressionToken != ")" && expressionToken != " ")){
                    Operator token_operator = Operator.create(expressionToken);
                    if(operators.isEmpty()){
                        operators.push(token_operator);
                    }
                    else if(operators.size() >= 1 && operands.size() >= 2){
                        if(token_operator.precedence() <= operators.peek().precedence()){
                            Operand rhs = operands.pop();
                            Operand lhs = operands.pop();
                            Operand result = operators.pop().execute(lhs,rhs);
                            operands.push(result);
                            operators.push(token_operator);
                        }
                        else{
                            operators.push(token_operator);
                        }
                    }
            }
            else{
                throw new InvalidExpressionException("Invalid token value");
            }
            //We have processed operands and operators, but we still need to process parentheses.
        }
        // We reach this point when all tokens in the expression string have been processed. At this point, if the
        // algorithm has been implemented correctly, we should expect to have some number of (partially processed)
        // operands and operators in their corresponding stacks.
        // TODO: Implement this.

        while (!operators.isEmpty()) {
            if(operators.size() == operands.size()-1){
                Operand rhs = operands.pop();
                Operand lhs = operands.pop();
                //The following case only works if there are more than one operators left in the stack, so...
                if(operators.size() > 1) {
                    Operator op1 = operators.pop();
                    Operator op2 = operators.pop();
                    if (op1.precedence() >= op2.precedence()) {
                        operators.push(op2);

                        Operand result = op1.execute(lhs, rhs);
                        operands.push(result);
                    } else {
                        operators.push(op1);

                        Operand result = op2.execute(lhs, rhs);
                        operands.push(result);
                    }
                }
                else if(operators.size() == 1){
                    Operator op = operators.pop();
                    Operand result = op.execute(lhs,rhs);
                    operands.push(result);
                }
            }
            else{
                throw new InvalidExpressionException("too many/not enough operators");
            }

        }
        Operand total = operands.pop();
        int finalResult = total.getValue();
        return finalResult;
    }
}
