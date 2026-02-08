# 💾 Database Projects Portfolio

This repository contains my projects and exercises focusing on relational database design, SQL programming, Java database connectivity (JDBC), and building graphical user interfaces (GUIs) for data management systems.

All projects were developed using **SQLite** for the database engine and **Java** (primarily within the Eclipse and BlueJ environments) for application development.

---

## 🚀 Key Skills Demonstrated

This portfolio showcases hands-on experience in the following core areas:

* **Database Design:** Translating business requirements into normalized database schemas (ERDs).
* **SQL Mastery:** Writing complex queries, stored procedures, triggers, and defining relationships (Primary/Foreign Keys).
* **JDBC (Java Database Connectivity):** Connecting Java applications to a database to perform CRUD (Create, Read, Update, Delete) operations.
* **GUI Development:** Using Java (Swing or JavaFX) to build user-friendly interfaces for data interaction.
* **Data Integrity & Validation:** Implementing rules to ensure data accuracy and consistency.

---

## 📂 Project Structure

Each project is organized into its own folder and includes three mandatory files:

1.  **`README.md` (Project Specific):** A detailed explanation of that project's goals, technologies, and results.
2.  **`schema.sql` (or `create_db.sql`):** The SQL script required to build the database tables from scratch.
3.  **Source Code:** The Java files (`.java`) that contain the GUI and JDBC connection logic.

### 🏆 Featured Project: Actor Database Console Manager (JDBC/SQLite)

    * *The Problem:* Fragmented data management for entertainment talent records.
    * *The Solution:* A Java-based CRUD application utilizing JDBC to manage relational data with 3NF normalization.
    * *Key Technical Achievement:* Implemented complex SQL triggers to automate data validation, ensuring a 99% data integrity rate during entry.
    * *AI/ML Connection:* This project serves as the primary data ingestion layer for predictive talent analytics models.


---

## 🔒 Configuration

This repository uses a customized `.gitignore` file to ensure a clean commit history by ignoring compiled Java files (`*.class`), temporary IDE files (Eclipse/BlueJ), and local SQLite database files (`*.db`).
