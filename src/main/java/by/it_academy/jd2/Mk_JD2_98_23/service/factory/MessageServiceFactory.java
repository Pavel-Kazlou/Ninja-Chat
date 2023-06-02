package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.MessageDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.MessageService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IMessageService;

public class MessageServiceFactory {
    private static volatile IMessageService instance;

    private MessageServiceFactory() {
    }

    public static IMessageService getInstance() {
        if (instance == null)  {
            synchronized (MessageServiceFactory.class) {
                if (instance == null) {
                    instance =new MessageService(MessageDaoFactory.getInstance());
                }
            }
        }

        return instance;
    }
}
