import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CalculatorTest {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod (Method method){
        switch (method.getName()) {
            case "calculateSum":
                return new Object[][] {{1.0, 0.0, 1.0},
                                       {5.1, 3.6, 8.7},
                                       {-6.5, -11.2, -17.7},
                                       {35.0, -23.0, 12.0},
                                       {-6.3, 11.0, 4.7},
                                       {Double.POSITIVE_INFINITY, 0.0, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, 0.0, Double.NEGATIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, -1.0, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, 1.0, Double.NEGATIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN}};
            case "calculateDifference":
                return new Object[][] {{-142.0, 0.0, -142.0},
                                       {52.1, 39.6, 12.5},
                                       {-6.0, -12.0, 6.0},
                                       {35.1, -243.5, 278.6},
                                       {-9.3, 131.0, -140.3},
                                       {0.0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY},
                                       {0.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, 1.0, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, -1.0, Double.NEGATIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN},
                                       {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN},
                                       {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY}};
            case "calculateProduct":
                return new Object[][] {{175.0, 0.0, 0.0},
                                       {5.1, 3.6, 18.36},
                                       {-6.5, -11.2, 72.8},
                                       {35.0, -23.0, -805.0},
                                       {-6.3, 11.0, -69.3},
                                       {Double.POSITIVE_INFINITY, 0.0, Double.NaN},
                                       {Double.NEGATIVE_INFINITY, 0.0, Double.NaN},
                                       {Double.POSITIVE_INFINITY, -1.0, Double.NEGATIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, -1.0, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}};
            case "calculateQuotient":
                return new Object[][] {{15.0, 0.0, Double.POSITIVE_INFINITY},
                                       {-142.0, 0.0, Double.NEGATIVE_INFINITY},
                                       {0.0, 0.0, Double.NaN},
                                       {14.0, 24.7, 0.5668016194331984},
                                       {-6.5, -11.2, 0.5803571428571429},
                                       {35.0, -7.0, -5.0},
                                       {-6.3, 3.15, -2.0},
                                       {Double.POSITIVE_INFINITY, 0.0, Double.POSITIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, 0.0, Double.NEGATIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, -1.0, Double.NEGATIVE_INFINITY},
                                       {Double.NEGATIVE_INFINITY, -1.0, Double.POSITIVE_INFINITY},
                                       {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN},
                                       {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN},
                                       {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN}};
            default:
                return null;
        }
    }

    @Test (dataProvider = "data-provider")
    public void calculateSum(Double leftTerm, Double rightTerm, Double resultSum) {
        Assert.assertEquals(resultSum, new Calculator().calculateSum(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateDifference(Double leftTerm, Double rightTerm, Double resultDifference) {
        Assert.assertEquals(resultDifference, new Calculator().calculateDifference(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateProduct(Double leftTerm, Double rightTerm, Double resultProduct) {
        Assert.assertEquals(resultProduct, new Calculator().calculateProduct(leftTerm, rightTerm));
    }

    @Test (dataProvider = "data-provider")
    public void calculateQuotient(Double leftTerm, Double rightTerm, Double resultQuotient) {
        Assert.assertEquals(resultQuotient, new Calculator().calculateQuotient(leftTerm, rightTerm));
    }
}
