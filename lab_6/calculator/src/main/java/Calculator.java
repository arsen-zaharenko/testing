public class Calculator {
    public Double calculateSum(Double leftTerm, Double rightTerm) {
        return leftTerm + rightTerm;
    }

    public Double calculateDifference(Double leftTerm, Double rightTerm) {
        return leftTerm - rightTerm;
    }


    public Double calculateProduct(Double leftTerm, Double rightTerm) {
        return leftTerm * rightTerm;
    }

    public Double calculateQuotient(Double leftTerm, Double rightTerm) {
        try {
            return leftTerm / rightTerm;
        } catch (ArithmeticException arithmeticException) {
            if (leftTerm < 0) {
                return Double.NEGATIVE_INFINITY;
            } else if (leftTerm > 0) {
                return Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        }
    }
}
