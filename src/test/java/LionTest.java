import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    String sex;
    int kittensCount;

    private final Feline feline = Mockito.mock(Feline.class);

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

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {
        Lion lion = new Lion("Носорог", feline);
        lion. doesHaveMane();
    }

    @Test
    public void shouldBeException() {
        Feline feline = new Feline();
        Throwable exception = assertThrows(Exception.class, () -> new Lion("dsdds", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}