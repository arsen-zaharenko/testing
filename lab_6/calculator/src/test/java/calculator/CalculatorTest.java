package calculator;

import option.DivisionOption;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CalculatorTest {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod (Method method){
        switch (method.getName()) {
            case "calculateSum":
                return new Object[][] {{1, 0, 1},
                                       {-14, 0, -14},
                                       {5, 3, 8},
                                       {-6, -11, -17},
                                       {35, -23, 12},
                                       {-6, 11, 5}};
            case "calculateDifference":
                return new Object[][] {{0, -10, 10},
                                       {42, 0, 42},
                                       {-12, 0, -12},
                                       {52, 39, 13},
                                       {-6, -12, 6},
                                       {35, -243, 278},
                                       {-9, 131, -140}};
            case "calculateProduct":
                return new Object[][] {{75, 0, 0},
                                       {5, 6, 30},
                                       {-6, -12, 72},
                                       {35, -23, -805},
                                       {-6, 11, -66}};
            case "calculateQuotientWithInfinityOption":
                return new Object[][] {{0, 42, 0.0},
                                       {0, -24, -0.0},
                                       {22, 7, 3.142857142857143},
                                       {-6, -11, 0.5454545454545454},
                                       {35, -7, -5.0},
                                       {-6, 3, -2.0}};
            case "calculateQuotientWithOutInfinityOption":
                return new Object[][] {{0, 42, 0.0, DivisionOption.WITHOUT_INFINITY},
                                       {0, -24, -0.0, DivisionOption.WITHOUT_INFINITY},
                                       {22, 7, 3.142857142857143, DivisionOption.WITHOUT_INFINITY},
                                       {-6, -11, 0.5454545454545454, DivisionOption.WITHOUT_INFINITY},
                                       {35, -7, -5.0, DivisionOption.WITHOUT_INFINITY},
                                       {-6, 3, -2.0, DivisionOption.WITHOUT_INFINITY}};
            case "divideByZeroWithInfinityOption":
                return new Object[][] {{15, 0, Double.POSITIVE_INFINITY},
                                       {-142, 0, Double.NEGATIVE_INFINITY},
                                       {0, 0, Double.NaN}};
            case "divideByZeroWithOutInfinityOption":
                return new Object[][] {{56, 0, DivisionOption.WITHOUT_INFINITY},
                                       {-1332, 0, DivisionOption.WITHOUT_INFINITY},
                                       {0, 0, DivisionOption.WITHOUT_INFINITY}};
            default:
                return null;
        }
    }

    @Test (dataProvider = "data-provider")
    public void calculateSum(Integer leftTerm, Integer rightTerm, Integer resultSum) {
        Assert.assertEquals(resultSum, new Calculator().calculateSum(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateDifference(Integer leftTerm, Integer rightTerm, Integer resultDifference) {
        Assert.assertEquals(resultDifference, new Calculator().calculateDifference(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateProduct(Integer leftTerm, Integer rightTerm, Integer resultProduct) {
        Assert.assertEquals(resultProduct, new Calculator().calculateProduct(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateQuotientWithInfinityOption(Integer leftTerm, Integer rightTerm, Double resultQuotient) {
        Assert.assertEquals(resultQuotient, new Calculator().calculateQuotient(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateQuotientWithOutInfinityOption(Integer leftTerm, Integer rightTerm, Double resultQuotient, DivisionOption divisionOption) {
        Assert.assertEquals(resultQuotient, new Calculator().calculateQuotient(leftTerm, rightTerm, divisionOption));
    }

    @Test (dataProvider = "data-provider")
    public void divideByZeroWithInfinityOption(Integer nonZeroTerm, Integer zeroTerm , Double resultQuotient) {
        Assert.assertEquals(resultQuotient, new Calculator().calculateQuotient(nonZeroTerm, zeroTerm));
    }

    @Test (dataProvider = "data-provider", expectedExceptions = {ArithmeticException.class}, expectedExceptionsMessageRegExp = "Division by zero.")
    public void divideByZeroWithOutInfinityOption(Integer nonZeroTerm, Integer zeroTerm , DivisionOption divisionOption) {
        new Calculator().calculateQuotient(nonZeroTerm, zeroTerm, divisionOption);
    }
}
