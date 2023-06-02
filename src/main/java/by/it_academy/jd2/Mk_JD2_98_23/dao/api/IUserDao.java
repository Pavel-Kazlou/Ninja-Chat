package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;

public interface IUserDao extends ICRUDDao<UserDTO> {
    UserDTO findByUsername(String username);

    void addRole(int userId, UserRoleDTO role);

    void removeRole(int userId, int roleId);
}