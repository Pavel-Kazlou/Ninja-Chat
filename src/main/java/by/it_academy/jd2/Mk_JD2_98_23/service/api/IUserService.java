package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserRoleDao;

import java.util.List;

public interface IUserService extends ICRUDService<UserDTO, UserCreateDTO> {
    void setService(IUserRoleDao userRoleDao);

    UserDTO validate(String username, String password);

    UserDTO findByUsername(String username);

    UserRoleDTO defaultRole();

    void addRole(int userId, int roleId);

    void removeRole(int userId, int roleId);

    List<Integer> getRoleIds(int userId);

    List<String> getRoleNames(int userId);
}
