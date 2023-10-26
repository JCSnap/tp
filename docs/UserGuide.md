Welcome to the TaskWise User Guide!

## Table of Content

- [Introduction](#introduction)
    - [Usage of User Guide](#usage-of-user-guide)
- [Installation Guide](#installation-guide)
- [Quick Start Guide](#quick-start-guide)
    - [Start TaskWise](#start-taskWise)
    - [Adding Your First Task](#adding-your-first-task)
    - [Mark Your First Task as Complete](#mark-your-first-task-as-complete)
    - [Mark Your First Task as Incomplete](#mark-your-first-task-as-incomplete)
    - [Deleting Your First Task](#delete-your-first-task)
- [Features](#features)
    - [Commands Summary](#commands-summary)
    - [Add Tasks](#add-tasks)
    - [Delete Tasks](#delete-tasks)
    - [See All Tasks Added](#see-all-tasks-added)
    - [Mark Tasks as Complete](#mark-tasks-as-complete)
    - [Mark Tasks as Incomplete](#mark-tasks-as-incomplete)
    - [Add Notes to Tasks](#add-notes-to-tasks)
    - [Check for Valid Command](#check-for-valid-command)
- [FAQ](#faq)

# Introduction

[[Jump to Table of Content]](#table-of-content)

We've all been there. It's exam season, and all the project deadlines are coming! As your team's project manager, you
will want to keep track of all the tasks that need to be done according to deadlines and priority levels.

TaskWise has a variety of features to help you do exactly just that! Download and install TaskWise today to start
effortlessly managing your team's workload!

## Usage of User Guide

[[Jump to Introduction]](#introduction)

This User Guide will guide you along in learning how to use TaskWise and what the different features of TaskWise are. If
you are already an experienced user, click [here](#features) to get to the summary of the different features of TaskWise
and [here](#command-summary) to get to the summary of commands that you can enter into TaskWise.

Otherwise, read on to find out more on how TaskWise can help you be a more effective project manager for your CS2103T
project!

Otherwise, just continue following the rest of the User Guide, from top to bottom, to fully learn and improve project
workflows with TaskWise!

# Installation Guide

[[Jump to Table of Content]](#table-of-content)

1. Ensure that you have Java 11 installed on your computer.
   Click [here](https://blog.hubspot.com/website/check-java-verison#:~:text=First%2C%20find%20and%20click%20on,get%20your%20current%20version%20details)
   to learn how to find out what Java version you have! If you do not have Java 11, you can download Java 11 by
   following the guide below:

- [Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
- [MacOS](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE)
- [Linux](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)

2. You might also need to install JavaFX 11. You can find the installation
   guide [here](https://openjfx.io/openjfx-docs/#install-javafx).

> **ℹ️ Note:**
> In this installation guide, you'll see the term "JDK" being used. Don't worry! JDK stands for "Java Development Kit",
> and you can treat it as the same as Java!

3. Download the latest `taskwise.jar`
   from [this page](https://github.com/orgs/AY2324S1-CS2103T-T17-1/packages?repo_name=tp/latest).
4. Drag and drop the file from your computer's downloads into any folder you want.
5. Open up the [terminal](https://support.apple.com/en-sg/guide/terminal/apd5265185d-f365-44cb-8b09-71a064a42125/mac) (
   Mac) or [command prompt](https://support.kaspersky.com/common/windows/14637#block0) (Windows).
6. Type `cd` followed by the directory path to the folder where you have downloaded TaskWise to navigate there and
   press `Enter`. For example, if you have downloaded TaskWise to your desktop, you can type the following command:

```
cd ~/Desktop
```

7. Use the command `java -jar taskwise.jar` to get the application running.

If you have done everything correctly, you should see the TaskWise application open up in a few seconds!

# Quick Start Guide

[[Jump to Table of Content]](#Table-of-Content)

> **ℹ️ Note:**
> Have you installed Java 11 from the Installation Guide? If not, click [here](#installation-guide) to learn how you can
> install Java 11! It is crucial that you complete the installation process before continuing with this quick start
> guide.

Picture this: it is Week 7 and midterms are here! However, you realise that CS2103T project deliverables are starting to
pile up, and it is up to you as your group's Project Manager to distribute the work out and track these deliverables to
ensure that the task is completed on time!

Feeling overwhelmed? Don't fret, for TaskWise is here to the rescue!

## Start TaskWise

[[Jump to Quick Start Guide]](#quick-start-guide)

Start Taskwise by following the steps laid out in the [Installation Guide](#installation-guide).

If the app is successfully launched, you should be able to see the following window on your screen.

![image](gui.png)

## Adding Your First Task

[[Jump to Quick Start Guide]](#quick-start-guide)

Firstly, let's begin by adding a new task to TaskWise! Tasks are completable objectives with or without deadlines. They
form the basis for which you can begin your project management journey with TaskWise.

Within the window, left-click on the text box highlighted in the following image, and key in the
command `add \t Complete CS2103T User Guide \d 01-01-2023` into the text box, before clicking on the "Enter" or "Return"
key.

![image](gui_1.png)

This adds a task with the title `Complete CS2103T User Guide` and the deadline is set to `01-01-2023`. Any task created
by you are set as incomplete by default.

If successful, you should be able to see the following task entry on your window!

![image](gui_2.png)

Congratulations! You have just added your first task to track into TaskWise!

## Mark Your First Task as Complete

[[Jump to Quick Start Guide]](#quick-start-guide)

After working on the task for a few days, you realise that your group has finally completed it. Now, it's time for you
to mark this task as complete on TaskWise!

To mark a task as complete, key in the command `mark \n 1` in the text box, before clicking on the "Enter" or "Return"
key.

![image](gui_2.png)

This command allows you to mark an **incomplete** task as complete! In this case, `1` represents the task number of the
task in your task list; since there is only one task in your task list, the value `1` represents the task which you have
created previously.

If the command is executed successfully, you should be able to see this on your window!

![image](gui_3.png)

You have just marked your first task as complete in TaskWise! Good job!

## Mark Your First Task as Incomplete

[[Jump to Quick Start Guide]](#quick-start-guide)

All is well, until you realise that your forgetful teammate did not add their part of the documentation into the User
Guide! Oh no! You need to now mark the task back to incomplete while the new changes to the documentation are being
reviewed.

To mark as task as incomplete, key in the command `unmark \n 1` in the text box, before clicking on the "Enter" or "
Return" key.

![image](gui_2.png)

This command allows you to mark a **complete** task as incomplete! In this case, `1` represents the task number of the
task in your task list; since there is only one task in your task list, the value `1` represents the task which you have
created previously.

If the command is executed successfully, you should be able to see this on your window!

![image](gui_3.png)

Amazing! You have just learnt how you can mark a previously completed task as incomplete!

## Delete Your First Task

[[Jump to Quick Start Guide]](#quick-start-guide)

After a week of hard work, you and your team have decided that work on the User Guide is complete. You realise that
there is no need to keep the task in TaskWise, and would like to remove it from your task list permanently.

To delete a task, key in the command `delete \n 1` in the text box, before clicking on the "Enter" or "Return" key.

![image](gui_2.png)

This command allows you to delete any task in your task list! In this case, `1` represents the task number of the task
in your task list; since there is only one task in your task list, the value `1` represents the task which you have
created previously.

If the command is executed successfully, you should be able to see this on your window!

![image](gui_3.png)

Rejoice! You have completed the Tutorial on TaskWise.

You are officially a TaskWise Wizard, ready to use TaskWise to enhance your workflows and manage your project tasks in
CS2103T!

# Features

[[Jump to Table of Content]](#table-of-content)

Looking for a more detailed explanation on what commands TaskWise can understand? Click [here](#add-tasks) to jump to
it!

Looking to get started immediately? Here is a summary of the commands that TaskWise can understand!

## Commands Summary

[[Jump to Features]](#features)

| Commands                                                         | Description                                                            |
|------------------------------------------------------------------|------------------------------------------------------------------------|
| `help`                                                           | Lists out a brief description of all commands users can use.           |
| `add d/[task_description]` ([more info](#add-tasks))             | Adds a task to the task list.                                          
| `delete [task_index]` ([more info](#delete-tasks))               | Deletes a task from the task list.                                     |
| `list`                                                           | Displays the task list to the user.                                    |
| `display`                                                        | Displays the task list to the user.                                    |
| `mark [task_index]` ([more info](#mark-tasks-as-complete))       | Marks a task at a specified index as completed.                        |
| `unmark [task_index]` ([more info](#unmark-tasks-as-incomplete)) | Remove the completed status from a task.                               |
| `priority [task_index] [priority_level]` (WIP)                   | Applies specified priotity level label to a task at a specified index. |
| `assign [task_index] [assignee_name]` (WIP)                      | Specifies the individual assigned to a task at a specified index.      |

## Add Tasks

[[Jump to Features]](#features)

### What It Does:

* Adds a task to the task list

### Command

* `add d/[task description]`

### Example

* `add` d/meeting
* `add` d/user guide

### Acceptable Values for Each Parameter

* Any valid Strings

### Expected Output

* Popup window with text: “[task status][task name] has been added successfully!”
* The task entry will be displayed on the main GUI screen

### Expected Output (Fail)

#### Cause: Missing Description

| Explanation      | Description                                                                                |
|------------------|--------------------------------------------------------------------------------------------|
| Example          | `add`                                                                                      |
| Expected Outputs | Popup window displaying text: “Please enter a valid task in this format “add {task name}”! |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/c2cdf5ba-87cb-43df-9b62-94833b373a98)

## Delete Tasks

[[Jump to Features]](#features)

### What It Does

* Deletes a task from the task list

### Command

* `delete [task number within task list]`

### Example

* `delete 1`

### Acceptable Values for Each Parameter

* string `delete`, followed by a space ` `, followed by an integer

### Expected Output

* Popup window showing the task: “[task status][task name] has been deleted successfully!”
* The original task on the GUI window will be struck through

### Expected Output (Fail)

#### Cause: Wrong Number - Out of Bounds

| Explanation      | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| Example          | `delete 3` (when there are only 2 tasks)                                    |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

#### Cause: No Index Provided

| Explanation      | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| Example          | `delete` (no task number provided)                                          |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

#### Cause: Non-Integer Input for List Index

| Explanation      | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| Example          | `delete this` (no task number provided)                                     |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/e5a3e2c5-2326-4320-a187-8a739f772262)

## See All Tasks Added

[[Jump to Features]](#features)

### What It Does

* Displays the task list to the user

### Command

* `list`
* `display`

### Example

* `list`
* `display`

### AcceptabVe Values for Each Parameter

* One of “list” or “display”, case-sensitive

### Expected Output

* A popup with the text ”Here are all your tasks!”

### Expected Output (Fail)

The task list is empty! Try adding tasks with the add command first! (when task list is empty)

#### Cause: Task List is Empty

| Explanation      | Description                                                                                              |
|------------------|----------------------------------------------------------------------------------------------------------|
| Example          | `list` or `display`                                                                                      |
| Expected Outputs | Popup window displaying text: “The task list is empty!<br/>Try adding tasks with the add command first!" |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/73705042/8c4dbe98-8815-4fca-a37b-e5730c70a28a)

## Mark Tasks As Complete

[[Jump to Features]](#features)

### What It Does

* Marks a task at a specified index as completed

### Command

* `mark [task index]`

### Example

* `mark 1`

### Acceptable Values for Each Parameter

* Any integer that is between 0 to (total number of tasks - 1) inclusive

### Expected Output

* Popup window displaying string: "Task [Task name] has been marked as done!"
* GUI strikethrough removed

### Expected Output (Fail)

#### Cause: Wrong Number - Out of Bounds

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `mark 3` (when there are only 2 tasks)                                     |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Index Provided

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `mark` (no task number provided)                                           |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: Non-Integer Input for List Index

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `mark this` (no task number provided)                                      |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/73705042/51640f4e-db06-4297-87ee-703ed847ff8a)

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/da07283a-0ca4-4f5e-b299-097d39871c45)

## Mark Tasks as Incomplete

[[Jump to Features]](#features)

### What It Does

* Remove the completed status from a task

### Command

* `unmark [task index]`

### Example

* `unmark 1`

### Acceptable Values for Each Parameter

* Any integer that is between 0 to (total number of tasks - 1) inclusive

### Expected Output

* Popup window displaying string: "Task [Task name] has been marked as undone!"
* GUI strikethrough removed

### Expected Output (Fail)

#### Cause: Task Number Does Not Exist

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `unmark 3` (when there are only 2 tasks)                                   |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Task Number Provided

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `unmark` (no task number provided)                                         |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: Task Number is Not a Number

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `unmark this` (no task number provided)                                    |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/bf62789a-5ccf-4906-9fb1-131db2d9cd96)

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/e8a3fd69-695d-4232-93b6-38d375af1786)

## Add Notes to Tasks

[[Jump to Features]](#features)

### What It Does

* Add additional information to a task

### Command

* `note [task index] [note]`

### Example

* `note 1 This task is graded`

### Acceptable Values for Each Parameter

* task number: Any integer that is between 0 to (total number of tasks - 1) inclusive
* note: Any string that contains only alphanumeric characters

### Expected Output

* Popup window displaying string: "Added Note to Task: [task description]!"

### Expected Output (Fail)

#### Cause: Task Number Does Not Exist / Not a Number

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `note 3 n/remember to bring laptop` (when there are only 2 tasks) <br/>    |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Task Number Provided

| Explanation      | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| Example          | `note n/remember to bring laptop` (no task number provided)                |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Prefix Provided

| Explanation      | Description                                                                                                    |
|------------------|----------------------------------------------------------------------------------------------------------------|
| Example          | `note 1 remember to bring laptop` (no task number provided)                                                    |
| Expected Outputs | Popup window displaying text: “I am unable to understand the note command you entered. [details about format]” |

### UI

[comment]:
<> (TODO: Add UI image for note command)

## Check for Valid Command

[[Jump to Features]](#features)

### What It Does

* Inform the user if they have entered an unknown command

### Command

* `[unrecognised commands]`

### Example

* Mistyped commands:
    * `adddddddddd [task name]`
    * `deletq 1`
    * `msrk 2`
* Invalid commands:
    * `complete 0`
    * `remove 1`
    * `djisd`

### Acceptable Values for Each Parameter

* N/A

### Expected Output

* Unrecognised Command → Popup window displays text: “The command you entered is invalid! Press “help” for available
  commands!”

### Expected Output (Fail)

* N/A

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/4c311afe-921b-4f38-a6b3-a0a187e6d581)

# FAQ

[[Jump to Table of Content]](#table-of-content)

Have some burning questions which you need answered? Here are the answers to some of the common questions that you may
have!
