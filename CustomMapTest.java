import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomMapTest {

    private static CustomMap<String, Integer> map;

    @BeforeAll
    public static void setUp() {
        map = new CustomMap<>();
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(1), map.get("один"));
        assertEquals(Integer.valueOf(2), map.get("два"));
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(7), map.remove("один"));
        assertEquals(null, map.get("один"));
    }

    @Test
    public void testContainsKey() {
        assertEquals(true, map.containsKey("один"));
        assertEquals(false, map.containsKey("пять"));
    }
    @Test
    public void testContainsValue(){
        assertEquals(true, map.containsValue(3));
        assertEquals(false, map.containsValue(6));
    }
}