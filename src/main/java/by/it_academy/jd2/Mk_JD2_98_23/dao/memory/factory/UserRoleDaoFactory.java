package by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserRoleDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.UserRoleMemoryDao;

public class UserRoleDaoFactory {
    private static volatile IUserRoleDao instance;

    private UserRoleDaoFactory() {
    }

    public static IUserRoleDao getInstance() {
        if (instance == null)  {
            synchronized (UserRoleDaoFactory.class) {
                if (instance == null) {
                    instance = new UserRoleMemoryDao();
                }
            }

        }
        return instance;
    }
}
