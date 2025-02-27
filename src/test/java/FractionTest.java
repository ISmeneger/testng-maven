import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FractionTest {
    @Test(description = "Сложение двух положительных дробных чисел")
    @Tag("Smoke")
    void simpleFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(2, 3);
        Fraction expectedSum = new Fraction(7, 6);;
        Assert.assertEquals(expectedSum, Fraction.sum(first, second), "Суммы должны быть одинаковыми");
    }

    @Test(description = "Сложение отрицательных дробных чисел")
    @Tag("Smoke")
    void negativeFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(-2, 3);
        Fraction expectedSum = new Fraction(-1, 6);
        Assert.assertEquals(expectedSum, Fraction.sum(first, second), "Суммы должны быть одинаковыми");
    }

    @Test(description = "Нулевой числитель")
    @Tag("Negative")
    void zeroNumFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(-2, 4);
        Fraction expectedSum = new Fraction(0, 8);
        Assert.assertEquals(expectedSum, Fraction.sum(first, second), "Суммы должны быть одинаковыми");
    }

    @Test(expectedExceptions = ArithmeticException.class,
            description = "Нулевой знаменатель")
    @Tag("Negative")
    public void zeroDenFraction() {
        new Fraction(1, 0);
    }

    @Test(expectedExceptions = NullPointerException.class,
            description = "Не заполнены числитель и знаменатель")
    @Tag("Negative")
    public void nullFraction() {
        new Fraction(null, null);
    }

    @Test(expectedExceptions = RuntimeException.class,
            description = "Переполнение")
    @Tag("Negative")
    public void longFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(1, Integer.MAX_VALUE);
        Fraction.sum(first, second);
    }
}
