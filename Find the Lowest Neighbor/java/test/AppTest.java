import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
    App app;

    int[][] nodes = { { 9, 8, 7 }, { 0, -1, -3 }, { -5, -9, 54 } };

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testLowestNeighbor() {
        assertEquals(-1, app.lowestNeighbor(nodes, 0, 0));
        assertEquals(-9, app.lowestNeighbor(nodes, 1, 2));
    }
}
