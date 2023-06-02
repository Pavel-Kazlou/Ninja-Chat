package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.exception.LoginException;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME_PARAM_NAME = "username";
    private static final String PASSWORD_PARAM_NAME = "password";
    private static final String USER_SESSION_ATTRIBUTE_NAME = "user";
    private final IUserService userService;

    public LoginServlet() {
        this.userService = UserServiceFactory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM_NAME);
        UserDTO user = userService.validate(username, password);
        HttpSession session = req.getSession(true);

        try {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            throw new LoginException("Username or password is empty!");
        }
        if (user == null) {
            throw new LoginException("Invalid username or password!");
        }

        session.setAttribute(USER_SESSION_ATTRIBUTE_NAME, user);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Authorization was successful!");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

            e.printStackTrace();
        }
    }
}