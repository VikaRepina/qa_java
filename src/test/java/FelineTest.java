import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @InjectMocks
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи",family);
    }
}
