package calculator;

import option.DivisionOption;

public class Calculator {
    public Integer calculateSum(Integer leftTerm, Integer rightTerm) { 
        return leftTerm + rightTerm;
    }

    public Integer calculateDifference(Integer leftTerm, Integer rightTerm) {
        return leftTerm - rightTerm;
    }


    public Integer calculateProduct(Integer leftTerm, Integer rightTerm) {
        return leftTerm * rightTerm;
    }

    public Double calculateQuotient(Integer leftTerm, Integer rightTerm, DivisionOption divisionOption) throws ArithmeticException {
        if (divisionOption.equals(DivisionOption.WITHOUT_INFINITY)) {
            try {
                new Integer(leftTerm / rightTerm);
            } catch (ArithmeticException arithmeticException) {
                throw new ArithmeticException("Division by zero.");
            }
        }
        return (double) leftTerm / rightTerm;
    }

    public Double calculateQuotient(Integer leftTerm, Integer rightTerm) {
        return calculateQuotient(leftTerm, rightTerm, DivisionOption.WITH_INFINITY);
    }
}
