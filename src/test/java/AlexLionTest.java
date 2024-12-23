import com.example.AlexLion;
import com.example.FelineLion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexLionTest {
    private AlexLion alexLion;
    private FelineLion felineLion;

    @Before
    public void setUp() throws Exception {
        felineLion = new FelineLion() {
            @Override
            public List<String> getFood(String type) throws Exception {
                return List.of();
            }

            @Override
            public int getKittens() {
                return 0;
            }
        };
        alexLion = new AlexLion(felineLion);
    }
    
    @Test
    public void testGetFriends() {
        List<String> friends = alexLion.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
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
        List<String> food = alexLion.getFood();
        assertNotNull(food);
    }
}
