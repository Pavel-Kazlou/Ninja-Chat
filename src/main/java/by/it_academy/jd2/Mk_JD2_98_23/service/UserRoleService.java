package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserRoleDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IUserRoleService;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    private final IUserRoleDao userRoleDao;

    public UserRoleService(IUserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRoleDTO> get() {
        return userRoleDao.get();
    }

    @Override
    public UserRoleDTO get(int id) {
        return userRoleDao.get(id);
    }

    @Override
    public UserRoleDTO save(UserRoleCreateDTO item) {
        int maxCurrentId = this.get()
                .stream()
                .mapToInt(UserRoleDTO::getId)
                .max()
                .orElseThrow();

        UserRoleDTO dto = new UserRoleDTO();
        dto.setId(maxCurrentId + 1);
        dto.setName(item.getName());

        return userRoleDao.save(dto);
    }

    @Override
    public void remove(int id) {
        userRoleDao.remove(id);
    }
}