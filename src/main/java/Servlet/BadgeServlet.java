package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.BadgeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet.BadgeServlet: a servlet deal with badges
 */
@WebServlet(name = "Servlet.BadgeServlet")
public class BadgeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet.BadgeServlet");
        String result, id = "000000100";
        BadgeDao myPOJO = new BadgeDao();
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        id = request.getParameter(EntityConfig.ID);
        result = myPOJO.getBadgeById(id);

        PrintWriter out = response.getWriter();
        System.out.println(result);
        out.write(result);
        out.flush();
        out.close();
    }
}
