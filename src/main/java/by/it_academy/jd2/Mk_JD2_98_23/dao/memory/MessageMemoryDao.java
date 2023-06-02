package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageMemoryDao implements IMessageDao {
    private final Map<Integer, MessageDTO> messages = new ConcurrentHashMap<>();

    public MessageMemoryDao() {
    }

    @Override
    public List<MessageDTO> get() {
        return new ArrayList<>(this.messages.values());
    }

    @Override
    public MessageDTO get(int id) {
        return this.messages.get(id);
    }

    @Override
    public MessageDTO save(MessageDTO item) {
        this.messages.put(item.getId(), item);
        return item;
    }
}