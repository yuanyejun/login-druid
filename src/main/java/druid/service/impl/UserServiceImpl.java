package druid.service.impl;

import druid.dao.UserDao;
import druid.dao.impl.UserDaoImpl;
import druid.entity.User;
import druid.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> selectAll() {
        return userDao.getAllUser();
    }

    @Override
    public int update(User user) {
        return userDao.updateByUserId(user);
    }

    @Override
    public User selectOne(Integer id) {
        return userDao.getByUserId(id);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteByUserId(id);
    }

    @Override
    public int selectTrue(String username, String password) {

        User user = userDao.selectUserAndPassword(username, password);
        if (user != null){
            return 1;
        }
        return 0;
    }
}
