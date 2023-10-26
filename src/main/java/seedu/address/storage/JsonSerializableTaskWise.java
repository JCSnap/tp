package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;
import seedu.address.storage.exceptions.json.IllegalJsonDuplicatedTaskException;
import seedu.address.storage.exceptions.json.IllegalJsonValueException;

/**
 * An Immutable TaskWise that is serializable to JSON format.
 */
@JsonRootName(value = "taskwise")
class JsonSerializableTaskWise {

    public static final String MESSAGE_DUPLICATE_TASK = "Tasks list contains duplicate task(s).";

    private final List<JsonAdaptedTask> tasks = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableTaskWise} with the given tasks.
     */
    @JsonCreator
    public JsonSerializableTaskWise(@JsonProperty("tasks") List<JsonAdaptedTask> tasks) {
        this.tasks.addAll(tasks);
    }

    /**
     * Converts a given {@code ReadOnlyTaskWise} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableTaskWise}.
     */
    public JsonSerializableTaskWise(ReadOnlyTaskWise source) {
        tasks.addAll(source.getTaskList().stream().map(JsonAdaptedTask::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code TaskWise} object.
     *
     * @throws IllegalJsonValueException if there were any data constraints violated.
     */
    public TaskWise toModelType() throws IllegalJsonValueException {
        TaskWise taskWise = new TaskWise();
        for (JsonAdaptedTask jsonAdaptedTask : tasks) {
            Task task = jsonAdaptedTask.toModelType();
            if (taskWise.hasTask(task)) {
                throw new IllegalJsonDuplicatedTaskException(MESSAGE_DUPLICATE_TASK);
            }
            taskWise.addTask(task);
        }
        return taskWise;
    }

}
