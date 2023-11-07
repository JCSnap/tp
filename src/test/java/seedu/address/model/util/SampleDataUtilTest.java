package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class SampleDataUtilTest {
    @Test
    public void getSampleTasks_valid() {
        assertDoesNotThrow(SampleDataUtil::getSampleTasks);
    }

    @Test
    public void getSampleTaskWise_valid() {
        assertDoesNotThrow(SampleDataUtil::getSampleTaskWise);
    }
}
