package by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.MessageMemoryDao;

public class MessageDaoFactory {
    private static volatile IMessageDao instance;

    private MessageDaoFactory() {
    }

    public static IMessageDao getInstance() {
        if (instance == null)  {
            synchronized (MessageDaoFactory.class) {
                if (instance == null) {
                    instance = new MessageMemoryDao();
                }
            }

        }

        return instance;
    }
}
