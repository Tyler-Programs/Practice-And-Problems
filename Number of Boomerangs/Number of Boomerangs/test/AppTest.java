import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
    App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testCountBoomerangs() {
        int[] input1 = {3, 7, 3}; // 1 boomerang
        int[] input2 = {3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2}; // 3 boomerangs
        int[] input3 = { 1, 7, 1, 7, 1, 7, 1 }; // 5 boomerangs
        int[] input4 = { 0, 1, 2, 5, 5, 5 }; // 0 boomerangs
        assertEquals(1, app.countBoomerangs(input1));
        assertEquals(3, app.countBoomerangs(input2));
        assertEquals(5, app.countBoomerangs(input3));
        assertEquals(0, app.countBoomerangs(input4));
    }
}
