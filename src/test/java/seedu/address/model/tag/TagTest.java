package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void equals_self_valid() {
        Tag tag = new Tag("tag");
        assertTrue(tag.equals(tag));
    }

    @Test
    public void equals_notTag_invalid() {
        Tag tag = new Tag("tag");
        Tag tagOther = new Tag("otherTag");
        assertFalse(tag.equals(tagOther));
    }

    @Test
    public void toString_tag_valid() {
        Tag tag = new Tag("tag");
        assertEquals(tag.toString(), "[tag]");
    }

}
