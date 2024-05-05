package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TodoDAO;
import model.Todo;

@WebServlet(name = "TodoServlet", urlPatterns = {"/"})
public class TodoServlet extends HttpServlet {
    private TodoDAO todoDAO;
    
    @Override
    public void init() {
        todoDAO = new TodoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new" -> showNewForm(request, response);
                case "/insert" -> insertTodo(request, response);
                case "/delete" -> deleteTodo(request, response);
                case "/edit" -> showEditForm(request, response);
                case "/update" -> updateTodo(request, response);
                default -> listTodo(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }      
    }
    
    private void listTodo(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ServletException {
        List<Todo> listTodo = todoDAO.selectAllTodos();
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/todo-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/todo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Todo existingTodo = todoDAO.selectTodo(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/todo-form.jsp");
        request.setAttribute("todo", existingTodo);
        dispatcher.forward(request, response);
    }

    private void insertTodo(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        boolean state = Boolean.parseBoolean(request.getParameter("state"));
        Todo newTodo = new Todo(name, description, state);
        todoDAO.insertTodo(newTodo);
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) 
        throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    boolean state = Boolean.parseBoolean(request.getParameter("state"));

    Todo todo = new Todo();
    todo.setId(id);
    todo.setName(name); // Set the name parameter in the Todo object
    todo.setDescription(description); // Set the description parameter in the Todo object
    todo.setState(state);
    
    todoDAO.updateTodo(todo);
    response.sendRedirect(request.getContextPath() + "/");
    }
    
    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoDAO.deleteTodo(id);
        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
