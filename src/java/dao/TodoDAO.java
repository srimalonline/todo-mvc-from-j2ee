package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Todo;

public class TodoDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/todo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "pass";

    private static final String INSERT_TODO_SQL = "INSERT INTO todos (name, description, state) VALUES (?, ?, ?)";
    private static final String SELECT_TODO_BY_ID = "SELECT * FROM todos WHERE id=?";
    private static final String SELECT_ALL_TODOS = "SELECT * FROM todos";
    private static final String DELETE_TODO_SQL = "DELETE FROM todos WHERE id=?";
    private static final String UPDATE_TODO_SQL = "UPDATE todos SET name=?, description=?, state=? WHERE id=?";

    public TodoDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertTodo(Todo todo) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODO_SQL)) {
            preparedStatement.setString(1, todo.getName());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setBoolean(3, todo.isState());
            preparedStatement.executeUpdate();
        }
    }

    public Todo selectTodo(int id) {
        Todo todo = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean state = rs.getBoolean("state");
                todo = new Todo(id, name, description, state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public List<Todo> selectAllTodos() {
        List<Todo> todos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean state = rs.getBoolean("state");
                todos.add(new Todo(id, name, description, state));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public boolean deleteTodo(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TODO_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateTodo(Todo todo) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TODO_SQL)) {
            statement.setString(1, todo.getName());
            statement.setString(2, todo.getDescription());
            statement.setBoolean(3, todo.isState());
            statement.setInt(4, todo.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
