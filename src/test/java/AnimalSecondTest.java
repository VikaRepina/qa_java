import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalSecondTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }


    @Test
    public void testGetFoodUnknownAnimal() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестное животное");
        });

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String family = animal.getFamily();
        assertEquals(expectedFamily, family);
    }
}
