# Workshop 1 - TASK MANAGER

Console program for managing tasks.


## Description

TASK MANAGER is a simple console application for managing your to-do list from the command line. Tasks are stored in a CSV-formatted text file.

Each task is saved in the file in the following format:

```
Task description, date (yyyy-mm-dd), importance (true/false)

Simple task - very important, 2020-03-09, true
Second task not so important, 2020-05-10, false
Throw away trash, 2020-03-09, false
```
## Features

- Display all tasks:
Shows a list of all tasks with their details.

- Add a task:
Allows you to add a new task by providing a description, date, and importance.

- Remove a task:
Deletes a task by its number on the list. The program checks if the entered number is valid.

- Exit the application:
Exits the program, saving your current tasks to the file.

- Load tasks from file:
At startup, the program loads the tasks from the CSV file.

- Save tasks to file:
Any changes (adding/removing tasks) are immediately saved to the file.

### Requirements ????????
Java 8 or newer

csv file example
0 : Simple task very important, 2025-03-01, true
1 : jakiekowliek, 2025-04-23, false
2 : kolejne jakiekolwiek, 2023-05-09, false
3 : i jeszcze inne zadanie, 2024-06-03, true


### Notes
The program checks if the entered number is valid when removing a task (e.g., it won't allow deleting a non-existent task).
The CSV file is updated after every operation.


## Contributing

Pull requests are welcome. For major changes, please open an issue first


## License

[MIT](https://choosealicense.com/licenses/mit/)