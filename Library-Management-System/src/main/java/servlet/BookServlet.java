package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import entity.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookDAO.getBooks();
        
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayBooks.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            // Default action
            action = "list";
        }

        switch (action) {
            case "create":
                createBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                listBooks(request, response);
        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        Book newBook = new Book(title,author,isbn);
        
        boolean created = bookDAO.createBook(newBook);

        if (created) {
            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("failed.jsp"); // Redirect to a failure page
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Book existedBook = bookDAO.getBook(Integer.parseInt(request.getParameter("bookId")));
    	existedBook.setTitle(request.getParameter("newTitle")); ;
        
        boolean updated = bookDAO.updateBook(existedBook);

        if (updated) {
            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("failed.jsp"); // Redirect to a failure page
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        boolean deleted = bookDAO.deleteBook(bookId);

        if (deleted) {
            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("failed.jsp"); // Redirect to a failure page
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookDAO.getBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/displayBooks.jsp").forward(request, response);
    }
}
