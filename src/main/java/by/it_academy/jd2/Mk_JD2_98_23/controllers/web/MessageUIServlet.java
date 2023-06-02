package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.UserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/ui/user/message")
public class MessageUIServlet extends HttpServlet {
    private static final String USER_SESSION_ATTRIBUTE_NAME = "user";
    private UserService userService = (UserService) UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserDTO user = null;

        if (session == null || session.getAttribute(USER_SESSION_ATTRIBUTE_NAME) == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authorized");
            return;
        }

        if (session != null) {
            Object userObj = session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);
            if (userObj instanceof UserDTO) {
                user = (UserDTO) userObj;
            }
        }

        if (user != null) {
            List<UserDTO> users = userService.get();
            users.remove(user);
            req.setAttribute("user", user);
            req.setAttribute("users", users);
            req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/ui/");
        }
    }
}
