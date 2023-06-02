package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.UserDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.UserRoleDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.UserService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserService;

public class UserServiceFactory {
    private static volatile IUserService instance;

    private UserServiceFactory() {
    }

    public static IUserService getInstance() {
        if (instance == null)  {
            synchronized (UserServiceFactory.class) {
                if (instance == null) {
                    instance = new UserService(UserDaoFactory.getInstance(), UserRoleDaoFactory.getInstance());
                }
            }
        }

        return instance;
    }
}
