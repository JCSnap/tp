package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedTask.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.model.task.Description;
import seedu.address.model.task.Note;
import seedu.address.storage.exceptions.json.IllegalJsonValueException;

public class JsonAdaptedTaskTest {
    private static final String INVALID_DESCRIPTION = "Do OP2 @ Slides";
    private static final String INVALID_NOTE = "clarify ^&with tutor";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_DESCRIPTION = BENSON.getDescription().toString();
    private static final String VALID_NOTE = BENSON.getNote().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validTaskDetails_returnsTask() throws Exception {
        JsonAdaptedTask task = new JsonAdaptedTask(BENSON);
        assertEquals(BENSON, task.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedTask task =
                new JsonAdaptedTask(INVALID_DESCRIPTION, VALID_TAGS, false, VALID_NOTE);
        String expectedMessage = Description.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalJsonValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(null, VALID_TAGS, false, VALID_NOTE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName());
        assertThrows(IllegalJsonValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_DESCRIPTION, invalidTags, false, VALID_NOTE);
        assertThrows(IllegalJsonValueException.class, task::toModelType);
    }

    @Test
    public void toModelType_invalidNote_throwsIllegalValueException() {
        JsonAdaptedTask task =
                new JsonAdaptedTask(VALID_DESCRIPTION, VALID_TAGS, false, INVALID_NOTE);
        String expectedMessage = Note.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalJsonValueException.class, expectedMessage, task::toModelType);
    }
}

