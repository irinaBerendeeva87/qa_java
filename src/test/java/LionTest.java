import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;
    private final int kittensCount;

    private final Feline feline = Mockito.mock(Feline.class);

    public LionTest(String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getLionTest() {
        return new Object[][]{
                {"Cамец", true, 1},
                {"Cамка", false, 1},
                {"Носорог", false, 0}
        };
    }

    @Test
    public void getHasMane() {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void getFoodReturnValidFoodOfLion() {
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void getKittensReturnValidNumberOfLionKittens() {
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(kittensCount);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void lionFemaleReturnHasMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("Lionessa doesn't have the mane", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedhasMane = true;
        boolean actualhasMane = lion.doesHaveMane();
        Assert.assertEquals("Lion has mane", expectedhasMane, actualhasMane);
    }
}