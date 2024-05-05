# My Todos Application

My Todos is a simple web application for managing your todos. It allows you to create, update, delete, and mark todos as completed.

## Features

- **Add New Todo**: Easily add a new todo with a name, description, and state.
- **List All Todos**: View a list of all your todos, with options to edit, delete, and mark as completed.
- **Edit Todo**: Update the name, description, or state of an existing todo.
- **Delete Todo**: Remove a todo from your list.
- **Mark as Completed/Not Completed**: Toggle the state of a todo between completed and not completed.

## Technologies Used

- **Java**: Backend logic and servlets are implemented in Java.
- **JSP (JavaServer Pages)**: Dynamic web pages are created using JSP for rendering HTML content.
- **JSTL (JavaServer Pages Standard Tag Library)**: Used for iterating over todo items and conditionally rendering HTML elements.
- **Servlets**: Handle HTTP requests and perform CRUD operations on todos.
- **Tailwind CSS**: CSS framework for styling the frontend components.
- **Font Awesome**: Icon library for adding icons to buttons and links.

## Usage

1. **Clone Repository**: Clone this repository to your local machine.
   ```bash
   git clone https://github.com/srimalonline/todo-mvc-from-j2ee.git

2. **Import Project**: Import the project into your preferred Java IDE.

3. **Set Up Database**: Set up a MySQL database and configure the database connection in the `TodoDAO.java` file located in the `dao` package.

4. **Run Application**: Deploy the application on a Java EE server (e.g., Apache Tomcat) and run it.

5. **Access Application**: Open your web browser and navigate to `http://localhost:8080/todo-mvc-from-j2ee/`.
