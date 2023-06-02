package by.it_academy.jd2.Mk_JD2_98_23.service.factory;


import by.it_academy.jd2.Mk_JD2_98_23.controllers.listeners.ActiveSessionsListener;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.MessageDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.UserDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.UserRoleDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.MessageService;
import by.it_academy.jd2.Mk_JD2_98_23.service.StatisticsService;
import by.it_academy.jd2.Mk_JD2_98_23.service.UserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IStatisticsService;

public class StatisticsServiceFactory {
    private static volatile IStatisticsService instance;

    private StatisticsServiceFactory() {
    }

    public static IStatisticsService getInstance() {
        if (instance == null) {
            synchronized (StatisticsServiceFactory.class) {
                if (instance == null) {
                    instance = new StatisticsService(new ActiveSessionsListener(), new MessageService(MessageDaoFactory.getInstance()), new UserService(UserDaoFactory.getInstance(), UserRoleDaoFactory.getInstance()));
                }
            }
        }

        return instance;
    }
}