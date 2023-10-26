package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.util.JsonUtil;
import seedu.address.model.TaskWise;
import seedu.address.storage.exceptions.json.IllegalJsonValueException;
import seedu.address.testutil.TypicalTasks;

public class JsonSerializableTaskWiseTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableTaskWiseTest");
    private static final Path TYPICAL_TASKS_FILE = TEST_DATA_FOLDER.resolve("typicalTasksTaskWise.json");
    private static final Path INVALID_TASK_FILE = TEST_DATA_FOLDER.resolve("invalidTaskTaskWise.json");
    private static final Path DUPLICATE_TASK_FILE = TEST_DATA_FOLDER.resolve("duplicateTaskTaskWise.json");

    @Test
    public void toModelType_typicalTasksFile_success() throws Exception {
        JsonSerializableTaskWise dataFromFile = JsonUtil.readJsonFile(TYPICAL_TASKS_FILE,
                JsonSerializableTaskWise.class).get();
        TaskWise taskWiseFromFile = dataFromFile.toModelType();
        TaskWise typicalTasksTaskWise = TypicalTasks.getTypicalTaskWise();
        assertEquals(taskWiseFromFile, typicalTasksTaskWise);
    }

    @Test
    public void toModelType_invalidTaskFile_throwsIllegalValueException() throws Exception {
        JsonSerializableTaskWise dataFromFile = JsonUtil.readJsonFile(INVALID_TASK_FILE,
                JsonSerializableTaskWise.class).get();
        assertThrows(IllegalJsonValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateTasks_throwsIllegalValueException() throws Exception {
        JsonSerializableTaskWise dataFromFile = JsonUtil.readJsonFile(DUPLICATE_TASK_FILE,
                JsonSerializableTaskWise.class).get();
        assertThrows(IllegalJsonValueException.class,
                dataFromFile::toModelType);
    }
}
