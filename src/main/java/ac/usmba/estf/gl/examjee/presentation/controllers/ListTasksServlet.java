package ac.usmba.estf.gl.examjee.presentation.controllers;

import ac.usmba.estf.gl.examjee.business.DefaultServices;
import ac.usmba.estf.gl.examjee.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/listTasks")
public class ListTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = DefaultServices.getInstance().listTasksSortedByPriority();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/WEB-INF/views/listTasks.jsp").forward(request, response);
    }
}
