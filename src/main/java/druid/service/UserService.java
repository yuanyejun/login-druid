package druid.service;



import druid.entity.User;
import java.util.List;

public interface UserService{

    List<User> selectAll();

    int update(User user);

    User selectOne(Integer id);

    int delete(Integer id);

    int selectTrue(String username,String password);
}
