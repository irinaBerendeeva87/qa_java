import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PLionTest {
    private final String sex;
    private final boolean expectedResult;

    public PLionTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getCorrectHasManeValue() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void hasManeLionTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", expectedResult, actualResult);
    }

}
