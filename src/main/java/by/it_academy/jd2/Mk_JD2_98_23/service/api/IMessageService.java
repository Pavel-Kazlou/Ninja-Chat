package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageDTO;

import java.util.List;

public interface IMessageService extends ICRUDService <MessageDTO, MessageCreateDTO>{
    List<MessageDTO> getMessagesForUser(int userId);

    void setService(IUserService userService);

    List<MessageDTO> getMessagesForUsers(int currentUserId, int recipientUserId);
}