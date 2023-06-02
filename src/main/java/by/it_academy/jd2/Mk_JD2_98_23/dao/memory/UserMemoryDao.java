package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.UserRoleDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IUserDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMemoryDao implements IUserDao {
    private final Map<Integer, UserDTO> users = new ConcurrentHashMap<>();

    public UserMemoryDao() {
        {
            UserDTO dto = new UserDTO(1, "admin", "admin", "admin", "admin", LocalDate.now(), LocalDateTime.now(), new ArrayList<>());

            users.put(dto.getId(), dto);
        }
        {
            UserDTO dto = new UserDTO(2, "user", "user", "user", "user", LocalDate.now(), LocalDateTime.now(), new ArrayList<>());

            users.put(dto.getId(), dto);
        }
        {
            UserDTO dto = new UserDTO(3, "друг", "друг", "друг", "друг", LocalDate.now(), LocalDateTime.now(), new ArrayList<>());

            users.put(dto.getId(), dto);
        }
        {
            UserDTO dto = new UserDTO(4, "friend", "friend", "friend", "friend", LocalDate.now(), LocalDateTime.now(), new ArrayList<>());

            users.put(dto.getId(), dto);
        }
    }

    @Override
    public List<UserDTO> get() {
        return new ArrayList<>(this.users.values());
    }

    @Override
    public UserDTO get(int id) {
        return this.users.get(id);
    }

    @Override
    public UserDTO save(UserDTO item) {
        return this.users.put(item.getId(), item);
    }

    @Override
    public UserDTO findByUsername(String username) {
        for (UserDTO user : this.users.values()) {
            if (user.getUserName().equals(username)) {

                return user;
            }
        }

        return null;
    }

    @Override
    public void addRole(int userId, UserRoleDTO role) {
        users.get(userId).getRoles().add(role);
    }

    @Override
    public void removeRole(int userId, int roleId) {
        users.get(userId).getRoles().remove(roleId);
    }
}
