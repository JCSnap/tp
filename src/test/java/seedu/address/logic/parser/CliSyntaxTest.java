package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Checks that the relevant prefixes are present in the class
 */
public class CliSyntaxTest {
    @Test
    public void descriptionPrefix_exists() {
        assertNotNull(CliSyntax.PREFIX_DESCRIPTION);
        assertEquals(CliSyntax.PREFIX_DESCRIPTION.getPrefix(), "t/");
    }

    @Test
    public void tagDescription_exists() {
        assertNotNull(CliSyntax.PREFIX_MEMBER);
        assertEquals(CliSyntax.PREFIX_MEMBER.getPrefix(), "m/");
    }
    @Test
    public void priorityPrefix_exists() {
        assertNotNull(CliSyntax.PREFIX_PRIORITY);
        assertEquals(CliSyntax.PREFIX_PRIORITY.getPrefix(), "p/");
    }
}
