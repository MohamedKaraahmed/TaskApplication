# Task Manager Console Application

**Important Note:** Please read this README before using the console application.

## Project Overview

Welcome to the Task Manager project! This console application provides various functionalities to manage your tasks efficiently. Below are the available commands along with their corresponding digits:

1. **Add Task:** Add a new task to the list. Checks for existing tasks with the same title.

2. **Edit Task:** Edit the title and description of an existing task from the active task list.

3. **Remove Task:** Remove an existing task from the list.

4. **Show Active Tasks:** Display the unfinished tasks from the list.

5. **Show Deleted Tasks:** Display the tasks that have been deleted from the list.

6. **Extract Active Tasks To A File:** Save all active tasks to a file.

7. **Extract Deleted Tasks To A File:** Save all deleted tasks to a file.

8. **Exit:** Stop the console application.

## Functionality Details

- **Add Task:**
  - Checks for existing tasks with the same title before adding to the list.

- **Edit Task:**
  - Edits the title and description of an existing task from the active task list.

- **Remove Task:**
  - Removes an existing task from the list.

- **Show Active Tasks:**
  - Displays the tasks that are unfinished from the list.

- **Show Deleted Tasks:**
  - Displays the tasks that have been deleted from the list.

- **Extract Active Tasks To A File:**
  - Saves all active tasks to a file.

- **Extract Deleted Tasks To A File:**
  - Saves all deleted tasks to a file.

- **Exit:**
  - Stops the console application.

## Additional Features

- **Unit Tests:**
  - The application includes comprehensive unit tests to ensure functionality and reliability.

- **Task History:**
  - The application keeps a history of tasks, allowing extraction of both deleted and active tasks to separate files.

## Data Storage

- The application uses the H2 Database Engine for data storing.
- JDBC is utilized for data querying.

## Usage

- Execute the corresponding digit for the desired functionality to interact with the Task Manager.
- Ensure to use the "Exit" command to stop the console application gracefully.

**Note:** Happy task managing in this console application! 😊
