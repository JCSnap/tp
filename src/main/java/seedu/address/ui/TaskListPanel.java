package seedu.address.ui;

import java.util.Comparator;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.task.Task;

/**
 * Panel containing the list of tasks.
 */
public class TaskListPanel extends UiPart<Region> {
    private static final String FXML = "TaskListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TaskListPanel.class);

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane taskInfoView;

    @FXML
    private VBox scrollableBox;

    @FXML
    private Label selectLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private HBox statusView;

    @FXML
    private Label statusText;

    @FXML
    private Label deadlineView;

    @FXML
    private HBox priorityView;

    @FXML
    private Label priorityText;

    @FXML
    private HBox memberView;

    @FXML
    private VBox memberList;

    @FXML
    private Label noteView;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */
    public TaskListPanel(ObservableList<Task> taskList) {
        super(FXML);
        taskListView.setItems(taskList);
        taskListView.setCellFactory(listView -> new TaskListViewCell());

        //@@author asdfghjkxd-reused
        // reused from https://stackoverflow.com/questions/52184611/javafx-keep-oldvalue-and-newvalue-of-listview-the
        // -same-when-condition-has-not-b with minor updates
        taskListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isSameTask(oldValue)) {
                this.setTaskInformation(newValue);

                // scroll to avoid jumpy behaviour
                this.taskListView.getSelectionModel().select(newValue);
            }
        });
        //@@author

        //@@author asdfghjkxd-reused
        // reused from https://copyprogramming.com/howto/implementing-a-global-key-press-for-javafx-methods with
        // minor updates
        taskListView.setOnKeyPressed(
                x -> {
                    if (x.getCode() == KeyCode.ESCAPE) {
                        clearSidePanel();
                    }

                    x.consume();
                }
        );
        //@@author

        this.destroyTaskInformationView();
    }

    /**
     * Clears the side panel.
     */
    public void clearSidePanel() {
        this.taskListView.getSelectionModel().clearSelection();
        this.destroyTaskInformationView();
    }

    public void setTaskInformation(Task task) {
        // set the visibility of the fields
        this.selectLabel.setVisible(false);
        this.descriptionLabel.setVisible(true);
        this.statusView.setVisible(true);
        this.statusText.setVisible(true);
        this.deadlineView.setVisible(true);
        this.priorityView.setVisible(true);
        this.priorityText.setVisible(true);
        this.memberView.setVisible(true);
        this.memberList.setVisible(true);
        this.noteView.setVisible(true);

        // set the managed of the fields
        this.selectLabel.setManaged(false);
        this.descriptionLabel.setManaged(true);
        this.statusView.setManaged(true);
        this.statusText.setManaged(true);
        this.deadlineView.setManaged(true);
        this.priorityView.setManaged(true);
        this.priorityText.setManaged(true);
        this.memberView.setManaged(true);
        this.memberList.setManaged(true);
        this.noteView.setManaged(true);

        this.scrollableBox.setAlignment(Pos.TOP_LEFT);

        this.getDescriptionField(task);
        this.getStatusField(task);
        this.getDeadlineField(task);
        this.getPriorityField(task);
        this.getMemberField(task);
        this.getNoteField(task);

        this.taskInfoView.setFitToHeight(false);
    }

    /**
     * Selects the task in the list view and sets the task information.
     */
    public void selectAndSetTaskInformation(Task task) {
        this.taskListView.getSelectionModel().select(task);
        this.setTaskInformation(task);
    }

    private void destroyTaskInformationView() {
        // hide all views except select label
        this.selectLabel.setVisible(true);
        this.descriptionLabel.setVisible(false);
        this.statusView.setVisible(false);
        this.statusText.setVisible(false);
        this.deadlineView.setVisible(false);
        this.priorityView.setVisible(false);
        this.priorityText.setVisible(false);
        this.memberView.setVisible(false);
        this.memberList.setVisible(false);
        this.noteView.setVisible(false);

        // set the managed of the fields
        this.selectLabel.setManaged(true);
        this.descriptionLabel.setManaged(false);
        this.statusView.setManaged(false);
        this.statusText.setManaged(false);
        this.deadlineView.setManaged(false);
        this.priorityView.setManaged(false);
        this.priorityText.setManaged(false);
        this.memberView.setManaged(false);
        this.memberList.setManaged(false);
        this.noteView.setManaged(false);

        this.scrollableBox.setAlignment(Pos.CENTER);
        this.taskInfoView.setFitToWidth(true);
        this.taskInfoView.setFitToHeight(true);
    }

    private void getDescriptionField(Task task) {
        this.descriptionLabel.setText(task.getDescription().fullDescription);
    }

    private void getStatusField(Task task) {
        this.statusText.setText(task.getStatus().toString());
    }

    private void getDeadlineField(Task task) {
        this.deadlineView.setText("Deadline: " + task.getDeadline().toString());
    }

    private void getPriorityField(Task task) {
        // set the priority text
        this.priorityText.setText(task.getPriority().toString());

        // then set the style class
        switch (task.getPriority()) {
        case LOW:
            this.priorityText.getStyleClass().clear();
            this.priorityText.getStyleClass().add("low_priority_cell_small_label");
            break;
        case MEDIUM:
            this.priorityText.getStyleClass().clear();
            this.priorityText.getStyleClass().add("medium_priority_cell_small_label");
            break;
        case HIGH:
            this.priorityText.getStyleClass().clear();
            this.priorityText.getStyleClass().add("high_priority_cell_small_label");
            break;
        default:
            this.priorityText.getStyleClass().clear();
            this.priorityText.getStyleClass().add("default_priority_cell_small_label");
            break;
        }
    }

    private void getMemberField(Task task) {
        this.memberList.getChildren().clear();

        task.getMembers().stream().sorted(Comparator.comparing(x -> x.memberName))
                .forEach(x -> {
                    if (x.memberName.length() > 25) {
                        String truncatedName = x.memberName.substring(0, 25) + "...";
                        Label label = new Label(truncatedName);
                        label.getStyleClass().add("member_cell_label");

                        Tooltip tooltip = new Tooltip(x.memberName.substring(0, Math.min(x.memberName.length(), 99)));
                        tooltip.setShowDelay(new Duration(500));
                        Tooltip.install(label, tooltip);
                        this.memberList.getChildren().add(label);
                    } else {
                        Label label = new Label(x.memberName);
                        label.getStyleClass().add("member_cell_label");
                        this.memberList.getChildren().add(label);
                    }
                });
    }

    private void getNoteField(Task task) {
        this.noteView.setText("Notes:\n" + task.getNote().fullNote);
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Task} using a {@code TaskCard}.
     */
    class TaskListViewCell extends ListCell<Task> {
        @Override
        protected void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TaskCard(task, getIndex() + 1).getRoot());
            }
        }
    }

}
