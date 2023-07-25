package druid.dao.impl;

import druid.dao.BaseDao;
import druid.dao.UserDao;
import druid.entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User getByUserId(Integer id) {
        String sql = "select * from user where uid = ?";
        return selectOne(sql,id);
    }

    @Override
    public List<User> getAllUser() {
        String sql = "select * from user";
        return selectAll(sql);
    }

    @Override
    public int deleteByUserId(Integer id) {
        String sql = "delete from user where uid = ?";
        return delete(sql,id);
    }

    @Override
    public int updateByUserId(User user) {
        String sql = "update user set username = ?,password = ? where uid = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public User selectUserAndPassword(String username, String password) {
        String sql = "select username,password from user where username = ? and password = ?";
        return selectUserAndPassword(sql,username,password);
    }

}
