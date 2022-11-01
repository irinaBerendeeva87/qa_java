import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void getFamilyReturnValidFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Family is incorrect", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnValidNumberOfFelineKittens() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Assert.assertEquals("The number of kittens is incorrect", expectedKittens, actualKittens);
    }

    @Test
    public void eatMeatReturnValidMeal() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeal = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeal = feline.eatMeat();
        Assert.assertEquals("The meal is incorrect", expectedMeal, actualMeal);
    }

    @Test
    public void eatMeatReturnInvalidMeal() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeal = List.of("Трава", "Различные растения");
        List<String> actualMeal = feline.eatMeat();
        Assert.assertNotEquals("The meal is incorrect", expectedMeal, actualMeal);
    }
}
