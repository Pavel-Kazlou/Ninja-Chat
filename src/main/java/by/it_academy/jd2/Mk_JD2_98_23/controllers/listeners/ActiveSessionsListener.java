package by.it_academy.jd2.Mk_JD2_98_23.controllers.listeners;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ActiveSessionsListener implements HttpSessionListener {
    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
    }

    public int getActiveSessions() {
        return activeSessions;
    }
}