package ru.rsreu.control.commands;

import ru.rsreu.datalayer.DAO.WorkersDAO;
import ru.rsreu.datalayer.data.Worker;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteWorkerCommand extends Command {
    //private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private WorkersDAO workersDAO;

    @Override
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super.init(context, request, response);
        //workersDAO = factory.getWorkersDAO();
        workersDAO =(WorkersDAO)(request.getServletContext().getAttribute("workersDAO"));
    }

    @Override
    public void send() throws IOException {
        String id = request.getParameter("id");
        Worker worker = workersDAO.getWorkerById(id);
        System.out.println("Worker found:" + worker.toString());
        if (worker == null) {
            return;
        }
        workersDAO.deleteWorker(worker);
        System.out.println("Работник с параметрами " + worker.toString() + "был удален");

/*        try {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher();

            PrintWriter out = response.getWriter();
            out.println("Работник с параметрами " + worker.toString() + "был удален");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Исключение в методе");
            e.printStackTrace();
        }
        System.out.println("Deleted worker(command)");*/
    }
}
