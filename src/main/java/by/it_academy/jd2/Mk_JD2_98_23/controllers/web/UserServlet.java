package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.exception.UserCreateException;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {
    private static final String FIRSTNAME_PARAM_NAME = "firstName";
    private static final String LASTNAME_PARAM_NAME = "lastName";
    private static final String USERNAME_PARAM_NAME = "username";
    private static final String PASSWORD_PARAM_NAME = "password";
    private static final String DATE_OF_BIRTH_PARAM_NAME = "dateOfBirth";
    private final IUserService userService;

    public UserServlet() {
        this.userService = UserServiceFactory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRSTNAME_PARAM_NAME);
        String lastName = req.getParameter(LASTNAME_PARAM_NAME);
        String username = req.getParameter(USERNAME_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM_NAME);
        String dateOfBirth = req.getParameter(DATE_OF_BIRTH_PARAM_NAME);

        try {
            if (!Objects.equals(firstName, "") && !Objects.equals(lastName, "")
                    && !Objects.equals(username, "") && !Objects.equals(password, "")) {
                UserCreateDTO savedUser = new UserCreateDTO(firstName, lastName, username, password,
                        LocalDate.parse(dateOfBirth), new ArrayList<>());

                savedUser.addRole(userService.defaultRole());
                userService.save(savedUser);

                UserDTO user = userService.validate(username, password);

                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);

                req.setAttribute("registered", true);
                resp.setHeader("Refresh", "5; URL=" + req.getContextPath() + "/ui/personal");
                resp.sendRedirect(req.getContextPath() + "/ui/personal?registered=true");


            } else {
                throw new UserCreateException();
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}


