package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;


import by.it_academy.jd2.Mk_JD2_98_23.service.api.IStatisticsService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.StatisticsServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatisticsService statisticsService;

    public StatisticsServlet() {
        this.statisticsService = StatisticsServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("activeSessions", statisticsService.getActiveSessions());
        req.setAttribute("userCount", statisticsService.getUserCount());
        req.setAttribute("messageCount", statisticsService.getMessageCount());
        req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
    }
}