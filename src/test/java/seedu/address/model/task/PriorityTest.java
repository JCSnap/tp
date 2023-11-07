package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PriorityTest {
    @Test
    public void stringFormat() {
        assertTrue(Priority.HIGH.toString().equals("HIGH"));
    }
    @Test
    public void ofConstructor() throws Exception {
        assertTrue(Priority.LOW.equals(Priority.of("low")));
        assertFalse(Priority.LOW.equals(Priority.of("medium")));
    }
}
