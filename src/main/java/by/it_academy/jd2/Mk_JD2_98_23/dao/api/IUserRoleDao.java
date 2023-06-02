package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;

public interface IUserRoleDao extends ICRUDDao <UserRoleDTO> {
    void remove(int id);
}