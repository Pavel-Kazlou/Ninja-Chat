package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;

public interface IUserRoleService extends ICRUDService<UserRoleDTO, UserRoleCreateDTO> {
    void remove(int id);
}
