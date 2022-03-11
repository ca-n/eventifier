package xyz.carn.eventifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DemoTests {
    @Test
    public void thisTestWillPass() {
        assertTrue(true);
    }

    @Test
    public void thisTestWillFail() {
        fail();
    }
}
