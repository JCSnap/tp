package seedu.address.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Task;

/**
 * An UI component that displays information of a {@code Task}.
 */
public class TaskCard extends UiPart<Region> {

    private static final String FXML = "TaskListCard.fxml";
    private static final double COMPLETED_OPACITY_VALUE = 0.1;
    private static final double INCOMPLETE_OPACITY_VALUE = 1.0;

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on TaskWise level 4</a>
     */

    public final Task task;

    @FXML
    private GridPane cardPane;
    @FXML
    private Label idAndDescription;
    @FXML
    private Label deadline;
    @FXML
    private Label note;
    @FXML
    private Label status;
    @FXML
    private Label defaultPriority;
    @FXML
    private Label lowPriority;
    @FXML
    private Label mediumPriority;
    @FXML
    private Label highPriority;
    @FXML
    private FlowPane members;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);

        this.task = task;

        setOverlay(task.getStatus().isCompleted());
        setDescription(task.getDescription().fullDescription, displayedIndex);

        note.setText(task.getNote().fullNote);
        setPriority(task.getPriority().toString());
        deadline.setText(task.getDeadline().toString());
        status.setText(task.getStatus().toString());
        this.members.prefHeightProperty().bind(this.cardPane.heightProperty().divide(4));
        setMembers(this.task.getMembers());
    }

    private void setDescription(String fullDescription, int displayedIndex) {
        String description = displayedIndex + ". " + fullDescription;
        this.idAndDescription.setText(description);
    }

    private void setMembers(Set<Member> source) {
        if (source == null || source.isEmpty()) {
            return;
        }

        members.getChildren().clear();
        members.setHgap(5.00);
        members.setVgap(5.00);
        List<Member> sourceMembers = new ArrayList<>(source);
        sourceMembers.sort(Comparator.comparing(x -> x.memberName));
        int excessCount = 0;

        for (Member m : sourceMembers) {
            if (members.getChildren().size() < 3) {
                if (m.memberName.length() > 6) {
                    String truncatedName = m.memberName.substring(0, 6) + "...";
                    Label label = new Label(truncatedName);
                    label.getStyleClass().add("member_cell_label");

                    Tooltip tooltip = new Tooltip(m.memberName.substring(0, Math.min(m.memberName.length(), 99)));
                    tooltip.setShowDelay(new Duration(500));
                    Tooltip.install(label, tooltip);
                    members.getChildren().add(label);
                } else {
                    Label label = new Label(m.memberName);
                    label.getStyleClass().add("member_cell_label");
                    members.getChildren().add(label);
                }
            } else {
                excessCount++;
            }
        }

        if (excessCount > 0) {
            Label excessLabel = new Label("+" + Math.min(excessCount, 99));
            excessLabel.getStyleClass().add("member_cell_overflow");
            members.getChildren().add(excessLabel);
        }
    }

    private void setOverlay(boolean isCompleted) {
        if (isCompleted) {
            this.cardPane.setOpacity(COMPLETED_OPACITY_VALUE);
        } else {
            this.cardPane.setOpacity(INCOMPLETE_OPACITY_VALUE);
        }
    }

    public void setPriority(String priorityText) {
        switch (priorityText.toLowerCase()) {
        case "low":
            lowPriority.setVisible(true);
            lowPriority.setManaged(true);
            lowPriority.setText(priorityText);
            break;
        case "medium":
            mediumPriority.setVisible(true);
            mediumPriority.setManaged(true);
            mediumPriority.setText(priorityText);
            break;
        case "high":
            highPriority.setVisible(true);
            highPriority.setManaged(true);
            highPriority.setText(priorityText);
            break;
        default:
            defaultPriority.setVisible(true);
            defaultPriority.setManaged(true);
            defaultPriority.setText(priorityText);
        }
    }

}
