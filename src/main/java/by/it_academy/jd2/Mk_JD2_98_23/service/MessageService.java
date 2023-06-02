package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;

import java.time.LocalDateTime;
import java.util.*;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;
    private IUserService userService;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void setService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<MessageDTO> get() {
        return messageDao.get();
    }

    @Override
    public MessageDTO get(int id) {
        return messageDao.get(id);
    }

    @Override
    public MessageDTO save(MessageCreateDTO item) {
        OptionalInt maxId = this.get()
                .stream()
                .mapToInt(MessageDTO::getId)
                .max();
        int maxCurrentId = maxId.isPresent() ? maxId.getAsInt() : 0;

        MessageDTO dto = new MessageDTO();
        dto.setId(maxCurrentId + 1);
        dto.setDateTime(LocalDateTime.now());
        dto.setFrom(item.getFrom());
        dto.setTo(item.getTo());
        dto.setText(item.getText());

        return messageDao.save(dto);
    }

    @Override
    public List<MessageDTO> getMessagesForUser(int userId) {
        List<MessageDTO> messages = new ArrayList<>();
        UserDTO user = userService.get(userId);
        List<MessageDTO> allMessages = messageDao.get();

        if (user == null) {
            return messages;
        }
        for (MessageDTO message : allMessages) {
            if (message.getFrom().equals(user) || message.getTo().equals(user)) {
                messages.add(message);
            }
        }

        return messages;
    }

    @Override
    public List<MessageDTO> getMessagesForUsers(int currentUserId, int recipientUserId) {
        UserDTO currentUser = userService.get(currentUserId);
        UserDTO recipientUser = userService.get(recipientUserId);

        if (currentUser == null || recipientUser == null) {
            return Collections.emptyList();
        }

        List<MessageDTO> allMessages = messageDao.get();
        List<MessageDTO> filteredMessages = new ArrayList<>();

        for (MessageDTO message : allMessages) {
            if ((message.getFrom().getId() == currentUserId && message.getTo().getId() == recipientUserId) ||
                    (message.getFrom().getId() == recipientUserId && message.getTo().getId() == currentUserId)) {
                filteredMessages.add(message);
            }
        }

        Collections.sort(filteredMessages, Comparator.comparing(MessageDTO::getDateTime));

        return filteredMessages;
    }
}