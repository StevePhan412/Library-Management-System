package servlet;

import dao.IssueDAO;
import entity.IssueDetail;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookIssue")
public class IssueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IssueDAO issueDAO;

    public IssueServlet() {
        super();
        this.issueDAO = new IssueDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listIssues(request, response);
                break;
            default:
                listIssues(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookIdStr = request.getParameter("bookId");
        String issueIdStr = request.getParameter("issueId");
        String userIdStr = request.getParameter("userId");
        String action = request.getParameter("action");
        boolean isSuccess = false;

        if ("issue".equals(action)) {
        	int bookId = Integer.parseInt(bookIdStr);
            int userId = Integer.parseInt(userIdStr);
            isSuccess = issueDAO.issueBook(bookId, userId);
        } else if ("delete".equals(action)) {
            try {
            	int issueId = Integer.parseInt(issueIdStr);
				isSuccess = issueDAO.deleteIssueByIssueId(issueId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        } else {
            isSuccess = false;
        }

        if (isSuccess) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    }

    private void listIssues(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<IssueDetail> issues = issueDAO.getAllIssues();
        request.setAttribute("issues", issues);
        request.getRequestDispatcher("/issueList.jsp").forward(request, response);
    }
}
