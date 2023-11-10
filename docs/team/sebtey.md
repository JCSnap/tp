# Sebastian's Project Portfolio Page

## Project Name: TaskWise
TaskWise is a task managing application used by CS2103/T task managers.
The user interacts with it via the Command Line Interface (CLI) and it has a Graphical User
Interface (GUI) made using JavaFX. It is written in Java, and it has about 13639 LoC.

Given below are my contributions to the project.

* **New Feature: Completion Status of task**
  * What it does: It shows the project manager whether the specific task is completed or incomplete.
  * Justifications: The project manager would wish to keep track of which task are completed and which are incomplete, 
  to improve project management.
  * Highlights: This mainly affects the Task Model and requires updates to be made to the TaskListCard fxml file.
* **New Feature: Members assigned to task**
  * What it does: It allows the project manager to keep track of fellow members who are assigned to specific tasks.
  * Justifications: In a group project, keeping track of who is doing whichever tasks helps the project manager to
  ensure that the respective assignees stay accountable for the completion of that task. It also helps reduce possible
  confusions on the ground as to who is doing what, improving the experience project management using TaskWise.
  * Highlights: This mainly affects the Task Model and requires updates to be made to the TaskListCard fxml file.
  * Credits: Members assigned to task feature was inspired by the AddressBook's `Tags` feature.

* **Code contributed:** [Link to reposense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=Sebtey&tabRepo=AY2324S1-CS2103T-T17-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management:**
  * Proposed alternatives that could improve team's meetings
  * Ensure that the agenda of each meeting is made clear to ensure efficiency in hitting objectives set

* **Enhancement to existing features:**
  * Enhanced the `add` command to allow for `Member` argument from the user [#127](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/127)
  * Enhanced the `edit` command to allow for `Member` argument from the user [#105](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/105)
  * Updated the UI to reflect the `Status` field [#125](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/125)
  * Updated the UI to reflect the `Member` field [#105](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/105)

* **Documentation:**
  * User Guide: 
    * Added documentation for "Unmark Task" Command, 
    * Added documentation for "Edit Task" command and 
    * Added documentation for proposed future enhancements of "Edit" command
  
  * Developer Guide: 
    * Added documentation for "Unmark Task" command
    * Added documentation for "Edit Task" command
    * Added documentation for proposed future enhancements of "Edit" command

* **Contribution to team-based tasks:**
  * Release Management

* **Review/mentoring contributions:**
  * Provides feedback for codebase quality and pull requests
  * Suggests possible alternatives to code, ensuring codebase is adhering to software engineering principles

* **Contributions to community:**
  * PRs Reviewed (with non-trivial comments): [#127](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/127)
