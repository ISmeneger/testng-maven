import org.testng.Assert;
import org.testng.annotations.Test;

import static Ilya_S.Main.checkNumberIsSquare;

public class CheckNumberTest {
    @Test(groups = {"positive"})
    void positiveTest() {
        Assert.assertTrue(checkNumberIsSquare(4));
        Assert.assertFalse(checkNumberIsSquare(5));
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Number should be greater then zero")
    void negativeTest() {
        Assert.assertFalse(checkNumberIsSquare(-1));
    }
}
