import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalTest {
    private String animalKind;
    private List<String> expectedFood;
    private Animal animal;

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.animal = new Animal();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFood, food);
    }

    @Test
    public void testGetFoodUnknownAnimal() {
        animal = new Animal();
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
