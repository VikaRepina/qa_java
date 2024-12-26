import com.example.AlexLion;
import com.example.FelineLion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    private FelineLion felineLion;

    @InjectMocks
    private AlexLion alexLion;

    @Before
    public void setUp() throws Exception {
        when(felineLion.getFood(anyString())).thenReturn(List.of("Мясо", "Рыба", "Курица"));
        lenient().when(felineLion.getKittens()).thenReturn(2);
    }
    
    @Test
    public void testGetFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        List<String> friends = alexLion.getFriends();
        assertEquals("Список друзей не совпадает с ожидаемым", expectedFriends, friends);
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Место жительства не совпадает с ожидаемым","Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() {
        assertEquals(0, alexLion.getKittens());
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(alexLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedfood = Arrays.asList("Мясо", "Рыба", "Курица");
        List<String> food = alexLion.getFood();
        assertNotNull(food);
        assertEquals(expectedfood, food);
    }
}
