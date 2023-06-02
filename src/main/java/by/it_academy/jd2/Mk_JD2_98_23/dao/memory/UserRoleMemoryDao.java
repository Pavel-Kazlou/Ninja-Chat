package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserRoleDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRoleMemoryDao implements IUserRoleDao {
    private final Map<Integer, UserRoleDTO> role = new ConcurrentHashMap<>();

    public UserRoleMemoryDao() {
        {
            UserRoleDTO dto = new UserRoleDTO(1, "ADMIN");
            role.put(dto.getId(), dto);
        }
        {
            UserRoleDTO dto = new UserRoleDTO(2, "USER");
            role.put(dto.getId(), dto);
        }
    }

    @Override
    public List<UserRoleDTO> get() {
        return new ArrayList<>(this.role.values());
    }

    @Override
    public UserRoleDTO get(int id) {
        return this.role.get(id);
    }

    @Override
    public UserRoleDTO save(UserRoleDTO item) {
        this.role.put(item.getId(), item);

        return item;
    }

    @Override
    public void remove(int id) {
        this.role.remove(id);
    }
}
