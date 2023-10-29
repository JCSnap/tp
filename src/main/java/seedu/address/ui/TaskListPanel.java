package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.task.Priority;
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
    private VBox taskInformationView;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */
    public TaskListPanel(ObservableList<Task> taskList) {
        super(FXML);
        taskListView.setItems(taskList);
        taskListView.setCellFactory(listView -> new TaskListViewCell());
        taskListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null && !newValue.isSameTask(oldValue)) {
                        this.setTaskInformation(newValue);

                        // scroll to avoid jumpy behaviour
                        this.taskListView.getSelectionModel().select(newValue);
                    }
                }
        );

        //@@author asdfgjkxd-reused
        // reused from https://copyprogramming.com/howto/implementing-a-global-key-press-for-javafx-methods
        taskListView.setOnKeyPressed(
                x -> {
                    if (x.getCode() == KeyCode.ESCAPE) {
                        taskListView.getSelectionModel().clearSelection();
                        this.destroyTaskInformationView();
                    }

                    x.consume();
                }
        );
        //@@author

        taskInformationView.setVisible(false);
    }

    public void setTaskInformation(Task task) {
        BackgroundFill backgroundFill = new BackgroundFill(
                Paint.valueOf("#FCF6DB"), new CornerRadii(10.0), Insets.EMPTY
        );

        // show side panel
        this.gridPane.getColumnConstraints().get(0).setPercentWidth(60.0);
        this.gridPane.getColumnConstraints().get(1).setPercentWidth(40.0);

        // set up the view
        this.taskInformationView.setVisible(true);
        this.taskInformationView.getChildren().clear();
        this.taskInformationView.setBackground(
                new Background(backgroundFill)
        );
        this.taskInformationView.setPadding(
                new Insets(5, 5, 5, 5)
        );
        this.taskInformationView.setAlignment(Pos.TOP_LEFT);


        Label descriptionView = this.getDescriptionField(task);
        HBox statusView = this.getStatusField(task);
        Label deadlineView = this.getDeadlineField(task);
        HBox priorityView = this.getPriorityField(task);
        HBox assigneeView = this.getAssigneeField(task);
        Label noteView = this.getNoteField(task);

        this.taskInformationView.getChildren().addAll(
                descriptionView, statusView, deadlineView, priorityView, assigneeView, noteView
        );
    }

    private void destroyTaskInformationView() {
        // set up the view
        this.taskInformationView.setVisible(false);

        // show side panel
        this.gridPane.getColumnConstraints().get(0).setPercentWidth(100.0);
        this.gridPane.getColumnConstraints().get(1).setPercentWidth(0.0);
    }

    private Label getDescriptionField(Task task) {
        Label description = new Label(task.getDescription().fullDescription);
        description.setWrapText(true);
        description.setStyle("-fx-text-fill: black; -fx-font-size: 22; -fx-font-family: Glacial Indifference Bold");

        return description;
    }

    private HBox getStatusField(Task task) {
        HBox status = new HBox();
        Label stat = new Label("Status: ");
        stat.setStyle("-fx-text-fill: black;");

        Label formatStat = new Label(task.getStatus().toString());
        formatStat.setStyle("-fx-text-fill: black; -fx-background-color: #E0DAF9; -fx-padding: 1 3 1 3; "
                + "-fx-border-radius: 2; -fx-background-radius: 2; -fx-font-size: 11;");

        status.getChildren().addAll(
                stat, formatStat
        );

        return status;
    }

    private Label getDeadlineField(Task task) {
        Label dl = new Label("Deadline: " + task.getDeadline().toString());
        dl.setStyle("-fx-text-fill: black;");
        return dl;
    }

    private HBox getPriorityField(Task task) {
        HBox box = new HBox();
        Label title = new Label("Priority: ");
        title.setStyle("-fx-text-fill: black");

        Priority priority = task.getPriority();
        Label priorityLabel = new Label(priority.toString());

        switch (priority) {
            case LOW:
                priorityLabel.setStyle("-fx-text-fill: black; -fx-background-color: #7ED957; -fx-padding: 1 4 1 4; "
                        + "-fx-border-radius: 2; -fx-background-radius: 0 10 0 10; -fx-font-size: 11");
                break;
            case MEDIUM:
                priorityLabel.setStyle("-fx-text-fill: black; -fx-background-color: #FFDE59; -fx-padding: 1 4 1 4; "
                        + "-fx-border-radius: 2; -fx-background-radius: 0 10 0 10; -fx-font-size: 11");
                break;
            case HIGH:
                priorityLabel.setStyle("-fx-text-fill: black; -fx-background-color: #FF443A; -fx-padding: 1 4 1 4; "
                        + "-fx-border-radius: 2; -fx-background-radius: 0 10 0 10; -fx-font-size: 11");
                break;
            default:
                priorityLabel.setStyle("-fx-text-fill: black; -fx-background-color: #c2c1c1; -fx-padding: 1 4 1 4; "
                        + "-fx-border-radius: 2; -fx-background-radius: 0 10 0 10; -fx-font-size: 11");
                break;
        }

        box.getChildren().addAll(title, priorityLabel);
        return box;
    }

    private HBox getAssigneeField(Task task) {
        HBox box = new HBox();
        VBox members = new VBox();

        Label title = new Label("Members: ");
        title.setStyle("-fx-text-fill: black");

        for (int i = 0; i < 10; i++) {
            members.getChildren().add(
                    new Label("Member " + i)
            );
        }

        box.getChildren().addAll(title, members);
        return box;
    }

    private Label getNoteField(Task task) {
        Label note = new Label("Notes: " + task.getNote().fullNote);
        note.setWrapText(true);
        note.setStyle("-fx-text-fill: black");
        return note;
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
