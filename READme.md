# Workshop 1 - TASK MANAGER

Console program for managing tasks.


## Description

TASK MANAGER is a simple console application for managing your to-do list from the command line. Tasks are stored in a CSV-formatted text file.

Each task is saved in the file in the following format:

```
No : Task description, date (yyyy-mm-dd), severity (true/false)

0 : First task, 2025-03-01, true
1 : Second task, 2025-04-23, false
2 : Third task, 2023-05-09, false
3 : Fourth task, 2024-06-03, true

```
## Features

- Display list of tasks,
- Add a task to the list,
- Remove a task from the list,
- Exit the application, 

## Usage

- At startup, the program loads the tasks from the CSV file tasks.csv,
- If CSV file tasks.csv does not exist, creates empty file.
- User can choose 4 options: add, remove, list and exit,
  - add - allows to add a new task by providing a description, date, and severity.
  - remove - deletes a task by its number on the list. The program checks if the entered number is valid.
  - list - shows a list of all tasks with their details.
  - exit - Exits the program, saving your updated list of tasks to the CSV file tasks.csv with update numbers.

### Requirements
Java 8 or newer

csv file empty or with example
0 : First task, 2025-03-01, true
1 : Second task, 2025-04-23, false
2 : Third task, 2023-05-09, false
3 : Fourth task, 2024-06-03, true

