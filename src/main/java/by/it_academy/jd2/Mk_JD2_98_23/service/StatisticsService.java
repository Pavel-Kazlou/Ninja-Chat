package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.controllers.listeners.ActiveSessionsListener;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IStatisticsService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;


public class StatisticsService implements IStatisticsService {
    private final ActiveSessionsListener sessionListener;
    private final IMessageService messageService;
    private final IUserService userService;


    public StatisticsService(ActiveSessionsListener sessionListener, IMessageService messageService, IUserService userService) {
        this.sessionListener = sessionListener;
        this.messageService = messageService;
        this.userService = userService;
    }

    @Override
    public int getActiveSessions() {
        return sessionListener.getActiveSessions();
    }

    @Override
    public int getUserCount() {
        return userService.get().size();
    }

    @Override
    public int getMessageCount() {
        return messageService.get().size();
    }
}
