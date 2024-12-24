import com.example.FelineLion;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private FelineLion felineLionMock;

    private Lion lion;

    @Before
    public void setUp() throws Exception {

        lion = new Lion("Самец", felineLionMock);
    }

    @Test
    public void testGetKittens() {
        when(felineLionMock.getKittens()).thenReturn(2);
        int kittens = lion.getKittens();
        assertEquals(2, kittens);
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineLionMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() throws Exception {
        lion = new Lion("Самка", felineLionMock); // Изменяем на самку
        assertTrue(!lion.doesHaveMane());
    }

    @Test
    public void testConstructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный пол", felineLionMock);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expectedMessage, exception.getMessage());
    }
}