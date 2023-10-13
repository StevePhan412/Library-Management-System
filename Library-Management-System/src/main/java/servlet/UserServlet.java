package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();  // Initialize UserDAO

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("users", userDAO.getUsers());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/displayUsers.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                listUsers(request, response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        User newUser = new User(username);
 
        boolean created = userDAO.createUser(newUser);

        if (created) {
            response.sendRedirect("success.jsp"); 
        } else {
            response.sendRedirect("failed.jsp"); 
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newUsername = request.getParameter("username");
        int userId = Integer.parseInt(request.getParameter("userId"));

        User existedUser = userDAO.getUser(userId);
        if (existedUser != null) {
            existedUser.setUsername(newUsername);
            
            boolean updated = userDAO.updateUser(existedUser);

            if (updated) {
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("failed.jsp");
            }
        } else {
            response.sendRedirect("failed.jsp");
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        boolean deleted = userDAO.deleteUser(userId);

        if (deleted) {
            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("failed.jsp"); // Redirect to a failure page
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userDAO.getUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/displayUsers.jsp").forward(request, response);
    }

}
