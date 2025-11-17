# 🎬 Project 1: Actor Database Console Manager

This project, which was **Part 1** of the course's database assignment, demonstrates fundamental skills in **Java Database Connectivity (JDBC)** by allowing a user to interact with a database through the Java console.

| Feature | Detail |
| :--- | :--- |
| **Goal** | Allow a user to perform basic **CRUD** (Create, Read, Update, Delete) operations on an `actor` table. |
| **Development Environment** | Java (likely Eclipse/BlueJ). The entire logic is contained within the `main` method of a class named `Project`. |
| **Database Used** | **sakila.db** (SQLite file). |
| **Interface** | Java Console (CLI) using a `while` loop for continuous command input. |
| **Partner** | Completed with a partner, [Partner's Name Here]. |

***

### 🛠️ Functionality and Commands

The application accepts continuous user input via a `while` loop and supports the following four main commands:

| Command | Action Performed | Skill Demonstrated |
| :--- | :--- | :--- |
| **`ADD`** | Prompts for a first and last name, then inserts the new actor record into the database. | **INSERT** via JDBC |
| **`REMOVE`** | Prompts for a first and last name, then deletes matching actor records from the database. | **DELETE** via JDBC |
| **`LIST`** | Retrieves and outputs all actors currently stored in the database. | **SELECT** via JDBC |
| **`EXIT`** | Terminates the program loop. | Loop Control |

**Error Handling:** The program includes logic to output an error message and restart the loop if an invalid command is entered.

### 📂 How to Run the Project

1.  **Clone the Repository:** Download the project files.
2.  **Database Setup:** Ensure the `sakila.db` file is placed inside the `src` folder of the Java project.
3.  **Execution:** Run the main method within the `Project` class. The console will prompt for commands.

***

### 🎯 Skills Demonstrated

* **Java Database Connectivity (JDBC):** Successfully establishing a connection to the `sakila.db` file.
* **SQL Execution:** Executing `INSERT`, `DELETE`, and `SELECT` statements dynamically based on user input.
* **Console I/O:** Accepting user input and outputting structured results and error messages.
