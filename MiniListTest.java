package ass2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.NoSuchElementException;

class MiniListTest {

    @Test
    void testIsEmpty() {
        MiniList<Integer> list = new MiniList<Integer>();
        assertEquals(true, list.isEmpty());

        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            assertEquals(false, list.isEmpty());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(false, list.isEmpty());
            list.removeFirst();
        }
        assertEquals(true, list.isEmpty());
    }

    @Test
    void testAddFirst() {
        MiniList<Integer> list = new MiniList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            assertEquals(list.getFirst(), i);
        }
    }

    @Test
    void testGetFirst() {
        MiniList<String> list = new MiniList<String>();
        for (int i = 0; i < 10; i++) {
            list.addFirst("" + i);
            assertEquals("" + i, list.getFirst());
        }
    }

    @Test
    void testGetFirstException() {
        assertThrows(NoSuchElementException.class, () -> {
            MiniList<Integer> list = new MiniList<Integer>();
            list.getFirst();
        });
    }

    @Test
    void testRemoveFirst() {
        MiniList<Integer> list = new MiniList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        for (int i = 9; i > 0; i--) {
            assertEquals(i, list.removeFirst());
            assertEquals(i - 1, list.getFirst());
        }
    }

    @Test
    void testRemoveFirstException() {
        assertThrows(NoSuchElementException.class, () -> {
            MiniList<Integer> list = new MiniList<Integer>();
            list.removeFirst();
        });
    }

    @Test
    void testAddLast() {
        MiniList<Integer> list = new MiniList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
            assertEquals(0, list.getFirst());
        }

        for (int i = 9; i > 0; i--) {
            list.removeFirst();
            assertEquals(10 - i, list.getFirst());
        }

        list = new MiniList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(9 - i, list.removeLast());
        }
    }

    @Timeout(10)
    @Test
    void testAddLastTime() {
        assertTimeout(Duration.ofSeconds(10), () -> {
            MiniList<Integer> list = new MiniList<Integer>();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                list.addLast(i);
            }
            long end = System.currentTimeMillis();
            System.out.println("DEBUG: AddLast time test run in: " + (end - start) / 1000 + "sec");
        });
    }

    @Test
    void testRemoveLast() {
        MiniList<Integer> list = new MiniList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(9 - i, list.removeLast());
        }
    }

    @Test
    void testRemoveLastException() {
        assertThrows(NoSuchElementException.class, () -> {
            MiniList<Integer> list = new MiniList<Integer>();
            for (int i = 0; i < 10; i++) {
                list.addLast(i);
            }

            while (!list.isEmpty()) {
                list.removeLast();
            }

            list.removeLast();
        });
    }
}
