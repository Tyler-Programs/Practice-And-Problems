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
    public void kaprekarTest() {
        assertEquals(3, app.kaprekarIterations(3524));
        assertEquals(5, app.kaprekarIterations(10));
        assertEquals(4, app.kaprekarIterations(495));
    }
}