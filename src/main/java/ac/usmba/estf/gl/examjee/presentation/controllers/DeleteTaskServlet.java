package ac.usmba.estf.gl.examjee.presentation.controllers;

import ac.usmba.estf.gl.examjee.business.DefaultServices;
import ac.usmba.estf.gl.examjee.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (Exception exception) {
            exception.printStackTrace();

            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The task with id '" + idParam + "' does not exists");
            return;
        }

        Task task = DefaultServices.getInstance().searchTaskById(id);
        if (task == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The task with id '" + idParam + "' does not exists");
            return;
        }

        DefaultServices.getInstance().deleteTast(task);
        response.sendRedirect("listTasks");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
