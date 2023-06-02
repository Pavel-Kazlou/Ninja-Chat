package by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.UserMemoryDao;

public class UserDaoFactory {
    private static volatile IUserDao instance;

    private UserDaoFactory() {
    }

    public static IUserDao getInstance() {
        if (instance == null)  {
            synchronized (UserDaoFactory.class) {
                if (instance == null) {
                    instance = new UserMemoryDao();
                }
            }

        }
        return instance;
    }
}
