package HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomHashMapTest {

    @Test
    public void testSizeAndIsEmpty() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        assertTrue(map.isEmpty());
        assertEquals(0, map.getSize());

        map.put("A", "Apple");
        assertFalse(map.isEmpty());
        assertEquals(1, map.getSize());

        map.put("B", "Banana");
        assertEquals(2, map.getSize());
    }

    @Test
    public void testRemoveHeadNode() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(4);
        map.put(1, "One");
        map.put(5, "Five"); // same bucket as 1 if capacity is 4

        assertTrue(map.remove(1));
        assertNull(map.get(1));
        assertEquals(1, map.getSize());
    }

    @Test
    public void testRemoveMiddleNode() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        map.put(2, "Two");
        map.put(4, "Four");
        map.put(6, "Six");

        // All map to same bucket in small map
        assertTrue(map.remove(4));
        assertNull(map.get(4));
        assertEquals(2, map.getSize());
    }

    @Test
    public void testRemoveTailNode() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        map.put(2, "Two");
        map.put(4, "Four");
        map.put(6, "Six");

        assertTrue(map.remove(6));
        assertNull(map.get(6));
        assertEquals(2, map.getSize());
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullKeyThrowsException() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put(null, "null");
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullValueThrowsException() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("null", null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNullKeyThrowsException() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.get(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullKeyThrowsException() {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.remove(null);
    }

    @Test
    public void testResizePreservesEntries() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(4, 0.75f);

        for (int i = 0; i < 100; i++) {
            map.put("key" + i, i);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(i, map.get("key" + i).intValue());
        }

        assertEquals(100, map.getSize());
    }

    @Test
    public void testResizeTriggersProperly() {
        CustomHashMap<String, String> map = new CustomHashMap<>(2, 0.75f); // threshold = 1

        map.put("a", "alpha");
        map.put("b", "bravo"); // should trigger resize

        assertEquals("alpha", map.get("a"));
        assertEquals("bravo", map.get("b"));
    }
}
