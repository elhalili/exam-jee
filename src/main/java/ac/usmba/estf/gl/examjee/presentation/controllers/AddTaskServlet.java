package ac.usmba.estf.gl.examjee.presentation.controllers;

import ac.usmba.estf.gl.examjee.business.DefaultServices;
import ac.usmba.estf.gl.examjee.models.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskContent = request.getParameter("content");

        if (taskContent == null || taskContent.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You cannot add an empty task");
            return;
        }
        Task task = new Task(taskContent);
        DefaultServices.getInstance().addTask(task);

        response.sendRedirect("listTasks");
    }
}
