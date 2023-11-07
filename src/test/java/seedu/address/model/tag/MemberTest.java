package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Member(null));
    }

    @Test
    public void constructor_emptyName_throwsIllegalArgumentException() {
        final String invalidMemberName = "";
        assertThrows(IllegalArgumentException.class, () -> new Member(invalidMemberName));
    }

    @Test
    public void constructor_whitespaceName_throwsIllegalArgumentException() {
        final String invalidMemberNameTwo = "    ";
        assertThrows(IllegalArgumentException.class, () -> new Member(invalidMemberNameTwo));
    }

    @Test
    public void constructor_nameWithSlash_throwsIllegalArgumentException() {
        final String invalidMemberNameThree = "mary/";
        assertThrows(IllegalArgumentException.class, () -> new Member(invalidMemberNameThree));
    }

    @Test
    public void isValidName_null_throwsNullPointerException() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Member.isValidName(null));
    }

    @Test
    public void isValidName_whitespaceName_false() {
        final String invalidMemberNameTwo = "    ";
        assertFalse(Member.isValidName(invalidMemberNameTwo));
    }

    @Test
    public void isValidName_nameWithSlash_false() {
        final String invalidMemberNameThree = "mary/";
        assertFalse(Member.isValidName(invalidMemberNameThree));
    }

    @Test
    public void equals_self_valid() {
        Member member = new Member("John");
        assertTrue(member.equals(member));
    }

    @Test
    public void equals_notSame_invalid() {
        Member member = new Member("John");
        Member otherMember = new Member("otherJohn");
        assertFalse(member.equals(otherMember));
    }

    @Test
    public void equals_differentType_invalid() {
        Member member = new Member("John");
        Tag tag = new Tag("John");

        assertFalse(member.equals(tag));
    }

    @Test
    public void toString_member_valid() {
        Member tag = new Member("John");
        assertEquals(tag.toString(), "[John]");
    }
}
