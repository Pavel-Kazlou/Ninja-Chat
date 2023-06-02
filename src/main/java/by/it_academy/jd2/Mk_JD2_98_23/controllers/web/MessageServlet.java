package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.MessageServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {
    private static final String TO_PARAM_NAME = "to";
    private static final String TEXT_PARAM_NAME = "text";
    private static final String USER_SESSION_ATTRIBUTE_NAME = "user";
    private final IMessageService messageService;
    private final IUserService userService;

    public MessageServlet() {
        this.messageService = MessageServiceFactory.getInstance();
        this.userService = UserServiceFactory.getInstance();
        this.messageService.setService(userService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(USER_SESSION_ATTRIBUTE_NAME) == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authorized");
            return;
        }
        UserDTO currentUser = (UserDTO) session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);

        List<MessageDTO> userMessages = messageService.getMessagesForUser(currentUser.getId());

        req.setAttribute("userMessages", userMessages);
        req.getRequestDispatcher("/ui/user/incoming_messages").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(USER_SESSION_ATTRIBUTE_NAME) == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authorized");
            return;
        }
        UserDTO currentUser = (UserDTO) session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);

        String toUsername = req.getParameter(TO_PARAM_NAME);
        String messageText = req.getParameter(TEXT_PARAM_NAME);

        if (toUsername == null || toUsername.isEmpty() || messageText == null || messageText.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "To or text fields are empty");
            return;
        }

        UserDTO recipient = userService.findByUsername(toUsername);
        if (recipient == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recipient with such username does not exist");
            return;
        }

        MessageCreateDTO messageToSave = new MessageCreateDTO(currentUser, recipient, messageText);
        messageService.save(messageToSave);

        resp.setStatus(HttpServletResponse.SC_CREATED); // HTTP status 201
        resp.sendRedirect(req.getContextPath() + "/ui/user/message");
    }
}

