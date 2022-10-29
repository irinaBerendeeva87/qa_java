import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        FelineTest.class,
        LionTest.class,
        CatTest.class
})
public class AllTest {
}
