package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory.UserRoleDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.UserRoleService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserRoleService;

public class UserRoleServiceFactory {
    private static volatile IUserRoleService instance;

    private UserRoleServiceFactory() {
    }

    public static IUserRoleService getInstance() {
        if (instance == null) {
            synchronized (UserRoleServiceFactory.class) {
                if (instance == null) {
                    instance = new UserRoleService(UserRoleDaoFactory.getInstance());
                }
            }
        }

        return instance;
    }
}
