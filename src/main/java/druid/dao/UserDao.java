package druid.dao;

import druid.entity.User;
import java.util.List;

public interface UserDao {


    User getByUserId(Integer id);

    List<User> getAllUser();

    int deleteByUserId(Integer id);

    int updateByUserId(User user);

    User selectUserAndPassword(String username,String password);
}
